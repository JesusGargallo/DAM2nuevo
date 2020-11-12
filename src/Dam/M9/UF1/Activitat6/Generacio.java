package ex6_m9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Generacio {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //las variables
        int numero = 512;
        
        KeyPair keys;
        keys = randomGenerate(numero);
        PrivateKey privatekey = keys.getPrivate();
        PublicKey publickey = keys.getPublic();
       
        // private
        
        //esto para crear la clau privada
        Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPRIVADA")) {
        out.write("—-BEGIN RSA PRIVATE KEY—-");
        out.write("\n");

        out.write(encoder.encodeToString(privatekey.getEncoded()));
        out.write("\n");

        out.write("—-BEGIN RSA PRIVATE KEY—-");
        out.write("\n");
        out.close();
        
        } catch (IOException ex) {
           System.out.println("No se ha guardado la llave privada"); 
        }
        
        //para crear la clau publica
        try (FileWriter out = new FileWriter("clauPublica")) {
        out.write("—-BEGIN RSA PUBLIC KEY—-");
        out.write("\n");

        out.write(encoder.encodeToString(publickey.getEncoded()));
        out.write("\n");

        out.write("—-END RSA PUBLIC KEY—-");
        out.write("\n");
        out.close();
        
        } catch (IOException ex) {
            System.out.println("No se ha guardado la llave publica");
        }
        
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
    
    
}
