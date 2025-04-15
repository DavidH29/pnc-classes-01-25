import java.time.LocalDate;

public class Person {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String type;
    private String dui;
    private LocalDate birthday;
    private LocalDate approvedDate;

    public Person(String name, String address, String phone, String email, String type, String dui, LocalDate birthday) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.dui = dui;
        this.birthday = birthday;
        this.approvedDate = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDate approvedDate) {
        this.approvedDate = approvedDate;
    }
}
