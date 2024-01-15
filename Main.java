public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.getDeckList());

        deck.sortByValue();
        deck.sortBySuit();
        System.out.println(deck.getDeckList());
    }
}
