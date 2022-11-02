import java.util.Scanner;
//,
public class Ejercicio5 {
    public static void main(String[] args) {

        int[] arreglo =new int[10]; // declaramos las condiciones del arreglo,
        // el cual tendra 10 espacios para almacenar
        Scanner scan=new Scanner(System.in); // creamos el scanner para poder ingresar
        // los datos por teclado
        // creamos la condicion!! =) aqui vamos!

        for (int i=0; i<arreglo.length;i++) {
            // donde la variable i es inicializada
            // en 0 e ira incrementando hasta completar los limites establecidos del arreglo
          //  System.out.println(" Enter an integer");
            //arreglo[i]= scan.nextInt();
            System.out.print("Posicion:["+i+"]: ");
            arreglo[i]=scan.nextInt();
        }
        System.out.println("\nThe reverse numbers are: ");
        System.out.println("");
        int j=9;
        while (j>=0){
            System.out.println("|" +arreglo[j]+ "|");
            j--;
        }
    }
}