package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created By Deepak Bisht on 24/06/20
 */
public class    SortByPop {


    public static class Website {
        String url;
        int count;

        Website(String url, int count) {
            this.url = url;
            this.count = count;
        }

        public String getUrl() {
            return url;
        }

        public int getCount() {
            return count;
        }
    }
    public static void sortMap(Map<String, Integer> urlMap) {

        Map<String, Integer> sortedByValueDesc =
                urlMap.entrySet() .stream() .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedByValueDesc.size());

        sortedByValueDesc.forEach((k,v)->System.out.println(k));
    }

    public static void sortMap(List<Website> websites) {


        Collections.sort(websites, new YSorter()
                .thenComparing(new XSorter()));

        System.out.println(websites.size());

        websites.forEach(website -> System.out.println(website.getUrl()));

    }

    public static class XSorter implements Comparator<Website>
    {

        @Override
        public int compare(Website o1, Website o2) {
            return o1.url.compareTo(o2.url);
        }
    }

    public static class YSorter implements Comparator<Website>
    {

        @Override
        public int compare(Website o1, Website o2) {
            return o2.getCount() - o1.getCount();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Integer> urlMap = new HashMap<>();
        List<Website> websites = new ArrayList<>();
        Integer n = s.nextInt();
        while (n > 0) {
            String str = s.nextLine();
            if (str != null && str.trim().length() > 0) {
                if (urlMap.containsKey(str)) {
                    int val = urlMap.get(str);
                    urlMap.put(str, val + 1);
                } else {
                    urlMap.put(str, 1);
                }
                n--;
            }
        }
        urlMap.forEach((k, v) -> websites.add(new Website(k, v)));
        sortMap(websites);
    }
}
