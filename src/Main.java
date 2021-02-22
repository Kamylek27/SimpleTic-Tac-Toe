import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char array2[][] = new char[3][3];
        

        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                array2[i][y] = ' ';
            }
        }

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int y = 0; y < 3; y++) {
                System.out.print(array2[i][y] + " ");
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.println("---------");


        boolean number = true;
        int first = 0;
        int second = 0;
        int count = 0;

        while (number) {

            System.out.println("Enter the coordinates: >");
            String co = input.nextLine();

            try {

                String[] n = co.split(" ");
                first = Integer.parseInt(n[0]);
                second = Integer.parseInt(n[1]);

                if (array2[3 - second][first - 1] == ' ' && count % 2 == 0) {
                    array2[3 - second][first - 1] = 'X';
                    count++;

                    System.out.println("---------");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("| ");
                        for (int y = 0; y < 3; y++) {
                            System.out.print(array2[i][y] + " ");
                        }
                        System.out.print("|");
                        System.out.println();
                    }
                    System.out.println("---------");

                } else if (array2[3 - second][first - 1] == ' ' && count % 2 == 1) {

                    array2[3 - second][first - 1] = 'O';
                    count++;

                    System.out.println("---------");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("| ");
                        for (int y = 0; y < 3; y++) {
                            System.out.print(array2[i][y] + " ");
                        }
                        System.out.print("|");
                        System.out.println();
                    }
                    System.out.println("---------");

                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } finally {
                int spaces = 0;

                for (int i = 0; i < 3; i++) {
                    for (int y = 0; y < 3; y++) {
                        if (array2[i][y] == ' ') {
                            spaces++;
                        }
                    }
                }
                if (spaces == 0) {
                    number = false;
                }

            }

            int rI = array2[0][0] + array2[0][1] + array2[0][2];
            int rII = array2[1][0] + array2[1][1] + array2[1][2];
            int rIII = array2[2][0] + array2[2][1] + array2[2][2];

            int cI = array2[0][0] + array2[1][0] + array2[2][0];
            int cII = array2[0][1] + array2[1][1] + array2[2][1];
            int cIII = array2[0][2] + array2[1][2] + array2[2][2];

            int sI = array2[0][0] + array2[1][1] + array2[2][2];
            int sII = array2[0][2] + array2[1][1] + array2[2][0];

            if (Row(rI, rII, rIII) || Column(cI, cII, cIII) || Sa(sI, sII)) {
                break;
            } else {
                System.out.println("unfinished game");
            }

        }

    }

    private static boolean Sa(int saOne, int saTwo) {
        if (saOne == 264 || saTwo == 264) {
            System.out.println("X wins");
            return true;
        } else if (saOne == 237 || saTwo == 237) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    private static boolean Column(int columnOne, int columnTwo, int columnThree) {
        if (columnOne == 264 || columnTwo == 264 || columnThree == 264) {
            System.out.println("X wins");
            return true;

        } else if (columnOne == 237 || columnTwo == 237 || columnThree == 237) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }

    private static boolean Row(int rowOne, int rowTwo, int rowThree) {
        if (rowOne == 264 || rowTwo == 264 || rowThree == 264) {
            System.out.println("X wins");
            return true;
        } else if (rowOne == 237 || rowTwo == 237 || rowThree == 237) {
            System.out.println("O wins");
            return true;
        }
        return false;
    }
}
