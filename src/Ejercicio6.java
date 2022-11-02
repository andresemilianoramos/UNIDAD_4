/*Desarrolle un algoritmo que lea 10 numeros.

Almacenalos en una matriz.

Luego invierta la matriz e imprimirlo en el orden normal.

Nota: para invertir los elementos de intercambio de la matriz:

-> elemento en posición 0 con elemento en posición 9
-> elemento en posición 1 con elemento en posición 8

Y así.
*/
import java.util.Scanner;
//,
public class Ejercicio6 {
    public static void main(String[] args) {

        int[] arreglo =new int[10];
        Scanner scan=new Scanner(System.in);
        for (int i=0; i<arreglo.length;i++) {
            System.out.print("Posicion:["+i+"]: ");
            arreglo[i]=scan.nextInt();
        }
        System.out.println("la matriz original es: ");
        for (int i:arreglo) {
            System.out.print(" |" +i+ "|");
        }
        System.out.println("\nLa matriz invertida es:  ");
        int j=9;
        while (j>=0){
            System.out.print(" |" +arreglo[j]+ "|");
            j--;
        }
    }
}