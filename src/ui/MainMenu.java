package ui;

import java.util.Scanner;

public class MainMenu {
    private Scanner inputFromUser;

    public MainMenu(){
        this.inputFromUser = new Scanner(System.in);
    }

    public void welcomeUser(){
        System.out.println("Welcome to the haiku application");
    }
}
