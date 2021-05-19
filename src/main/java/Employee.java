import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created By Deepak Bisht on 11/05/21
 */
public class Employee {

    final int id;
    final String name;
    final List<Employee> subordinates;

    Employee(int id, String name, List<Employee> subordinates){
        this.id = id;
        this.name = name;
        this.subordinates = subordinates;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(subordinates, employee.subordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subordinates);
    }

    public static void main(String[] args) {
        Employee e = new Employee(1, "M", Arrays.asList(new Employee(2, "N", null)));
    }
}
