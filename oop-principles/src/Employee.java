import java.time.LocalDate;

public class Employee extends Person {

    public Employee(String name, String address, String phone, String email, String type, String dui, LocalDate birthday) {
        super(name, address, phone, email, type, dui, birthday);
    }
}
