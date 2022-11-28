package com.msqapps.expensemanager;

public class cash {
    String amount;
    String catagory;
    String description;
    String date;
    String time;
    cash(){

    }



    public cash(String amount, String catagory, String description,String date, String time) {
        this.amount = amount;
        this.catagory = catagory;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCatagory() {
        return catagory;
    }


}
