/*Escriba un programa que calcule el elemento más frecuente de una
lista de 20 caracteres. Inicialice la matriz de caracteres en la declaración
de la matriz como una lista de caracteres como esta:

        carácter final[] LETRAS =

        {'B', 'A', 'B', 'C', 'A', 'C', 'D', 'C', …, 'C', 'D'};*/

public class Ejercicio10_calculoFrecuencia {
            public static void main(String args[]){
                //creamos la cadena

                final char letraArray[] =  {'B', 'A', 'B', 'C', 'A', 'C', 'D', 'C','B', 'A', 'B', 'C', 'A', 'C', 'D', 'C','B', 'A', 'B', 'C'};
                char letra = letraArray[0];
                int contadorLetraRepetida = 0;

                    // Establecemos el conteo,
                for(int j =0;j<letraArray.length;j++){
                    int contador = 0;//Antes de recorrer el array pongo el contador en 0
                    for(int k=0;k<letraArray.length;k++){
                        if(letraArray[j] == letraArray[k]) //Letra encontrada
                            contador++;
                    }
                    if(contadorLetraRepetida < contador) { //Si la letra actual superó a la que había antes
                        contadorLetraRepetida = contador; //Actualiza el contador de repeticiones con el número máximo
                        letra = letraArray[j]; //Actualiza la letra
                    }
                }

                System.out.println("La letra '" + letra + "' se repite "+ contadorLetraRepetida + " veces.");
            }
        }