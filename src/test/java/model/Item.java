package model;

import java.util.Objects;

public class Item {
    private String id;
    private String name;
    private String discountCost;

    public Item(String id, String name, String discountCost){
        this.id = id;
        this.name = name;
        this.discountCost = discountCost;
    }

    public String getId() {
        return id;
    }

    public String getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(String discountCost) {
        this.discountCost = discountCost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public java.lang.String
    toString() {
        return "Item{" +
                "id=" + id +
                ", name=" + name +
                ", discountCost=" + discountCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

