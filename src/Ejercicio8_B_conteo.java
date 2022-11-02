public class Ejercicio8_B_conteo {
    public static void main(String[] args) {
        int contRow= 0;
        int countCols=0;
        int totalMatriz=0;

        int rows = 10;
        int cols = 10;
        int[][] matriz = new int[rows][cols];

        matriz[0][4] = 1;
        matriz[2][6] = 1;
        matriz[3][1] = 1;
        matriz[8][6] = 1;

        System.out.print("\nLa matriz es: \n");
        //Rellenando la matriz,
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                totalMatriz = matriz.length;
                if (matriz[i][j] == 1){contRow++;
                }

                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                totalMatriz = matriz.length;
                if (matriz[j][i] == 1) {
                    countCols++;
                    break;
                }
            }
        }
        System.out.println("\ntotal rows en 0: "+ (totalMatriz-contRow));
        System.out.println("total cols en 0: "+ (totalMatriz - countCols)+"\n");
    }
}
