import java.util.ArrayList;

/**
 * Created By Deepak Bisht on 11/05/21
 */

public final class Country{

    private final String countryName;
    private final ArrayList listOfStates;

    public Country(String countryName,ArrayList listOfStates) {
        super();
        this.countryName = countryName;
        this.listOfStates=listOfStates;

    }

    public String getCountryName() {
        return countryName;
    }

    public ArrayList getListOfStates() {
        return listOfStates;
    }

    public static void main(String args[])
    {
        ArrayList listOfStates=new ArrayList();
        listOfStates.add("Madhya Pradesh");
        listOfStates.add("Maharastra");
        listOfStates.add("Gujrat");

        Country country=new Country("India",listOfStates);
        System.out.println("Country : "+country.getCountryName());
        System.out.println("List of states : "+country.getListOfStates());
        // It will be added to the list because we did not use clone in getListOfStates
        country.getListOfStates().add("Kerala");
        // It will be added to the list because we did not use deep copy in constructor
        listOfStates.add("Rajasthan");
        System.out.println("Updated List of states : "+country.getListOfStates());

    }
}
