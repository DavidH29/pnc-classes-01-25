public class Person {
    public static String today = "2025/03/24";

    public String birthday;

    public Person(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean isLegal() {
        String[] dateParts = birthday.split("/");
        String[] datePartsToday = today.split("/");

        int age = Integer.parseInt(datePartsToday[0]) - Integer.parseInt(dateParts[0]);
        if (Integer.parseInt(datePartsToday[1]) >= Integer.parseInt(dateParts[1])){
            if (Integer.parseInt(datePartsToday[2]) >= Integer.parseInt(dateParts[2])) {

            }
        }
        else {
            age--;
        }

        System.out.println(age);
        return age>=18;
    }
}


