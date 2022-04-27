package Coffee;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private String name;
    private int price;
    private String size;

    public Menu(int id, String name, int price,String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
