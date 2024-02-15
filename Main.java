import cards.CardSuit;
import cards.CardValue;
import cards.Deck;
import graphics.ShapeRenderer;
import sorting.Sorting;
import javafx.application.Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Deck of cards - arrays, sorting, shuffling, methods, attributes, input & output, enums
        //handleDeckOfCards();

        // Shapes - inheritance, abstract classes, method overriding, JavaFX
        //Application.launch(ShapeRenderer.class, args);

        // Sorting algos - insertion, merge, heap and quick
        Sorting.handleSort();
    }

    // DECK OF CARDS

    private static void handleDeckOfCards() {
        Scanner sc = new Scanner(System.in);

        System.out.println("You are about to create a deck of cards. Do you want to includes jokers in your deck?");
        System.out.println("Press 1 for yes, 0 for no");

        int includeJokers = sc.nextInt();
        boolean handledIncludeJokers = determineIncludeJokers(includeJokers);

        CardSuit[] suits = CardSuit.getAll();
        CardValue[] values = CardValue.getAllExcludingJoker();
        Deck deck = new Deck(suits, values, handledIncludeJokers);

        if (handledIncludeJokers) {
            System.out.println("A deck of cards has been created with jokers!");
        } else {
            System.out.println("A deck of cards has been created without jokers!");
        }
        System.out.println("Enter an integer to determine the number of actions you want to take. You will be able to (shuffle) or (sort) the deck of cards this many times before the program terminates.");

        int numberOfActions = sc.nextInt();
        int handledNumberOfActions = determineNumberOfActions(numberOfActions);

        handleActions(handledNumberOfActions, deck, sc);
    }

    private static boolean determineIncludeJokers(int includeJokers) {
        if (includeJokers < 0 || includeJokers > 1) {
            System.out.println("Invalid input, defaulting to deck without jokers");
            return false;
        }
        return includeJokers == 1;
    }

    private static int determineNumberOfActions(int numberOfActions) {
        if (numberOfActions < 1) {
            System.out.println("Number of actions cannot be less than 1, so has been set to 1");
            return 1;
        } else if (numberOfActions <= 5) {
            System.out.println("Number of actions set to " + numberOfActions);
            return numberOfActions;
        } else {
            System.out.println("Number of actions cannot be more than 5, so has been set to 5");
            return 5;
        }
    }

    private static void handleActions(int numberOfActions, Deck deck, Scanner sc) {
        for (int i = numberOfActions ; i > 0 ; i--) {
            System.out.println("Enter an integer to perform an action: 1 (shuffle) or 2 (sort)");
            int actionNumber = sc.nextInt();
            alterDeckOfCards(actionNumber, deck);
        }
    }

    private static void alterDeckOfCards(int actionNumber, Deck deck) {
        switch(actionNumber) {
            case 1:
                deck.shuffle();
                System.out.println(deck.getDeckList());
                break;
            case 2:
                deck.sortByValue();
                deck.sortBySuit();
                System.out.println(deck.getDeckList());
                break;
            default:
                System.out.println("Value entered does not correspond to an action");
        }
    }
}
