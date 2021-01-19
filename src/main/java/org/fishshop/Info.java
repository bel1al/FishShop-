package org.fishshop;

public class Info {
    private int id, price,count;
    private String name,date;

    public Info() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Info(int id, String name, int price, String date, int count) {
        this.id = id;
        this.price = price;
        this.count = count;
        this.name = name;
        this.date = date;
    }
}