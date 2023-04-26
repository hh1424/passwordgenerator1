package edu.guilford;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    // Attributes for the encryption and decryption
    // The secret key is used to encrypt and decrypt the string
    private static SecretKeySpec secretKey;
    // The key is used to hash the secret key
    private static byte[] key;

    // This method sets the key for the encryption and decryption
    public static void setKey(String myKey) {
        // MessageDigest is used to hash the key
        MessageDigest sha = null;
        // Try and catch block to catch any errors that may occur while setting the key and hashing the key      
        try {
            // UTF-8 is used to encode the key
            key = myKey.getBytes("UTF-8");
            // SHA-1 is used to hash the key
            sha = MessageDigest.getInstance("SHA-1");
            // The key is hashed
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            // SecretKeySpec is used to create a new secret key
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // This method encrypts the string
    // The string is encrypted using the secret key
    public static String encrypt(String strToEncrypt, String secret) {
        // Try and catch block to catch any errors that may occur while encrypting the string
        try {
            // The key is set
            setKey(secret);
            // Cipher is used to encrypt the string
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // The cipher is initialized
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // The string is encrypted
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            // The error is printed to the console
            System.out.println("Error while encrypting: " + e.toString());
        }
        // If there is an error, null is returned
        return null;
    }

    // This method decrypts the string
    public static String decrypt(String strToDecrypt, String secret) {
        // Try and catch block to catch any errors that may occur while decrypting the string
        try {
            // The key is set
            setKey(secret);
            // Cipher is used to decrypt the string
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // The cipher is initialized
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // The string is decrypted
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            // The error is printed to the console
            System.out.println("Error while decrypting: " + e.toString());
        }
        // If there is an error, null is returned
        return null;
    }
}
