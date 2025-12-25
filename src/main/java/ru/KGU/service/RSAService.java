package ru.KGU.service;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface RSAService {
    KeyPair generateKeys(int keySize);

    byte[] encrypt(String plainText, PublicKey publicKey) throws Exception;

    String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception;


}
