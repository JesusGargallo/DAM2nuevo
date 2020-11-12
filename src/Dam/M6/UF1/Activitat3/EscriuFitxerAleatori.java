package exercici3;

import java.io.*;
import java.util.Scanner;


public class EscriuFitxerAleatori {
	public static void main(String[] args) throws IOException {
                Scanner sc = new Scanner(System.in);
		File fitxer = new File("fitxerAleatori.txt");
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		String dni[] = new String[5];
		String nom[] = new String[5];
		String cognom[] = new String[5];
		String nacionalidad[] = new String[5];
		int telefon[] = new int[5];
                
                /*
                
                for(int i = 0; i<5 ;i++){
                    System.out.println("Nou id");
                    System.out.print("DNI : ");
                    dni[i] = sc.next();
                    System.out.print("Nombre : ");
                    nom[i] = sc.next();
                    System.out.print("Apellido : ");
                    cognom[i] = sc.next();
                    System.out.print("Nacionalidad : ");
                    nacionalidad[i] = sc.next();
                    System.out.print("Telefono : ");
                    telefon[i] = sc.nextInt();
                    System.out.println();
                }
               */
                 
                 
                StringBuffer buffer = null;
		
		for (int i=0; i<dni.length; i++) {
			aleatoriFile.writeInt(i+1);
                        
                        System.out.print("DNI : ");
                        dni[i] = sc.next();
			buffer = new StringBuffer (dni[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
                        
                        System.out.print("Nombre : ");
			nom[i] = sc.next();
			buffer = new StringBuffer (nom[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
                        
                         System.out.print("Apellido : ");
                        cognom[i] = sc.next();
			buffer = new StringBuffer (cognom[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
                        
                        System.out.print("Nacionalidad : ");
                        nacionalidad[i] = sc.next();
                        buffer = new StringBuffer (nacionalidad[i]);
			buffer.setLength(25);
			aleatoriFile.writeChars(buffer.toString());
                        
                        System.out.print("Telefono : ");
                        telefon[i] = sc.nextInt();
                        aleatoriFile.writeInt(telefon[i]);
			
		}
                 
                     
                sc.close();
		aleatoriFile.close();
	}
}

