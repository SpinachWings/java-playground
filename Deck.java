import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

    private final CardSuit[] suits;
    private final CardValue[] values;
    private final List<String> deckList = new ArrayList<>();
    private final int jokerIndexForSorting = 99;

    // implement search algorithm?
    // be able to instantiate decks with and without jokers?

    public Deck(CardSuit[] suits, CardValue[] values, boolean includeJokers) {
        this.suits = suits;
        this.values = values;
        instantiateDeckList();
        if (includeJokers) {
            addJokers();
        }
    }

    private void instantiateDeckList() {
        for(CardSuit suit : suits){
            for(CardValue value : values) {
                deckList.add(value.getValue() + " of " + suit.getSuit());
            }
        }
    }

    private void addJokers() {
        for (int i = 0 ; i < 2 ; i++) {
            deckList.add(CardValue.JOKER.getValue());
        }
    }

    public void shuffle() {
        Random random = new Random();
        random.nextInt();
        int length = deckList.size();

        for (int i = 0 ; i < length ; i++) {
            int randomIndex = i + random.nextInt(length - i);
            String currentValue = deckList.get(i);
            deckList.set(i, deckList.get(randomIndex));
            deckList.set(randomIndex, currentValue);
        }
    }

    public void sortByValue() {
        int length = deckList.size();

        for(int i = 0 ; i < length ; i++){
            for(int j = 1 ; j < (length - i) ; j++){

                int lowValue = getValueIndexFromFullCardName(deckList.get(j - 1));
                int highValue = getValueIndexFromFullCardName(deckList.get(j));

                if(lowValue > highValue) {
                    String lowValueFullCardName = deckList.get(j - 1);
                    deckList.set(j - 1, deckList.get(j));
                    deckList.set(j, lowValueFullCardName);
                }
            }
        }
    }

    private int getValueIndexFromFullCardName(String fullCardName) {
        if (cardIsJoker(fullCardName)) {
            return jokerIndexForSorting;
        }
        String value = fullCardName.split(" of ")[0];
        return CardValue.getByValue(value).getIndex();
    }

    private boolean cardIsJoker(String fullCardName) {
        return fullCardName.equals(CardValue.JOKER.getValue());
    }

    public void sortBySuit() {
        int length = deckList.size();

        for(int i = 0 ; i < length ; i++){
            for(int j = 1 ; j < (length - i) ; j++){

                int lowValue = getSuitIndexFromFullCardName(deckList.get(j - 1));
                int highValue = getSuitIndexFromFullCardName(deckList.get(j));

                if(lowValue > highValue){
                    String lowValueFullCardName = deckList.get(j - 1);
                    deckList.set(j - 1, deckList.get(j));
                    deckList.set(j, lowValueFullCardName);
                }
            }
        }
    }

    private int getSuitIndexFromFullCardName(String fullCardName) {
        if (cardIsJoker(fullCardName)) {
            return jokerIndexForSorting;
        }
        String suit = fullCardName.split(" of ")[1];
        return CardSuit.getBySuit(suit).getIndex();
    }

    public List<String> getDeckList() {
        return deckList;
    }
}
