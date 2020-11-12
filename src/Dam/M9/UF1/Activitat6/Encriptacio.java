package ex6_m9;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import static sun.security.krb5.internal.ktab.KeyTabConstants.keySize;

public class Encriptacio {
    public static void main(String[] args) throws NoSuchAlgorithmException, 
            InvalidKeySpecException, IOException, NoSuchProviderException {
        //variables
        Scanner sc = new Scanner(System.in);
        String publica;
        String texto;
        
        byte[] arraypublica;
        
        SecretKey sKey = generadordellaves();
				
        byte[] arraysKey = sKey.getEncoded();
        
        //para poner el nombre de tu clave publica
        System.out.println("Nombre del archivo de la clave publica: ");
        publica = sc.nextLine();
        arraypublica = Files.readAllBytes(Paths.get(publica));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        
        // esto para quitar el begin y el end poner nada
        String publicKeyContent = new String(arraypublica);
        publicKeyContent = publicKeyContent
                .replace("—-BEGIN RSA PUBLIC KEY—-", "")
                .replace("—-END RSA PUBLIC KEY—-", "")
                .replace("\n", "");

        byte[] publicKeyDecoded = Base64.getDecoder()
                .decode(publicKeyContent);
        

        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyDecoded);
        PublicKey publicKey;
        publicKey = keyFactory.generatePublic(publicKeySpec);
        
        
        //para encriptar la frase que pongas
        System.out.println("Que frase quieres encriptar: ");
        texto = sc.nextLine();
        
        
        //los bytes
        byte[] arraytexto;
        arraytexto = texto.getBytes();
        byte[] arrayencrip;
        arrayencrip = encryptData(sKey,arraytexto);
        
        
        byte[] clavesimetricaencrip;
        clavesimetricaencrip = encryptKey(arraysKey,publicKey);
        
        //es para guardas la frase en esos ficheros
        try{
            BufferedOutputStream bos = new BufferedOutputStream
            (new FileOutputStream("ZZZ_clau_encriptada"));
            bos.write(clavesimetricaencrip);
            bos.flush();
        } catch (Exception ex) {
            System.err.println("Hi ha hagut un error");
        }
        
        try{
            BufferedOutputStream bos = new BufferedOutputStream
            (new FileOutputStream("ZZZ_missatge_encriptat"));
            bos.write(arrayencrip);
            bos.flush();
        } catch (Exception ex) {
            System.err.println("Hi ha hagut un error");
        }
    }
    
//los public statics
public static SecretKey generadordellaves() throws NoSuchAlgorithmException{
        SecretKey sKey = null;
        int kSize = 256;
        try{
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(kSize);
            sKey = kgen.generateKey();
        } catch (Exception ex){
            System.err.println("Generador no disponible.");
        }
        return sKey;
    }
//los public statics    
public static byte[] encryptData(SecretKey sKey, byte[] data) {
    byte[] encryptedData = null;
    try {
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, sKey);
    encryptedData = cipher.doFinal(data);
    }
    catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
    System.err.println("Error xifrant les dades: " + ex);
    }
    return encryptedData;
}
//los public statics
public static byte[] encryptKey(byte[] array, PublicKey pub) throws NoSuchProviderException {
    byte[] encryptedData = null;
    try {
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
    cipher.init(Cipher.ENCRYPT_MODE, pub);
    encryptedData = cipher.doFinal(array);
    }
    catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
    System.err.println("Error xifrant les dades: " + ex);
    }
    return encryptedData;
}
  
}
