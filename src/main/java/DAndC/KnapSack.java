package DAndC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By Deepak Bisht on 24/04/21
 */
public class KnapSack {
    public static void main(String[] args) {
        int totalCapacity;
        List<Objects> objects = Arrays.asList(new Objects(20, 4, "Apple"),
                new Objects(50, 14, "Orange"),
                new Objects(90, 4, "Peach"),
                new Objects(120, 44, "Avacado"),
                new Objects(200, 60, "Acko"));

        Collections.sort(objects, (a, b) -> (b.price / b.quantity - a.price / a.quantity));

        System.out.println(objects);
        System.out.println(totalProfit(objects, 50));

    }

    public static double totalProfit(List<Objects> objects, int totalCapacity) {
        double profit = 0.0d;
        for (Objects fruit : objects) {
            if (fruit.quantity <= totalCapacity) {
                profit += fruit.price;
                totalCapacity -= fruit.quantity;
            } else {
                double perPiecePrice = Double.valueOf(fruit.price)/fruit.quantity;
                System.out.println(perPiecePrice);
                profit += perPiecePrice * totalCapacity;
            }
        }
        return profit;
    }

}


class Objects {
    int price;
    int quantity;
    String id;

    public Objects(int price, int quantity, String id) {
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    @Override
    public String toString() {
        return "KnapSack{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", id='" + id + '\'' +
                '}';
    }
}
