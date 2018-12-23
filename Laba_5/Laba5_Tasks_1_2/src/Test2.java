    import java.util.*;
    import java.io.FileWriter;
    import java.io.IOException;

public class Test2 {

    public static ArrayList<Integer> CreateMaxList(int n,ArrayList<Integer> mainList){
        ArrayList<Integer> betaList = new ArrayList<Integer>();
        for (Integer element: mainList) betaList.add(element);
        Collections.sort(betaList, Collections.reverseOrder());
        int N = betaList.size()-n;
        for (int i=0; i<N; i=i+1) betaList.remove(betaList.size()-1);
        return betaList;
    }
    public static void MainForTest2(){
        ArrayList<Integer> alphaList = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 150; i = i + 1) alphaList.add(rand.nextInt((200) + 1));

        ArrayList<Integer> betaList = new ArrayList<Integer>();
        betaList = CreateMaxList(15,alphaList);
        System.out.println(betaList.toString());

        try{
            FileWriter fileWriter = new FileWriter("beta.txt");
            for (Integer element: betaList) fileWriter.write(Integer.toString(element) + "\t");
            fileWriter.close();
        }
        catch(IOException E){
            E.printStackTrace();
        }

    }
}
