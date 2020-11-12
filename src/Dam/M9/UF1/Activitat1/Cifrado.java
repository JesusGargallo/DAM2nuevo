package juliocesar;

import java.io.IOException;
import java.util.Scanner;


    public class Cifrado {

            public static void main(String[] args) throws IOException {
                Scanner sc = new Scanner(System.in);

                    String tecla = "";
                    char abece[] = {32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114 , 115, 116, 117, 118, 119, 120, 121, 122};
                    int desplazamiento = 0;
                    int restodesplazamiento = 0;
                    System.out.println("Que frase quieres cifrar:");
                    
                    tecla = sc.nextLine();
                    System.out.println("cuantos te quieres mover:");
                    desplazamiento = sc.nextInt();


                    for(int j = 0; j < tecla.length(); j++){
                            for(int i = 0; i < abece.length; i++){
                                if(abece[i] == tecla.charAt(j)){
                                    if((desplazamiento+i) >= abece.length){
                                        restodesplazamiento = abece.length - i;
                                        System.out.print(abece[desplazamiento - restodesplazamiento]);
                                    } else{
                                       System.out.print(abece[desplazamiento + i]);
                                    }
                                }
                            }
                    }
                System.out.print("\n");
            }
    }
