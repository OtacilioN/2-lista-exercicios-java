package school.cesar.q5;
import java.util.Random;

/**
 * Created by OtacilioN on 02/05/19.
 */
public class Craps {
    public static boolean verifyFirstRound(int sum){
        if(sum == 7 || sum == 11)
            return true;
        else
            return false;
    }

    public static boolean verifyIfLost(int sum){
        if(sum == 2 || sum == 3 || sum == 12)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Random gerador = new Random();
        int dado1, dado2, sum, target;
        int wins, looses;
        wins = looses = 0;

        for(int x = 0; x < 30; x++){
            dado1 = gerador.nextInt(6)+1;
            dado2 = gerador.nextInt(6)+1;
            System.out.println("Dado1: " + dado1+ " Dado2: " + dado2);
            sum = dado1 + dado2;
            if(sum == 7){
                looses++;
                continue;
            }
            if(Craps.verifyFirstRound(sum)){
                wins++;
                continue;
            }
            target = sum;
            if(Craps.verifyIfLost(sum)){
                looses++;
                continue;
            }
            do{
                dado1 = gerador.nextInt(6)+1;
                dado2 = gerador.nextInt(6)+1;
                System.out.println("Dado1: " + dado1+ " Dado2: " + dado2);
                sum = dado1 + dado2;
                if(Craps.verifyIfLost(sum)){
                    looses++;
                    break;
                }
                if(sum == 7){
                    looses++;
                    break;
                }
            }while (target != sum);
            if(target == sum)
                wins++;
        }
        System.out.println("wins " + wins +  " looses " +  looses);
    }
}
