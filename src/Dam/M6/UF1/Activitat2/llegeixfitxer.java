package exercici2;
import java.io.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class llegeixfitxer {
    
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
             
              Scanner sc = new Scanner(System.in);
              int buscar;
              String buscaar;
		
		Marca marca;
		
		File fitxer = new File("E:\\Segundo Superior\\M6\\coches.txt");
		
		FileInputStream filein = new FileInputStream(fitxer);
		
		ObjectInputStream dataInMarc = new ObjectInputStream(filein);
                
                int opcion;
                
                System.out.println("Tria una opcio");
                System.out.println("1 - Guardar cotxes al fitxer");
                System.out.println("2 - Buscar un cotxe");
                opcion = sc.nextInt();
		
                if (opcion == 1){
                    try {
                            while (true){//Llegeix el fitxer

                                    marca = (Marca) dataInMarc.readObject();
                                    System.out.print("Marca(" + marca.getMarca() + ") ");
                                    System.out.print("Model(" + marca.getModel() + ") ");
                                    System.out.print("Any(" + marca.getAny() + ") ");
                                    System.out.println("Matricula(" + marca.getMatricula() + ")");
                            }
                    }catch (EOFException eo) {}
                    
                }else if (opcion == 2){
                    System.out.println("Quin parametre vols bsucar");
                    System.out.println("1 - Marca");
                    System.out.println("2 - Modelo");
                    System.out.println("3 - Any");
                    System.out.println("4 - Matricula");
                    opcion = sc.nextInt();
                    
                
                if(opcion == 1){
                    System.out.println("Nombre de la marca");
                    buscaar = sc.next();
                    
                    try {
                            while (true){//Llegeix el fitxer

                                    marca = (Marca) dataInMarc.readObject();
                                    if (buscaar.equalsIgnoreCase(marca.getMarca())){
                                    System.out.print("Marca(" + marca.getMarca() + ") ");
                                    System.out.print("Model(" + marca.getModel() + ") ");
                                    System.out.print("Any(" + marca.getAny() + ") ");
                                    System.out.println("Matricula(" + marca.getMatricula() + ")");
                                    
                                    }
                            }
                    }catch (EOFException eo) {}
                }else if (opcion == 2){
                    System.out.println("Nombre del modelo");
                    buscaar = sc.next();
                    
                    try {
                            while (true){//Llegeix el fitxer

                                    marca = (Marca) dataInMarc.readObject();
                                    if (buscaar.equalsIgnoreCase(marca.getModel())){
                                    System.out.print("Marca(" + marca.getMarca() + ") ");
                                    System.out.print("Model(" + marca.getModel() + ") ");
                                    System.out.print("Any(" + marca.getAny() + ") ");
                                    System.out.println("Matricula(" + marca.getMatricula() + ")");
                                    
                                    }
                            }
                    }catch (EOFException eo) {}
                } else if (opcion == 3){
                    System.out.println("El año de fabrica");
                    buscar = sc.nextInt();
                    
                    try {
                            while (true){//Llegeix el fitxer

                                    marca = (Marca) dataInMarc.readObject();
                                    if (buscar == marca.getAny()){
                                    System.out.print("Marca(" + marca.getMarca() + ") ");
                                    System.out.print("Model(" + marca.getModel() + ") ");
                                    System.out.print("Any(" + marca.getAny() + ") ");
                                    System.out.println("Matricula(" + marca.getMatricula() + ")");
                                    
                                    }
                            }
                    }catch (EOFException eo) {}
                    
                }else if (opcion == 4){
                    System.out.println("El numero de la matricula");
                    buscaar = sc.next();
                    
                    try {
                            while (true){//Llegeix el fitxer

                                    marca = (Marca) dataInMarc.readObject();
                                    if (buscaar.equalsIgnoreCase(marca.getMatricula())){
                                    System.out.print("Marca(" + marca.getMarca() + ") ");
                                    System.out.print("Model(" + marca.getModel() + ") ");
                                    System.out.print("Any(" + marca.getAny() + ") ");
                                    System.out.println("Matricula(" + marca.getMatricula() + ")");
                                    
                                    }
                            }
                    }catch (EOFException eo) {}
                    
                }
                }
		dataInMarc.close();
	}	
}



  


   
