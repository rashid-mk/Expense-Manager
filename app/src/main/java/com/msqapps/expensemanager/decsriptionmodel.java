package com.msqapps.expensemanager;

public class decsriptionmodel {
   private String description,catagory;
   private String amount,time,date;

public decsriptionmodel(){


}

    public decsriptionmodel(String description, String amount, String time, String date,String catagory) {
        this.description = description;
        this.catagory=catagory;
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
