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
import java.util.List;


//   {"date" : "20190101", "security" : "ABC Corporation", "quantity" : 980, "portfolio" : "Growth"},


class JsonResponse {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Country> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Country> getData() {
        return data;
    }

    public void setData(List<Country> data) {
        this.data = data;
    }
}

class Country {
    String name;
    Integer population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}

public class CountryEBI {

    static int getCountries(String s, int p) throws Exception {
        int populationLimitCount = 0;
        int page = 1;
        String queryName = "https://jsonmock.hackerrank.com/api/countries/search?name=" + s;
        String content = fetchContent(queryName);

        Type listType = new TypeToken<JsonResponse>() {
        }.getType();

        JsonResponse jsonResponse = new Gson().fromJson(content, listType);
        populationLimitCount = (int) jsonResponse.data.stream().filter(country -> country.getPopulation() > p).count();

        if (jsonResponse.total_pages > 1) {
            while (page <= jsonResponse.total_pages) {
                String pagedQuery = queryName + "&page=" + (page + 1);
                content = fetchContent(pagedQuery);
                jsonResponse = new Gson().fromJson(content, listType);
                populationLimitCount += (int) jsonResponse.data.stream().filter(country -> country.getPopulation() > p).count();
                page++;
            }
        }

        return populationLimitCount;
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


    public static void main(String[] args) throws Exception {
        getCountries("in", 1000000);
    }
}
