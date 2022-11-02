package JUEGO_BattleShips_2022;
import java.util.*;

public class BattleShips {
    public static int numRows = 8;
    public static int numCols = 8;
    public static int playerShips;
    public static int computerShips;
    public static String[][] grid = new String[numRows][numCols];
    public static int[][] missedGuesses = new int[numRows][numCols];

    public static void main(String[] args){
        System.out.println("**** BIENVENIDO A Battle Ships ****");
        System.out.println("JUSTO AHORA EL OCEANO ESTA SIN ENEMIGOS\n");


        //Paso 1 ,
        createOceanMap();

        //Paso 2
        deployPlayerShips();

        //Paso 3
        deployComputerShips();

        //Paso 4 batalla
        do {
            Battle();
        }while(BattleShips.playerShips != 0 && BattleShips.computerShips != 0);

        //Paso 5 - Game over
        gameOver();

    }

    public static void createOceanMap(){
        //Primera seccion del tablero
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        //seccion media del tablero
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        //ultima seccion del tablero
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)

            System.out.print(i);
    }

    public static void deployPlayerShips(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n - Despliega tu arsenal! (A = aliados) =) - ");

        // CONSTRUYENDO LA CANTIDAD DE BARCOS DEL JUGADOR
        BattleShips.playerShips = 1;
        for (int i = 1; i <= BattleShips.playerShips; ) {
            System.out.print("Ingresa la coordenada del eje X de tu DESTRUCTOR; \nbarcos disponibles: --> " + i + " -->: ");
            int x = input.nextInt();
            System.out.print("Ingresa la coordenada del eje Y de tu DESTRUCTOR; \nbarcos disponibles: --> " + i + " -->: ");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "A";
                i++;
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "A")
                System.out.println("No puedes colocar dos o más barcos en la misma ubicación.");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("No puedes colocar barcos fuera del tablero: " + numRows + " por " + numCols );
        }
        printOceanMap();
    }

    public static void deployComputerShips(){
        System.out.println("\nDesplegando DESTRUCTORES ENEMIGOS (E = Enemigos) =-|");
        //Desplegando y selecionando los barcos de la computadora! BUMMMM!!!
        BattleShips.computerShips = 1;
        for (int i = 1; i <= BattleShips.computerShips; ) {
            int x = (int)(Math.random() * 8);
            int y = (int)(Math.random() * 8);

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "E";
                System.out.println(i + "--> DESTRUCTOR ENEMIGO desplegado! <--");
                i++;
            }
        }
        printOceanMap();
    }

    public static void Battle(){
        playerTurn();
        computerTurn();

        printOceanMap();

        System.out.println();
        System.out.println("Tus DESTRUCTORES--> " + BattleShips.playerShips + " | Barcos del ENEMIGO: --> " + BattleShips.computerShips);
        System.out.println();
    }

    public static void playerTurn(){
        System.out.println("\nTU TURNO");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Ingresa la coordenada X: ");
            x = input.nextInt();
            System.out.print("Ingresa la coordenada Y: ");
            y = input.nextInt();

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols))
            {
                if (grid[x][y] == "E") //si el barco de la computadora ya está allí; la computadora pierde el barco
                {
                    System.out.println("Boom!¡Hundiste el barco!");
                    grid[x][y] = "!"; //marca de golpe
                    --BattleShips.computerShips;
                }
                else if (grid[x][y] == "A") {
                    System.out.println("\nOh no, hundiste tu propio barco:(");
                    grid[x][y] = "E";
                    --BattleShips.playerShips;
                    ++BattleShips.computerShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Lo siento, te perdiste");
                    grid[x][y] = "A";
                }
            }
            else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("No puedes colocar barcos fuera del tablero; solo tienes: " + numRows + " filas y: " + numCols + " columnas");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //sigue preguntando hasta que sea una suposición válida
    }

    public static void computerTurn(){
        System.out.println("\n- Turno del ENEMIGO - ");
        //Adivina las coordenadas
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 8);
            y = (int)(Math.random() * 8);

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == "A") //si el barco del jugador ya está allí; el jugador pierde el barco
                {
                    System.out.println("¡El ENEMIGO hundió uno de tus barcos!");
                    grid[x][y] = "E";
                    --BattleShips.playerShips;
                    ++BattleShips.computerShips;
                }
                else if (grid[x][y] == "E") {
                    System.out.println("El ENEMIGO hundió uno de sus propios barcos");
                    grid[x][y] = "*";
                    ++BattleShips.playerShips;
                    --BattleShips.computerShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println(" ENEMIGO perdido ");
                    grid[x][y] = "E";
                    //Guardar conjeturas perdidas para la computadora
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //sigue preguntando hasta que sea una suposición válida
    }

    public static void gameOver(){
        System.out.println("tus destructores: " + BattleShips.playerShips + " | Balsas del ENEMIGO: " + BattleShips.computerShips);
        if(BattleShips.playerShips > 0 && BattleShips.computerShips <= 0)
            System.out.println("¡Hurra! Ganaste la batalla:)");
        else
            System.out.println("Lo siento, perdiste la batalla.");
        System.out.println();
    }

    public static void printOceanMap(){
        System.out.println();

        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }
        // ultima seccion del mapa OCEANO
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println("");
    }
}
