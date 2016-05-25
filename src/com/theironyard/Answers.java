package com.theironyard;

/**
 * Created by michaeldelli-gatti on 5/25/16.
 */
public class Answers {
    String name;
    String a1;
    String a2;
    String a3;
    String a4;
    String a5;
    String q1;
    String q2;
    String q3;
    String q4;
    String q5;


    public Answers() {
        this.name = name;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.q1 = "1. What is the make of your car?";
        this.q2 = "1. What is the model of your car?";
        this.q3 = "3. How many people can your car seat?";
        this.q4 = "4. How many wheels does your car have";
        this.q5 = "5. How much horsepower does your car have?";
    }



    public String getName() {
        return name;
    }

    public String getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }

    public String getA3() {
        return a3;
    }

    public String getA4() {
        return a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "name='" + name + '\'' +
                ", a1='" + a1 + '\'' +
                ", a2='" + a2 + '\'' +
                ", a3='" + a3 + '\'' +
                ", a4='" + a4 + '\'' +
                ", a5='" + a5 + '\'' +
                ", q1='" + q1 + '\'' +
                ", q2='" + q2 + '\'' +
                ", q3='" + q3 + '\'' +
                ", q4='" + q4 + '\'' +
                ", q5='" + q5 + '\'' +
                '}';
    }
}

