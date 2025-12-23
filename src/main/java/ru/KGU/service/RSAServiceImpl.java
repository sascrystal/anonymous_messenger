package ru.KGU.service;

import lombok.AllArgsConstructor;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
@Service
@AllArgsConstructor
public class RSAServiceImpl implements RSAService {
    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    @Override
    public KeyPair generateKeys(int keySize) {
        try {
            RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
            generator.init(new RSAKeyGenerationParameters(
                    BigInteger.valueOf(65537),
                    new SecureRandom(),
                    keySize,
                    100
            ));

            AsymmetricCipherKeyPair bcKeyPair = generator.generateKeyPair();

            return new KeyPair(
                    KeyFactory.getInstance("RSA", "BC")
                            .generatePublic(new RSAPublicKeySpec(
                                    ((RSAKeyParameters) bcKeyPair.getPublic()).getModulus(),
                                    ((RSAKeyParameters) bcKeyPair.getPublic()).getExponent()
                            )),
                    KeyFactory.getInstance("RSA", "BC")
                            .generatePrivate(new RSAPrivateCrtKeySpec(
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getModulus(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getPublicExponent(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getExponent(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getP(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getQ(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getDP(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getDQ(),
                                    ((RSAPrivateCrtKeyParameters) bcKeyPair.getPrivate()).getQInv()
                            ))
            );


        } catch (Exception e) {
            throw new RuntimeException("Error generating RSA keys", e);
        }
    }



    @Override
    public  byte[] encrypt(String plainText, PublicKey publicKey) throws Exception{
        byte[] data = plainText.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);

    }

    @Override
    public String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(cipherText));

    }



}
