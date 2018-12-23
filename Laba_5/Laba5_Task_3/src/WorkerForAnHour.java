public class WorkerForAnHour extends Workers{
    private double hourSalary;

    public WorkerForAnHour(String new_name, String new_surname, double salary, int id) {
        super(new_name, new_surname, salary,id);
        hourSalary = salary;
    }
    @Override
    double avgSalaryCount(double salary) {
        return 20.8 * 8 * salary;
    }

}
