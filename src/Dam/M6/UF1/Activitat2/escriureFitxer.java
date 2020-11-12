package exercici2;

import java.io.*;
import java.util.Scanner;


public class escriureFitxer {
    
	public static void main(String[] args) throws IOException {
            
            Scanner sc = new Scanner(System.in);
		Marca marca;
		File fitxer = new File("E:\\Segundo Superior\\M6\\coches.txt");
		FileOutputStream fileout = new FileOutputStream(fitxer);
		ObjectOutputStream dataOuMarc = new ObjectOutputStream(fileout);
		String marc[] = {"Audi", "Ferrari", "Ford"};
		String model[] = {"R8", "Corvette", "Focus"};
                int any[] = {2012, 2018, 2002};
                String matricula[] = {"4356AER", "4567GHR", "7823HOL"};
		for (int i=0; i<marc.length; i++){//Crea la comarca
			marca = new Marca(marc[i], model[i], any[i], matricula[i]);
			dataOuMarc.writeObject(marca);//L'escriu al fixer
		}
                
                int Anyo;
                String marcao, modelao, matriculao;

               
                    System.out.print("Marca: ");
                    marcao = sc.next();
                    System.out.print("Model: ");
                    modelao = sc.next();
                    System.out.print("Any: ");
                
                    Anyo = sc.nextInt();
                    System.out.print("Matricula: ");
                    matriculao = sc.next();
                    
                    
                    Marca coches;
                    
                    coches = new Marca(marcao, modelao, Anyo, matriculao);
                    dataOuMarc.writeObject(coches);
                    
               
                
                
                
                
		dataOuMarc.close();//Tanca el stream de sortida
                
                sc.close();
	}
}

