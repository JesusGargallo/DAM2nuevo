package Act3_M9;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Act3_M9 {

	public static void main(String[] args) {
		byte [] code1 = passwordKeyGeneration("Jesús",192).getEncoded();
		
		for (int i=0;i<code1.length;i++) {
			System.out.println( Integer.toBinaryString(code1[i]& 0xFF).replace(' ', '@') + code1[i]);
		}
		
	}
	
	
	public static SecretKey passwordKeyGeneration(String text, int keySize) {
	SecretKeySpec sKey = null;
	if ((keySize == 128)|| (keySize==192)||(keySize==256)) {
		try {
			
			byte[] data = text.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA");
			byte [] hash = md.digest(data);
                        byte [] key = Arrays.copyOf(hash, keySize/8);
			sKey = new SecretKeySpec(key, "AES");
			
		
			
		}catch(Exception ex) {
			System.err.println("Error al generar la clau."+ ex);
		}
	} return sKey;
}
	
	/*public static SecretKey contrasenya(String algoritmehash, int mida, String text )  {
		SecretKeySpec contra = null;
		try {
		MessageDigest md = MessageDigest.getInstance(algoritmehash);
		
		byte[] contrasenya = text.getBytes("UTF-8");
		// executem el mètode digest per que faci les operacions
		byte[] hash =md.digest(contrasenya);   
		// del hash obtingut, n’agafem la mida que necessitem
		byte[] key = Arrays.copyOf(hash, mida/8);
		
		
		contra = new SecretKeySpec(key, "AES");
		 
			
			
		}catch(Exception ex) {
			System.err.println("Error al generar la clau."+ ex);
		}
		return contra;
	}*/
	
	
	


}
