package DesignPattern.Structural.Adapter;

/**
 * Created By Deepak Bisht on 17/05/21
 */
public class EmployeeLDAP {
    private String cn;
    private String surname;
    private String givenName;
    private String mail;

    public EmployeeLDAP(String cn, String surname, String givenName, String mail) {
        this.cn = cn;
        this.surname = surname;
        this.givenName = givenName;
        this.mail = mail;
    }

    public String getCn() {
        return cn;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMail() {
        return mail;
    }
}
