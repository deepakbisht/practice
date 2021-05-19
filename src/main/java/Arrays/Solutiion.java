package Arrays;

/**
 * Created By Deepak Bisht on 02/05/21
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Price {
    String date;
    String security;
    Double price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
// {"date" : "20190101", "security" : "ABC Corporation", "price" : 666.63},
}

class Holding{
    String date;
    String security;
    Integer quantity;
    String portfolio;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }


}

//   {"date" : "20190101", "security" : "ABC Corporation", "quantity" : 980, "portfolio" : "Growth"},

class Result {

    static Map<String, List<Price>> priceDateListMap = new HashMap<String, List<Price>>();
    static Map<String, List<Holding>> holdingListMap = new HashMap<>();
    static Map<String, List<Price>> priceSecurityKeyMap = new HashMap<String, List<Price>>();
    /*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     */

    public static double calculateNAV(String date) throws IOException {
        populateValues();
        double result = 0.0d;
        List<Holding> holdingList = holdingListMap.get(date);
        for(Holding holding : holdingList) {
            List<Price> priceList = priceDateListMap.get(date);
            for(Price price:priceList) {
                if(price.security.equals(holding.security)) {
                    result += price.price * holding.quantity;
                }
            }
        }
        return result;
    }

    public static void populateValues() throws IOException {
        String holdingUrl = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
        String pricingUrl = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";


        String content = fetchContent(holdingUrl);
        String priceContent  = fetchContent(pricingUrl);

        Type listType = new TypeToken<List<Holding>>(){}.getType();
        Type listType2 = new TypeToken<List<Price>>(){}.getType();

        List<Holding> holdingList = new Gson().fromJson(content, listType);
        convertHolidayListToMap(holdingList);

        List<Price> priceList = new Gson().fromJson(priceContent, listType2);
        convertPriceListToMap(priceList);
    }

    // convertTomap
    public static void convertHolidayListToMap(List<Holding> holdings) {
        for(Holding holding:holdings) {
            List<Holding> holdingList =   holdingListMap.get(holding.date);
            if(holdingList==null) {
                holdingList = new ArrayList<>();
                holdingList.add(holding);
                holdingListMap.put(holding.date, holdingList);
            } else {
                holdingList.add(holding);
                holdingListMap.put(holding.date, holdingList);
            }
        }
    }

    public static void convertPriceListToMap(List<Price> prices) {
        for(Price price:prices) {
            List<Price> priceList =   priceDateListMap.get(price.date);
            List<Price> namePriceList = priceSecurityKeyMap.get(price.security);
            if(priceList==null) {
                priceList = new ArrayList<>();
                priceList.add(price);
                priceDateListMap.put(price.date, priceList);
            } else {
                priceList.add(price);
                priceDateListMap.put(price.date, priceList);
            }
            //
            if(namePriceList==null) {
                namePriceList = new ArrayList<>();
                namePriceList.add(price);
                priceSecurityKeyMap.put(price.security, namePriceList);
            } else {
                namePriceList.add(price);
                priceSecurityKeyMap.put(price.security, namePriceList);
            }
        }
    }

    private static String fetchContent(String uri) throws IOException {

        final int OK = 200;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();
        if(responseCode == OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        }

        return null;
    }

}

public class Solutiion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String date = bufferedReader.readLine();

        double result = Result.calculateNAV(date);

        //   bufferedWriter.write(String.valueOf(result));
        //     bufferedWriter.newLine();

        bufferedReader.close();
        //   bufferedWriter.close();
    }
}
