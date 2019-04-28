package school.cesar.q1.utils;

import school.cesar.q1.domain.Matriz;

public class Matrizes {
    public static int[][] multiplicar(Matriz m1, Matriz m2){
        int matrix1[][] = m1.getMatrix();
        int matrix2[][] = m2.getMatrix();
        int lineSizeM1 = matrix1.length;
        int lineSizeM2 = matrix2.length;
        int columnSizeM1 = matrix1[0].length;
        int columnSizeM2 = matrix2[0].length;

        if(columnSizeM1 != lineSizeM2){
            return null;
        }

        int [][] result = new int[lineSizeM1][columnSizeM2];
        int value;
        for(int x = 0; x < lineSizeM1; x++){
            for(int z = 0; z < columnSizeM2; z++){
                value = 0;
                for(int y = 0; y < lineSizeM2; y++){
                    value = value + matrix1[x][y] * matrix2[y][z];
                }
                result[x][z] = value;
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix, String matrixName){
        System.out.printf("%s getMatrix:\n", matrixName);
        if (matrix != null) {
            for(int line[]:matrix){
                for(int element:line){
                    System.out.printf(" %3d ", element);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Empty matrix");
        }
        System.out.println();
    }

    private static void printMainDiagonal(Matriz matrix, String matrixName){
        System.out.printf("%s getMainDiagonal\n", matrixName);
        if(matrix.getMainDiagonal() != null){
            for(int element:matrix.getMainDiagonal()){
                System.out.printf(" %3d ", element);
            }
        }
        else{
            System.out.println("Empty diagonal");
        }

        System.out.println();
    }



    public static void main(String[] args) {
        Matriz m1 = new Matriz(5);
        Matriz m2 = new Matriz(3);
        Matriz m3 = new Matriz(3);
        Matriz m4 = new Matriz(4, 2);
        Matriz m5 = new Matriz(2, 3);
        Matriz m6 = new Matriz(5, 3);

        // Errors tests
        Matrizes.printMainDiagonal(m4, "M4"); // Should fail and return empty diagonal
        int multiFail[][] = Matrizes.multiplicar(m5, m6);
        Matrizes.printMatrix(multiFail, "Should be empty matrix");



        // Square matrix
        Matrizes.printMatrix(m1.getMatrix(), "M1");
        Matrizes.printMainDiagonal(m1, "M1");
        int multi1[][] = Matrizes.multiplicar(m1, m1);
        Matrizes.printMatrix(multi1, "M1xM1");

        // Square x Square
        Matrizes.printMatrix(m2.getMatrix(), "M2");
        Matrizes.printMatrix(m3.getMatrix(), "M3");
        int multi2[][] = Matrizes.multiplicar(m2, m3);
        Matrizes.printMatrix(multi2, "M2xM3");

        // 4x2 x 2x3
        Matrizes.printMatrix(m4.getMatrix(), "M4");
        Matrizes.printMatrix(m5.getMatrix(), "M5");
        int multi3[][] = Matrizes.multiplicar(m4, m5);
        Matrizes.printMatrix(multi3, "M4xM5");

    }
}
