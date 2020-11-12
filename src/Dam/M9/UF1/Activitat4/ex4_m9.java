package Ex4_m9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ex4_m9 {
   
    public static void main(String[] args) throws IOException {
	
        Scanner tecla = new Scanner(System.in);
	String llave;
        String fichero;
        int Tllave = 256; 
        
	System.out.print("Inserta la llave clave ");
	llave = tecla.nextLine();
	System.out.print("Inserta el archivo que quieres encriptar y desencriptar: ");
	fichero = tecla.nextLine();
        
        Path ruta = Paths.get(fichero);
	SecretKey sKey = passwordKeyGeneration(llave, Tllave);

	byte[] data;
        data = Files.readAllBytes(ruta);
	byte[] encryptData;
        encryptData = encryptData(sKey, data);
	byte[] decryptData;
        decryptData = decryptData(sKey, encryptData);

	String encriptado;
        encriptado = new String(encryptData);
	String desencriptado;
        desencriptado = new String(decryptData);
        
        String[] Partesdelaruta;
        Partesdelaruta = fichero.split("\\.");
        String Primeramitad;
        String Segundamitad;
        Primeramitad = Partesdelaruta[0];
        Segundamitad = Partesdelaruta[1];
        
        File file_ = new File(Primeramitad + "_X." + Segundamitad);
        FileWriter fw = new FileWriter(file_);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(encriptado);
        bw.close();
        File file_1 = new File(Primeramitad + "_Y." + Segundamitad);
        FileWriter fw1 = new FileWriter(file_1);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        bw1.write(desencriptado);
        bw1.close();
        
        System.out.println("La informarcion encriptada se ha guardado en el archivo " + file_);
        
        System.out.println("La informarcion desencriptada se ha guardado en el archivo " + file_1);    
    }

   
    public static SecretKey passwordKeyGeneration(String text, int keySize) {
	SecretKey sKey = null;
        
	if ((keySize == 128) || ( keySize == 192) || (keySize == 256)) {
            try {
                byte[] data = text.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize/8);
                sKey = new SecretKeySpec(key, "AES");
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                System.out.println("Error generant la clau: " + ex);
            }
	}
        
	return sKey;
    }

    
    public static byte[] encryptData(SecretKey sKey, byte[] data) {
	byte[] encryptedData = null;
        
	try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
	}catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
	}
        
	return encryptedData;
    }


   
    public static byte[] decryptData(SecretKey sKey1, byte[] data) {
        byte[] encryptedData = null;
        
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKey1);
            encryptedData = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println("Error desxifrant les dades: " + ex);
        }
        
        return encryptedData;
    }
}
