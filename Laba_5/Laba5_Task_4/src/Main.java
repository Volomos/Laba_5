import java.util.*;

public class Main {
    public static boolean mistakeProtection( int number, int min, int max){
        if(number < min || number > max){
            System.out.println("Number is over borders!");
            return false;
        }
        else return true;
    }
    public static void main(String[] args) {
        int min = 0;
        int max = 100;
        int number, realNumber;
        boolean check = true;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        realNumber = rand.nextInt(max);

        do {
            System.out.println("Boarders: [" + min + ";"+max+"]");
            do {
                System.out.println("Try to guess a number!");
                number = scan.nextInt();
            } while (!mistakeProtection(number,min,max));
            if(number==realNumber) check = false;
            else if(number <= max && number > realNumber) max = number;
            else if(number >= min && number < realNumber) min = number;

        }while(check);

        System.out.println("Congratulations, you won!");
    }
}
