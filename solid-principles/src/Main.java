import dip.Customer;
import dip.NotifyByEmail;
import dip.NotifyBySMS;
import lsp.Bird;
import lsp.Owl;
import lsp.Penguin;
import ocp.Circle;
import ocp.Shape;
import ocp.Square;
import ocp.Triangle;
import srp.DbManager;
import srp.Employee;

public class Main {
    public static void main(String[] args) {

        DbManager dbManager = new DbManager();
        Employee e = new Employee("Miguel", 23, 1000);

        dbManager.InsertEmployeeInfo(e);

        Circle c = new Circle(1.0);
        Square s = new Square(1.0);
        Triangle t = new Triangle(1.0f, 1.0f);

        System.out.println(c.area());
        System.out.println(s.area());
        System.out.println(t.area());
        System.out.println(t.calculateArea());

        Owl o = new Owl();
        Penguin p = new Penguin();

        System.out.println(getBirdFlySpeed(o));
        //System.out.println(getBirdFlySpeed(p));

        NotifyBySMS notifyBySMS = new NotifyBySMS();
        NotifyByEmail notifyByEmail = new NotifyByEmail();

        Customer customer = new Customer();

        customer.setNotify(notifyBySMS);

        //...

        customer.setNotify(notifyByEmail);



    }

    public static double getBirdFlySpeed(Bird bird) {
        return bird.fly();
    }
}