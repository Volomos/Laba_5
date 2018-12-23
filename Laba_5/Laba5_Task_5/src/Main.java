import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static int[] sortCharArray(char [] array){
        char charTemp;
        int intTemp;
        int indexes [] = new int[array.length];
        for(int i=0;i<array.length;i=i+1){
            indexes[i] = i;
        }
        for(int i=0;i<array.length;i=i+1){
            charTemp = array[i];
            intTemp = i;
            for(int j=i+1;j<array.length;j=j+1){
                if(charTemp>array[j]){
                    array[i] = array[j];
                    array[j] = charTemp;
                    charTemp = array[i];
                    intTemp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = intTemp;
                }
            }
        }
        return indexes;
    }
    public static void main(String[] args) throws IOException {
        String text = "";
        File filerus = new File("input1.txt");
        File fileukr = new File("input2.txt");
        File fileeng = new File("input3.txt");

        Scanner scan1 = new Scanner(filerus);
        Scanner scan2 = new Scanner(fileukr);
        Scanner scan3 = new Scanner(fileeng);
        System.out.println("Russian:");
        while (scan1.hasNextLine()) text = text + scan1.nextLine();
        char[] arr_copy = text.toLowerCase().toCharArray();
        char[] arr = text.toCharArray();
        int[] indexes = sortCharArray(arr_copy);
        for (int element: indexes) System.out.print(arr[element]);
        System.out.println("\nUkrainian:");

        text = "";
        while (scan2.hasNextLine()) text = text + scan2.nextLine();
        arr_copy = text.toLowerCase().toCharArray();
        arr = text.toCharArray();
        indexes = sortCharArray(arr_copy);
        for (int element: indexes) System.out.print(arr[element]);
        System.out.println("\nEnglish:");
        text = "";
        while (scan3.hasNextLine()) text = text + scan3.nextLine();
        arr_copy = text.toLowerCase().toCharArray();
        arr = text.toCharArray();
        indexes = sortCharArray(arr_copy);
        for (int element: indexes) System.out.print(arr[element]);

    }
}

