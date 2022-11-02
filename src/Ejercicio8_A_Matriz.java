/*Inicializa sus elementos a 0 y
luego establece a 1 los elementos
(0,4), (2,6), (3,1) y (8,6).*/


public class Ejercicio8_A_Matriz {
    public static void main(String[] args) {
    int [][] matriz= new int[10][10];

    //Rellenando la matriz,
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[0][4]=1;
                matriz[2][6]=1;
                matriz[3][1]=1;
                matriz[8][6]=1;
            }
        }
        System.out.println("la matriz es: \n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}