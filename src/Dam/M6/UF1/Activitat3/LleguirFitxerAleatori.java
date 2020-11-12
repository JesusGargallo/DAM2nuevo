package exercici3;

import java.io.*;

public class LleguirFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("fitxerAleatori.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		//Apuntador s'inicialitza apuntant a l'inici del fitxer
		int apuntador = 0, telefon, id;
		
		char dni[] = new char[25], nom[] = new char[25], cognom[] = new char[25], nacionalidad[] = new char[25], aux;
		
		//Recorrer el fitxer llibres
		for (;;) {
			aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
			//Llegeix ID
			id = aleatoriFile.readInt();
			//Llegeix Títol
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
			System.out.println("ID: " + id + "\nDNI: " + dnis + "\nNOM: "+ nombres + "\nCognom: "  + cognoms+ "\nNacionalidad: " +nacionalidades+ "\nTelefon: "+ telefon); 		
			//S'ha de posicionar l'apuntador al següent llibre
			apuntador += 208;
			//Si coincideix on s'està apuntat amb el final del fitxer, sortim
			if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
		}
		aleatoriFile.close();//Tancar el fitxer
	}
}



