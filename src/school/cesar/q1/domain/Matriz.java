package school.cesar.q1.domain;

import java.util.Random;

public class Matriz {
    private int matrix[][];
    Random generator = new Random();
    final int maxRandom = 101;

    public Matriz(int size) {
        this.matrix = new int[size][size];
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                this.matrix[x][y] = generator.nextInt(maxRandom);
            }
        }
    }

    public Matriz(int lineSize, int collumnSize){
        this.matrix = new int[lineSize][collumnSize];
        for(int x = 0; x < lineSize; x++){
            for(int y = 0; y < collumnSize; y++){
                this.matrix[x][y] = generator.nextInt(maxRandom);
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int[] getMainDiagonal(){
        int lineSize = this.matrix.length;
        int collumnSize = this.matrix[0].length;

        if(lineSize != collumnSize){
            return null;
        }
        else {
            int mainDiagonal[] = new int[lineSize];
            for (int element = 0; element < lineSize; element++) {
                mainDiagonal[element] = this.matrix[element][element];
            }
            return mainDiagonal;
        }
    }
}
