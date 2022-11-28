package com.msqapps.expensemanager;

public class descmodel1 {
    private String description,catagory;
    private String amount,time,date;



    public descmodel1(String description, String amount, String time, String date) {
        this.description = description;

        this.amount = amount;
        this.time = time;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getCatagory() {
        return catagory;
    }

    public String getAmount() {
        return amount;
    }

    public  String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
