package ru.KGU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;
import ru.KGU.repository.GroupRepository;
import ru.KGU.repository.UserGroupRepository;
import ru.KGU.repository.UserRepository;
import ru.KGU.rest.dto.JwtAuthenticationDto;
import ru.KGU.rest.dto.RefreshTokenDto;
import ru.KGU.rest.dto.UserCredentialsDto;
import ru.KGU.security.Jwt.JwtService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;
    private final PasswordEncoder getPasswordEncoder;
    private final GroupRepository groupRepository;
    private final JwtService jwtService;

    @Override
    public User createUser(User user) {
        user.setPassword(getPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateName(User user) {
        return null;
    }

    @Override
    public void updateRecoveryPassword(User user) {

    }

    @Override
    public void updatePassword(User user) {

    }

    @Override
    public List<User> getUsersByGroup(Group group) {
        return userGroupRepository.findByGroup(group).stream()
                .map(UserGroup::getUser)
                .toList();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


    @Override
    public Boolean isUserExist(String id) {
        User user = getUser(id);
        return user != null;
    }

    @Override
    public Boolean passwordIsCorrect(String id, String password) {
        User user = getUser(id);
        String encodedPassword = getPasswordEncoder.encode(password);
        return user.getPassword().equals(encodedPassword);
    }

    @Override
    public JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) {
        User user = findByCredentials(userCredentialsDto);
        return jwtService.generateAuthToken(user.getId());
    }

    @Override
    public JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) {
        String refreshToken = refreshTokenDto.getRefreshToken();
        if (refreshToken != null && jwtService.validateToken(refreshToken)) {
            User user = getUser(jwtService.getIdFromToken(refreshToken));
            return jwtService.refreshBaseToken(user.getId(), refreshToken);
        }
        throw new UsernameNotFoundException("Invalid refresh token");
    }

    private User findByCredentials(UserCredentialsDto userCredentialsDto) {
        User optionalUser = userRepository.findById(userCredentialsDto.getId());
        if (optionalUser != null) {
            User user = optionalUser;
            if (getPasswordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User or password is not correct");
    }
}
