package juliocesar;

import  java.util.Scanner ;

    public  class  bruto {
        public  static  void  main ( String [] args ) {
           Scanner sc = new Scanner(System.in);

                String texto = "";
                char abece[] = {32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114 , 115, 116, 117, 118, 119, 120, 121, 122};
                int desplazamiento = abece.length;
                int avantdesplazamiento = 0;
                int cont = 0;
                System.out.println("Que frase quieres descifrar con fuerza bruta:");
                texto = sc.nextLine();
           // desp = sc.nextInt();
                while(cont != abece.length){
                    for(int j = 0; j < texto.length(); j++){
                        for(int i = 0; i < abece.length; i++){
                            if(abece[i] == texto.charAt(j)){
                                if((i - desplazamiento) < 0){
                                    avantdesplazamiento = desplazamiento - i;
                                    //avantdesp = abecedario.length - 
                                    System.out.print(abece[abece.length - avantdesplazamiento]);
                                } else{
                                    System.out.print(abece[i-desplazamiento]);
                                }
                            }
                        }
                    }
                        System.out.print("\n");
                        cont++;
                        desplazamiento--;
                }

        }
    }
