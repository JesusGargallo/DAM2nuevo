package exercicio2;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class Exercicio2 {

     public static void main(String[] args) throws NoSuchAlgorithmException {
        byte [] code=keygenKeyGeneration(128).getEncoded();
		
        for (int i=0; i<code.length; i++) {
            System.out.println(Integer.toBinaryString(code[i] & 0xFF).replace(' ', '0')+ "-"+ code[i] );
        }
            System.out.println("Algoritme 2:");
        byte [] code2=keygenKeyGeneration2(56).getEncoded();
		
        for (int j=0; j<code2.length; j++) {
            System.out.println(Integer.toBinaryString(code2[j] & 0xFF).replace(' ', '0')+ "-"+ code2[j] );
        }
            System.out.println("Algoritme 3:");
        byte [] code3=keygenKeyGeneration3(256).getEncoded();
		
        for (int j=0; j<code3.length; j++) {
            System.out.println(Integer.toBinaryString(code3[j] & 0xFF).replace(' ', '0')+ "-"+ code3[j] );
        }
    }
    public static  SecretKey keygenKeyGeneration(int keySize) {
	SecretKey sKey = null;
		
	if ((keySize == 128 )|| (keySize == 192)|| ( keySize == 256)) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(keySize);
			sKey= kgen.generateKey();
				
		}catch (NoSuchAlgorithmException ex) {
			System.err.println("Generador no disponible" );
		}
		}
	return sKey;
	} 
	
	
	public static  SecretKey keygenKeyGeneration2(int keySize) {
            SecretKey sKey = null  ;
		
            if ((keySize == 56 )|| (keySize == 192)|| ( keySize == 256)) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("DES");
			kgen.init(keySize);
			sKey= kgen.generateKey();
				
		}catch (NoSuchAlgorithmException ex) {
			System.err.println("Generador no disponible" );
				
		}
	}
	return sKey;
	} 
        public static  SecretKey keygenKeyGeneration3(int keySize) {
            SecretKey sKey = null  ;
		
            if ((keySize == 56 )|| (keySize == 192)|| ( keySize == 256)) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("HmacSHA256");
			kgen.init(keySize);
			sKey= kgen.generateKey();
				
		}catch (NoSuchAlgorithmException ex) {
			System.err.println("Generador no disponible" );
				
		}
	}
	return sKey;
	} 
        
    }
    




