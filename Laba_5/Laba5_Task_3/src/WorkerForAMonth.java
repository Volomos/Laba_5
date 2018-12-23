public class WorkerForAMonth extends Workers{
    private double monthlySalary;

    public WorkerForAMonth(String new_name, String new_surname, double salary, int id) {
        super(new_name, new_surname, salary,id);
        monthlySalary = salary;
    }
    @Override
    double avgSalaryCount(double salary) {
        return salary;
    }

}
