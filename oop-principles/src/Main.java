import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Customer c = new Customer("Oscar", "Mendoza", "2257-7777", "example@example.com", "Customer", "000000-0", LocalDate.now());
        Employee e = new Employee("Oscar", "Rodriguez", "2257-7777", "example@example.com", "Employee", "000000-1", LocalDate.now());

        approve(c);
        approve(e);

        c.setName("Alejandro");

        approve(c);

    }

    public static void approve(Person person){
        person.setApprovedDate(LocalDate.now());
        //Save in db
        System.out.println(person.getType() + " " + person.getName() + " is approved at " + person.getApprovedDate());
    }
}