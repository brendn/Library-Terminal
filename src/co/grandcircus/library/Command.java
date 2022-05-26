package co.grandcircus.library;

import java.util.Scanner;

public abstract class Command {

    private String name;
    private String help;

    public Command(String name, String help) {
        this.name = name;
        this.help = help;
    }

    public Command(String name) {
        this(name, name);
    }

    public String getHelp() {
        return help;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(String input);

    protected int parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }

}

