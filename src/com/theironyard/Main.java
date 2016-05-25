package com.theironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Answers answers = new Answers();

    public static void askQuestions() {
        System.out.println("What is your name?");
        answers.name = scanner.nextLine();
        System.out.printf("Welcome, %s.\nThis program will ask 5 questions about your car.\n", answers.name);
        System.out.println(answers.q1);
        answers.a1 = scanner.nextLine();
        System.out.println(answers.q2);
        answers.a2 = scanner.nextLine();
        System.out.println(answers.q3);
        answers.a3 = scanner.nextLine();
        System.out.println(answers.q4);
        answers.a4 = scanner.nextLine();
        System.out.println(answers.q5);
        answers.a5 = scanner.nextLine();
    }

    public static void main(String[] args) {
        loadAnswers();

        if (answers == null) {

            askQuestions();

            saveAnswers();
        }
        else {
            System.out.printf("Welcome back %s.\n Here are the answers you provided before:");
            System.out.println(answers.q1 + "\n" + answers.a1);
            System.out.println(answers.q2 + "\n" + answers.a2);
            System.out.println(answers.q3 + "\n" + answers.a3);
            System.out.println(answers.q4 + "\n" + answers.a4);
            System.out.println(answers.q5 + "\n" + answers.a5);
            System.out.println("Would you like to change any of your information?");
            String yOrN = scanner.nextLine();
            if (yOrN == "Y"){
                askQuestions();
            }
        }
    }

    public static void saveAnswers(){
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(answers);

        File f = new File("answers.json");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Answers loadAnswers(){
        File f = new File("answers.json");
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Answers.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
