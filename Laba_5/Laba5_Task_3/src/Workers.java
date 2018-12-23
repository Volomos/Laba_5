import java.io.IOException;
import java.io.FileWriter;
import java.lang.Math;

public abstract class Workers implements Comparable<Workers>{
    private String name;
    private String surname;
    private double avgSalary;
    private int id;

    abstract double avgSalaryCount(double salary);

    public Workers(String new_name, String new_surname, double salary, int new_id){
        name = new_name;
        surname = new_surname;
        id = new_id;
        avgSalary = avgSalaryCount(salary);
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getId(){
        return id;
    }
    public double getAvgSalary(){
        return avgSalary;
    }

    @Override
    public int compareTo(Workers other){

        if ((Math.abs(this.avgSalary - other.avgSalary) > 0) & (this.avgSalary - other.avgSalary) > 0)  return 1;
        else if ((Math.abs(this.avgSalary - other.avgSalary) > 0) & (this.avgSalary - other.avgSalary) < 0) return -1;
        else return this.name.compareTo(other.name);
    }

    public void outToFile(FileWriter fileWriter )throws IOException{
        fileWriter.write("Worker" + "\n");
        fileWriter.write("ID: " + id + "\n");
        fileWriter.write("Surname: " + surname + "\n");
        fileWriter.write("Name: " + name + "\n");
        fileWriter.write("Month average salary: " + avgSalary + "\n");
    }


}
