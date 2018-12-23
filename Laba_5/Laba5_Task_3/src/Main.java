import java.text.Collator;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<WorkerForAnHour> hourWorkers;
        hourWorkers = getListFromFile("WorkerForAnHour.txt","WorkerForAnHour");
        Collections.sort(hourWorkers, Collections.reverseOrder());
        ArrayList<WorkerForAMonth> monthWorkers;
        monthWorkers = getListFromFile("WorkerForAMonth.txt","WorkerForAMonth");
        Collections.sort(monthWorkers, Collections.reverseOrder());
        System.out.println("First 5 names:");
        System.out.println("\nMonthWorkers\n");
        for (int i=0; i<5; i=i+1) System.out.println(monthWorkers.get(i).getName()+ " " +monthWorkers.get(i).getSurname() + "  (" + monthWorkers.get(i).getAvgSalary()+  ")");
        System.out.println("\nHourWorkers\n");
        for (int i=0; i<5; i=i+1) System.out.println(hourWorkers.get(i).getName()+ " " +hourWorkers.get(i).getSurname()+ "  (" + hourWorkers.get(i).getAvgSalary()+  ")");

        System.out.println("\n" + "Last 3 ids:");
        System.out.println("\nMonthWorkers");
        for (int i=monthWorkers.size()-1; i>=monthWorkers.size()-3; i=i-1) System.out.println("id: " + monthWorkers.get(i).getId());
        System.out.println("\nHourWorkers");
        for (int i=hourWorkers.size()-1; i>=hourWorkers.size()-3; i=i-1) System.out.println("id: " + hourWorkers.get(i).getId());
    }

    public static ArrayList   getListFromFile(String filename, String worker) throws IOException{
        File file = new File(filename);
        Scanner scan = new Scanner(file);

        if (worker.equals("WorkerForAnHour")) {
            ArrayList<WorkerForAnHour> workers = new ArrayList<WorkerForAnHour>();
            while (scan.hasNextLine()) workers.add(getHourWorkerFromScan(scan));
            return workers;
        }
        else {
            ArrayList<WorkerForAMonth> workers = new ArrayList<WorkerForAMonth>();
            while (scan.hasNextLine()) workers.add(getMonthWorkerFromScan(scan));
            return workers;
        }
    }
    public static  WorkerForAMonth getMonthWorkerFromScan(Scanner scan){
        if (!scan.nextLine().equals("Worker")) throw new IllegalArgumentException("Wrong format of line");

        int id = Integer.parseInt(getNextLine(":","ID",scan));
        String surname = getNextLine(":","Surname",scan);
        String name = getNextLine(":","Name",scan);
        double salary = Double.parseDouble(getNextLine(":","Salary",scan));

        return new WorkerForAMonth(name,surname,salary,id);
    }
    public static  WorkerForAnHour getHourWorkerFromScan(Scanner scan){
        if (!scan.nextLine().equals("Worker")) throw new IllegalArgumentException("Wrong format of line");

        int id = Integer.parseInt(getNextLine(":","ID",scan));
        String surname = getNextLine(":","Surname",scan);
        String name = getNextLine(":","Name",scan);
        double salary = Double.parseDouble(getNextLine(":","Salary",scan));

        return new WorkerForAnHour(name,surname,salary,id);
    }
    public static String getNextLine(String separator, String word, Scanner scan){
        String[] nextLine = scan.nextLine().split(separator);
        if (!nextLine[0].equals(word)) throw new IllegalArgumentException("Wrong format of line"); //check of the field
        return nextLine[1].replaceAll("\\s+",""); //return only the contents of the field
    }

    public static void writeWorkersForAnHourToFile(ArrayList<WorkerForAnHour> workers, String filename) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        for (WorkerForAnHour worker: workers) worker.outToFile(fileWriter);
        fileWriter.close();
    }

    public static void writeWorkersForAMonthToFile(ArrayList<WorkerForAMonth> workers, String filename) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        for (WorkerForAMonth worker: workers) worker.outToFile(fileWriter);
        fileWriter.close();
    }
}

