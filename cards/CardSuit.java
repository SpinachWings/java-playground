package cards;

public enum CardSuit {
    SPADES(0, "Spades"),
    CLUBS(1, "Clubs"),
    HEARTS(2, "Hearts"),
    DIAMONDS(3, "Diamonds");

    private final int index;
    private final String suit;

    CardSuit(int index, String suit) {
        this.index = index;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public int getIndex() {
        return index;
    }

    public static CardSuit[] getAll() {
        return CardSuit.values();
    }

    public static CardSuit getBySuit(String suit) {
        for(CardSuit cardSuit : CardSuit.getAll()) {
            if(cardSuit.getSuit().equals(suit)) {
                return cardSuit;
            }
        }
        return SPADES; // default
    }
}