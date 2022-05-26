package co.grandcircus.library;

public abstract class Command {

    private String name;

    private String help;

    /**
     * Creates a command with the provided name and help.
     *
     * @param name  The name of the command, what will be used to execute it
     * @param help  A basic description of the command
     */
    public Command(String name, String help) {
        this.name = name;
        this.help = help;
    }

    /**
     * A brief description of the command, for more complex commands this can also
     * include the proper usage or more additional information.
     */
    public String getHelp() {
        return help;
    }

    /**
     * The name of the command, this is what will be used to execute the command
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the command.
     *
     * @param input The user input.  If the command contains arguments, this will only contain the arguments.
     */
    public abstract void execute(String input);

    /**
     * Attempts to parse an Integer from the given String.
     *
     * @param s The input String
     * @return A parsed Integer if one is found, otherwise it will return -1
     */
    protected int parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }

}

