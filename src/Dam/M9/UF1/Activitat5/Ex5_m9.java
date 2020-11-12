package ex5_m9;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Ex5_m9 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String frase;
        int numero = 512;
        
        long inicio = System.currentTimeMillis();
        KeyPair keys;
        keys = randomGenerate(numero);
        PrivateKey privatekey = keys.getPrivate();
        PublicKey publickey = keys.getPublic();
        long fin = System.currentTimeMillis() - inicio;
        
        System.out.println("Frase para encriptar: ");
        frase = sc.nextLine();
        
        System.out.println("Frase encriptada: ");
        byte[] data;
        data = frase.getBytes();
        byte[] encriptada;
        encriptada = encryptData(data, publickey);
        
        String textocrip = new String(encriptada);
        System.out.println(textocrip);
        System.out.println("Frase desencriptada: ");
        byte[] desencriptada;
        desencriptada = decryptData(encriptada, privatekey);
        String textodecrip = new String(desencriptada);
        System.out.println(textodecrip);
         
        System.out.println(fin);
    }
    
public static KeyPair randomGenerate(int longuitudClau) {
    KeyPair keys = null;
    try {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(longuitudClau);
        keys = keyGen.genKeyPair();
    }
    catch (Exception ex) {
        System.err.println("Generador no disponible.");
    }
    return keys;
}
    
public static byte[] encryptData(byte[] data, PublicKey pub) {
    byte[] encryptedData = null;
    try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
        cipher.init(Cipher.ENCRYPT_MODE, pub);
        encryptedData = cipher.doFinal(data);
    }
    catch (Exception ex) {
        System.err.println("Error xifrant: " + ex);
    }
    return encryptedData;
}

public static byte[] decryptData(byte[] data, PrivateKey pub) {
    byte[] encryptedData = null;
    try {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
        cipher.init(Cipher.DECRYPT_MODE, pub);
        encryptedData = cipher.doFinal(data);
    }
    catch (Exception ex) {
        System.err.println("Error desxifrant: " + ex);
    }
    return encryptedData;
}

    
}


