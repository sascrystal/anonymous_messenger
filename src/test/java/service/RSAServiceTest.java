package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.KGU.service.RSAService;
import ru.KGU.service.RSAServiceImpl;

import java.security.KeyPair;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DisplayName("Класс RSAServiceTest")
@ExtendWith(MockitoExtension.class)
public class RSAServiceTest {


    public RSAService rsaService = new RSAServiceImpl();
    @Test
    @DisplayName("Должно выходить один и тот же текст")
    void shouldRSACommunicationWork() throws Exception {
        KeyPair keyPair = rsaService.generateKeys(2048);
        String text = "изначальный текст";
        byte[] bytes = rsaService.encrypt(text, keyPair.getPublic());
        String decryptedText = rsaService.decrypt(bytes, keyPair.getPrivate());
        assertThat(decryptedText).isEqualTo(text);
    }
    @Test
    @DisplayName("Должно выходить один и тот же текст c русскими и латинскими буквами")
    void shouldRSACommunicationWorkWithLatin() throws Exception {
        KeyPair keyPair = rsaService.generateKeys(2048);
        String text = "изначальный текст with Latin letters ";
        byte[] bytes = rsaService.encrypt(text, keyPair.getPublic());
        String decryptedText = rsaService.decrypt(bytes, keyPair.getPrivate());
        assertThat(decryptedText).isEqualTo(text);
    }

    @Test
    @DisplayName("Должны быть разные RSA ключи")
    void shouldRSAGeneratorWork() throws Exception {
        KeyPair keyPair = rsaService.generateKeys(2048);
        KeyPair keyPair2 = rsaService.generateKeys(2048);
        assertThat(keyPair.getPublic()).isNotEqualTo(keyPair2.getPublic());
        assertThat(keyPair.getPrivate()).isNotEqualTo(keyPair2.getPrivate());
    }
    @Test
    @DisplayName("Должно выходить один и тот же текст с lower case и upper case")
    void shouldRSACommunicationWorkWithLowerCaseAndUpperCase() throws Exception {
        KeyPair keyPair = rsaService.generateKeys(2048);
        String text = "изначальный текст С БоЛьШиМи";
        byte[] bytes = rsaService.encrypt(text, keyPair.getPublic());
        String decryptedText = rsaService.decrypt(bytes, keyPair.getPrivate());
        assertThat(decryptedText).isEqualTo(text);
    }
}
