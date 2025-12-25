package ru.KGU.service;

import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.rest.dto.JwtAuthenticationDto;
import ru.KGU.rest.dto.RefreshTokenDto;
import ru.KGU.rest.dto.UserCredentialsDto;

import java.util.List;

public interface UserService {
    JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto);

    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto);

    User createUser(User user);

    User getUser(String id);

    void updatePassword(User user);

    void updateRecoveryPassword(User user);

    User updateName(User user);

    List<User> getUsersByGroup(Group group);

    void deleteUser(String id);

    Boolean isUserExist(String id);

    Boolean passwordIsCorrect(String id, String password);

}
