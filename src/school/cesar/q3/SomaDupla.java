package school.cesar.q3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by OtacilioN on 02/05/19.
 */
public class SomaDupla {
    // TODO OPTIMIZE THIS METHOD COMPLEXITY, ACTUALLY IS O(Nˆ2)
    public static String getIndexByTarget(ArrayList<Integer> array, int target){
        for(int leftPointer = 0; leftPointer < array.size()-1; leftPointer++){
            if(leftPointer < target){
                for(int rightPointer = leftPointer+1; rightPointer < array.size(); rightPointer++){
                    if(array.get(leftPointer)+array.get(rightPointer) == target){
                        return "Primeiro indice: " + leftPointer + "Segundo indice: " + rightPointer;
                    }
                }
            }
        }
        return "Indices Indeterminados";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value;
        value = input.next();
        ArrayList<Integer> array = new ArrayList<Integer>();

        while(!value.equals("parar")){
            array.add(Integer.parseInt(value));
            value = input.next();
        }

        int target = input.nextInt();

        System.out.println(SomaDupla.getIndexByTarget(array, target));

    }

}


