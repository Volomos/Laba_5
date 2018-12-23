import java.util.Scanner;

public class Main {
    public static String reverseString(String text){
        String changed = "";
        char[] letters = text.toCharArray();
        for(int i=0; i < text.length(); i++){
            changed += letters[text.length()-i-1];
        }

        return changed;
    }
    public static void main(String [] args){
        System.out.println("Print your line");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String changedText = reverseString(text);
        System.out.println("\nReversed line:");
        System.out.println(changedText);
    }
}
