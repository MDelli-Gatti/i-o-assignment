package com.theironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final String SAVE_FILE = "answers.json";
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
        saveAnswers();
    }

    public static void main(String[] args) {

       answers = loadAnswers(SAVE_FILE);

        if (answers == null) {
            answers = new Answers();
            askQuestions();
        }
        else {
            System.out.printf("Welcome back %s.\n Here are the answers you provided before:\n",answers.name);
            System.out.println(answers.q1 + "\n" + answers.a1);
            System.out.println(answers.q2 + "\n" + answers.a2);
            System.out.println(answers.q3 + "\n" + answers.a3);
            System.out.println(answers.q4 + "\n" + answers.a4);
            System.out.println(answers.q5 + "\n" + answers.a5);
            System.out.println("Would you like to change any of your information?[y/n]\n");
            String yOrN = scanner.nextLine();
            if (yOrN.equals("y")){
                askQuestions();
            }
        }
    }

    public static void saveAnswers(){
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(answers);

        File f = new File(SAVE_FILE);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Answers loadAnswers(String SAVE_FILE){
        File f = new File(SAVE_FILE);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Answers.class);
        } catch (FileNotFoundException e) {
            System.out.println("load failed");
        }
        return null;
    }
}
