package exercici3;

import java.io.*;
import java.util.*;

public class ConsultarFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("fitxerAleatori.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		int apuntador = 0, telefon, id, seleccio, opcion = 0;
		
		char dni[] = new char[25], nom[] = new char[25], cognom[] = new char[25], nacionalidad[] = new char[25], aux;
		//Demana a l'usuari que seleccioni el llibre pel seu identificador
		Scanner stdin = new Scanner (System.in);
                
                System.out.println("0 - Consulta Id: ");
                System.out.println("1 - Consulta Dni: ");
                System.out.println("2 - Consulta Nombre: ");
                System.out.println("3 - Consulta Apellido: ");
                System.out.println("4 - Consulta Nacionalidad: ");
                System.out.println("5 - Consulta Telefon: ");
                opcion = stdin.nextInt();
                String lt = "";
                int num = 0;
                switch(opcion) {
                    case 0:
                        System.out.printf("Pon el Id: ");
                        num = stdin.nextInt();
                        break;
                    case 1:
                        System.out.printf("Pon el Dni: ");
                        lt = stdin.next();
                        break;
                    case 2:
                        System.out.printf("Pon el Nombre: ");
                        lt = stdin.next();
                        break;
                    case 3: 
                        System.out.printf("Pon el Apellido: ");
                        lt = stdin.next();
                        break;
                    case 4: 
                        System.out.printf("Pon la Nacionalidad: ");
                        lt = stdin.next();
                        break;
                    case 5: 
                        System.out.printf("Pon el Telefono: ");
                        num = stdin.nextInt();
                        break;
                }
                for(;;){
                  

                  if (apuntador >= aleatoriFile.length()) {
                          System.out.println("ERROR: ID incorrecte");
                  } else {
                          aleatoriFile.seek(apuntador);
                          id = aleatoriFile.readInt();
                          for(int i = 0; i<dni.length; i++) {
                                  aux = aleatoriFile.readChar();
                                  dni[i] = aux;
                          }
                          String dnis = new String(dni);
                          //Llegeix ISBN
                          //Llegeix Autor
                          for(int i = 0; i<nom.length; i++) {
                                  aux = aleatoriFile.readChar();
                                  nom[i] = aux;
                          }
                          String nombres = new String(nom);
                          //Llegeix Editorial
                          for(int i = 0; i<cognom.length; i++) {
                                  aux = aleatoriFile.readChar();
                                  cognom[i] = aux;
                          }
                          String cognoms = new String(cognom);

                          for(int i = 0; i<nacionalidad.length; i++) {
                                  aux = aleatoriFile.readChar();
                                  nacionalidad[i] = aux;
                          }
                          String nacionalidades = new String(nacionalidad);

                          telefon = aleatoriFile.readInt();
                          //Llegeix Preu
                          //Sortida de les dades de cada llibre
                          if ( id == num ||dnis.trim().toLowerCase().equals(lt.trim().toLowerCase()) || nombres.trim().toLowerCase().equals(lt.trim().toLowerCase()) || cognoms.trim().toLowerCase().equals(lt.trim().toLowerCase()) || nacionalidades.trim().toLowerCase().equals(lt.trim().toLowerCase()) || telefon == num  ) {
                            System.out.println("ID: " + id + "\nDNI: " + dnis + "\nNOM: "+ nombres + "\nCognom: "  + cognoms+ "\nNacionalidad: " +nacionalidades+ "\nTelefon: "+ telefon);
                          }
                          
                          apuntador += 208;
                          if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
                  }  
                  
                }
				
		
		aleatoriFile.close();//Tancar el fitxer
	}
}

