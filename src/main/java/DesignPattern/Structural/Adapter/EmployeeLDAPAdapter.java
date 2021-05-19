package DesignPattern.Structural.Adapter;

/**
 * Created By Deepak Bisht on 17/05/21
 */
public class EmployeeLDAPAdapter implements Employee{
    private EmployeeLDAP employeeLDAP;

    public EmployeeLDAPAdapter(EmployeeLDAP employeeLDAP) {
        this.employeeLDAP = employeeLDAP;
    }

    @Override
    public String getId() {
        return employeeLDAP.getCn();
    }

    @Override
    public String getGivenName() {
        return employeeLDAP.getGivenName();
    }

    @Override
    public String getFamilyName() {
        return employeeLDAP.getSurname();
    }

    @Override
    public String getMail() {
        return employeeLDAP.getMail();
    }
}
