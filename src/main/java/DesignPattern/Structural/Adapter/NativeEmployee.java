package DesignPattern.Structural.Adapter;

/**
 * Created By Deepak Bisht on 17/05/21
 */
public class NativeEmployee implements Employee{

    String id;
    String firstName;
    String lastName;
    String email;

    public NativeEmployee(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getGivenName() {
        return firstName;
    }

    @Override
    public String getFamilyName() {
        return lastName;
    }

    @Override
    public String getMail() {
        return email;
    }
}
