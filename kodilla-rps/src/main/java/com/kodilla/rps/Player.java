package com.kodilla.rps;

import java.util.Scanner;

public class Player {
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Player(final String name) {
        this.name = name;
    }

    public int getInput(){
        return scanner.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
