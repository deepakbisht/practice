package DesignPattern.Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Deepak Bisht on 15/05/21
 */
public class ItemRegistry {
    Map<String, Item> items = new HashMap<>();

    public ItemRegistry () {
        loadItems();
    }

    public Item createItem(String type) throws CloneNotSupportedException {
        Item item = null;
        item = (Item) items.get(type).clone();
        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setPrice(23.22);
        movie.setTitle("Harry Potter");
        movie.setRunTime("3.3h");
        items.put("Movie", movie);

        Book book = new Book();
        book.setPrice(12);
        book.setTitle("Naruto");
        book.setNumberofPages(2222);
        items.put("Book", book);
    }
}
