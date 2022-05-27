package co.grandcircus.library;

import java.util.*;

import co.grandcircus.library.commands.*;
import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;

public class Library {

    public static final Inventory INVENTORY = new Inventory();
    public static final List<Command> COMMANDS = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        COMMANDS.add(new CommandHelp());
        COMMANDS.add(new CommandList());
        COMMANDS.add(new CommandReturn());
        COMMANDS.add(new CommandSearch());
        COMMANDS.add(new CommandCheckOut());

        //adding 'preview' details - material the user can skim before checking out
        ArrayList<String> gooniesPreview = new ArrayList<>();
        gooniesPreview.add("Front Cover: A bunch of scared-looking kids crowded around a Pirate skull and gold coins!");
        gooniesPreview.add("Inside Cover: 'Don't say that, ever say that. Goonies never say die.'");
        gooniesPreview.add("Back Cover: A deliciously dizzy adventure with crowd-pleasing fun!");
        ArrayList<String> lostBoysPreview = new ArrayList<>();
        lostBoysPreview.add("Front Cover: A group of tough-looking young-adults staring you menacingly in the eyes.");
        lostBoysPreview.add("Inside Cover: 'You'll never grow old Michael, and you'll never die. But you must feed!'");
        lostBoysPreview.add("Back Cover: A hip, comic twist on classic vampire stories");
        ArrayList<String> standByMePreview = new ArrayList<>();
        standByMePreview.add("Front Cover: Four young boys painted above a backdrop of open wilderness");
    	standByMePreview.add("Inside Cover: 'I never had any friends later on like the ones I had when I was twelve...'");
    	standByMePreview.add("Back Cover: Absolutely wonderful...a film I may never forget!");
        ArrayList<String> attackOnTitanPreview = new ArrayList<>();
        attackOnTitanPreview.add("Front Cover: Two people stand at the foot of a massive crystal-laden cavern; a third person is chained to the walls above them.");
    	attackOnTitanPreview.add("Inside Cover: 'This world is merciless, and it's also very beautiful.'");
    	attackOnTitanPreview.add("Back Cover: Lies uphold these walls.");
    	ArrayList<String> hitchHikerPreview = new ArrayList<>();
    	hitchHikerPreview.add("Front Cover: A large hand with thumb pointed out in outer space. A comical green entity smiles in the background.");
    	hitchHikerPreview.add("Inside Cover: 'Forty-two,” said Deep Thought, with infinite majesty and calm.'");
    	hitchHikerPreview.add("Back Cover: Extremely funny...inspired lunacy..[and] over much too soon.");
    	ArrayList<String> shiningPreview = new ArrayList<>();
    	shiningPreview.add("Front Cover: A crazed looking man is scowling through the hole in a partially destroyed door.");
    	shiningPreview.add("Inside Cover: 'All work and no play makes Jack a dull boy'.");
    	shiningPreview.add("Back Cover: Scary!...Serves up horrors at a brist, unflagging pace.");
    	ArrayList<String> harryPreview = new ArrayList<>();
    	harryPreview.add("Front Cover: A young boy on a broomstick flies through stone pillars near a forest at nightfall.");
    	harryPreview.add("Inside Cover: 'The truth.' Dumbledore sighed. 'It is a beautiful and terrible thing, and should therefore be treated with great caution.' ");
    	harryPreview.add("Back Cover: Harry Potter could assume the same near-legendary status as\n Roald Dahl's Charlie, of chocolate factory fame.");
    	ArrayList<String> dillaPreview = new ArrayList<>();
    	dillaPreview.add("Front Cover: A pixelated portrait of a young man in a ball cap, set in front of a blue and black grid of squares. ");
    	dillaPreview.add("Inside Cover: 'Man that is born of woman is of few days and full of trouble.'");
    	dillaPreview.add("Back Cover: This book is a must for everyone interested in illuinating the idea of unexplainable genius.");
    	ArrayList<String> mockingbirdPreview = new ArrayList<>();
    	mockingbirdPreview.add("Front Cover: A black and green silouette of a large tree, set on a blood-red backdrop.");
    	mockingbirdPreview.add("Inside Cover: 'The one thing that doesn't abide by majority rule is a person's conscience'.");
    	mockingbirdPreview.add("Back Cover: That rare literary phenomenon, a Southern novel with no mildew on its magnolia leaves.");
    	ArrayList<String> gatsbyPreview = new ArrayList<>();
    	gatsbyPreview.add("Front Cover: A woman's face sheds a tear, and blends in to the night sky. A bright city scene illuminates itself below. ");
    	gatsbyPreview.add("Inside Cover: 'I love her and that's the beginning and end of everything.'");
    	gatsbyPreview.add("Back Cover: It is a magical, living book, blended of irony, romance, and mysticism.");
    	ArrayList<String> frankensteinPreview = new ArrayList<>();
    	frankensteinPreview.add("Front Cover: An isolated castle sits below a pitch black sky filled with lightning.");
    	frankensteinPreview.add("Inside Cover: 'Beware, for I am fearless, and therefore powerful.' ");
    	frankensteinPreview.add("Back Cover: You are my creator, but I am your master - obey!");
    	ArrayList<String> flowersPreview = new ArrayList<>();
    	flowersPreview.add("Front Cover: A black inkblot, dotted with blue and yellow flowers, sits in the middle of a white background.");
    	flowersPreview.add("Inside Cover: 'There are so many doors to open. I am impatient to begin.' ");
    	flowersPreview.add("Back Cover: An insightful first-person account of the difficulties and joys of the writing life and...\none of the most useful writers' manuals to be published in a long time.");
    	ArrayList<String> twilightPreview = new ArrayList<>();
    	twilightPreview.add("Front Cover: A lightly colored, pair of delicate looking hands hold a bright red apple on top of a deep black backdrop.");
    	twilightPreview.add("Inside Cover: 'What if I'm not the hero? What if I'm the bad guy?' ");
    	twilightPreview.add("Back Cover: An Amazon 'Best Book of the Decade...So Far'.");
    	ArrayList<String> hungerGamesPreview = new ArrayList<>();
    	hungerGamesPreview.add("Front Cover: A golden emblem of a bird holding an arrow is centered among a maze of concentrenic circles.");
    	hungerGamesPreview.add("Inside Cover: 'Hope is the only thing stronger than fear.' ");
    	hungerGamesPreview.add("Back Cover: A violent, jarring, speed-rap of a novel that generates nearly constant suspense.");
    	ArrayList<String> jamesPeachPreview = new ArrayList<>();
    	jamesPeachPreview.add("Front Cover: A silouette of a young boy standing with giant insects appear to be dancing.");
    	jamesPeachPreview.add("Inside Cover: 'There are a whole lot of things in this world of ours you haven't started wondering about yet.'");
    	jamesPeachPreview.add("Back Cover: Poor James is miserable until something peculiar happens and James finds himself on the most wonderful and extraordinary \n journey he could ever imagine.");
    	ArrayList<String> charlieChocolatePreview = new ArrayList<>();
    	charlieChocolatePreview.add("Front Cover: A small boy is smiling wildy, holding a golden ticket. He is standing next to an eccentric looking man wearing a top hat.");
    	charlieChocolatePreview.add("Inside Cover: 'The greatest secrets are always hidden in the most unlikely places.'");
    	charlieChocolatePreview.add("Back Cover: Charlie Bucket, Our Hero, a boy who is honest and kind, brave, and true, and good and ready for the wildes time of his life!");
    	ArrayList<String> graveyardPreview = new ArrayList<>();
    	graveyardPreview.add("Front Cover: A rumpled metal silouette is kneeling and facing off into the darkness.");
    	graveyardPreview.add("Inside Cover: 'If you dare nothing, then when the day is over, nothing is all you will have gained.' ");
    	graveyardPreview.add("Back Cover: Like a bite of dark Halloween chocolate, this novel proves rich, bittersweet, and very satisfying.");
    	ArrayList<String> coralinePreview = new ArrayList<>();
    	coralinePreview.add("Front Cover: A young girl with distorted eyes stares past the viewer. She is holding a golden candle, and set on a blotchy black background.");
    	coralinePreview.add("Inside Cover: 'She's got this whole world where everything's better. The food, the garden, the neighbors. But it's all a trap. ");
    	coralinePreview.add("Back Cover: Coraline will have to fight with all her wits and courage if she is to save herself and return to her ordinary life.");

