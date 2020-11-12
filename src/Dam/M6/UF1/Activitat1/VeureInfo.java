
package exercici1;

import java.io.File;

public class VeureInfo {
    public static void main(String[] args) {
     
	File f = new File(args[0]);
        String[] arxius = f.list();
        
        if (f.exists()){
            if (f.isDirectory()){
                 for (int i = 0; i<arxius.length; i++){
			 System.out.println(arxius[i]);
		 }

            } else if (f.isFile()){
                System.out.println("Nom del fitxer : "+f.getName());
                System.out.println("Ruta           : "+f.getPath());
		System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
		System.out.println("Es pot escriure: "+f.canRead());
		System.out.println("Es pot llegir  : "+f.canWrite());
		System.out.println("Grandaria      : "+f.length());
		System.out.println("Es un directori: "+f.isDirectory());
		System.out.println("Es un fitxer   : "+f.isFile());
 
            } 
            
            if(f.isHidden()){
                 System.out.println("Es troba ocult");
            }else{
                System.out.println("No es troba ocult");
            }
            if ((18529 - ((((f.lastModified() / 1000 )/ 60 )/ 60 )/ 24)) < 3){
                System.out.println("Menos de tres dias se ha modificado");
            }
            
        } else {
            
            System.out.println("No existeix");
        }

    }
    
}

