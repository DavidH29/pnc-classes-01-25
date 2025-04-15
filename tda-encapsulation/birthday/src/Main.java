public class Main {
    public static String today = "2025/03/24";
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Person p = new Person("2000/06/14");

        if(p.isLegal()){
            System.out.println("Mayor de edad");
        }
        else {
            System.out.println("Menor de edad");
        }

    }

}