        INVENTORY.addItem(new DVD("The Goonies", Status.ON_SHELF, gooniesPreview, 114, "Richard Donner"));
        INVENTORY.addItem(new DVD("The Lost Boys", Status.CHECKED_OUT, lostBoysPreview, 97, "Joel Schumacher" ));
        INVENTORY.addItem(new DVD("Stand By Me", Status.ON_SHELF, standByMePreview, 89, "Rob Reiner"));
    	INVENTORY.addItem(new DVD("Attack On Titan: Season 3", Status.ON_SHELF, attackOnTitanPreview, 506, "Masashi Koizuka"));

        INVENTORY.addItem(new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT, 10, hitchHikerPreview));
        INVENTORY.addItem(new Book("The Shining", "Stephen King", Status.ON_SHELF));
        INVENTORY.addItem(new Book("Harry Potter and the Sorcerer's Stone", "Daniel Radcliffe", Status.ON_SHELF, 5));
        INVENTORY.addItem(new Book("Dilla Time", "Dan Charnas", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("To Kill a Mockingbird", "Harper Lee", Status.CHECKED_OUT, 4));
        INVENTORY.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", Status.ON_SHELF, 4));
        INVENTORY.addItem(new Book("Frankenstein", "Mary Shelley", Status.ON_SHELF, 4));
        INVENTORY.addItem(new Book("Flowers for Algernon", "Daniel Keyes", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("Twilight", "Stephenie Meyer", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("The Hunger Games", "Suzanne Collins", Status.CHECKED_OUT, 10));
        INVENTORY.addItem(new Book("James and the Giant Peach", "Roald Dahl", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("Charlie and the Chocolate Factory", "Roald Dahl", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("The Graveyard Book", "Neil Gaiman", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("Coraline", "Neil Gaiman", Status.ON_SHELF, 10));

        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d items. To see what we have, type 'list'!%n", INVENTORY.getItems().size());
        System.out.println("To search for an item, type 'search <author/director>' or 'search <title>'..");

        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            if (!runCommand(s)) {
                System.out.println("ERROR: Command not found!");
                System.out.println("To view a list of available commands, type 'help'!");
            }
        }
        
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static boolean runCommand(String s) {
            //Input has arguments
            //return 3 -> [return, 3]
            if (s.split(" ").length > 1) {
                for (Command command : COMMANDS) {
                    // Take the actual command text out of the input
                    // So 'return 3' -> '3'
                    // That way when we are working in the execute method we won't have to substring that out
                    if (command.getName().equalsIgnoreCase(s.split(" ")[0])) {
                        try {
                            command.execute(s.substring(command.getName().length() + 1));
                        } catch (Exception e) {
                            System.out.println("Error running command. For help, type 'help'!");
                        }
                        return true;
                    }
                }
            } else {
                // No arguments, so we will iterate each command and run it directly
                for (Command command : COMMANDS) {
                    if (command.getName().equalsIgnoreCase(s)) {
                        try {
                            command.execute(s);
                        } catch (Exception e) {
                            System.out.println("Error running command. For help, type 'help'!");
                        }
                        return true;
                    }
                }
            }
        return false;
    }
}
