import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

    private final List<String> suits = Arrays.asList("hearts", "diamonds", "spades", "clubs");
    private final List<String> nonNumericValues = Arrays.asList("ace", "jack", "queen", "king");
    private List<String> deckList = new ArrayList<>();

    public Deck() {
        instantiateSuits();
    }

    private void instantiateSuits() {
        for(String suit : suits){
            instantiateSuitsWithValues(suit);
        }
    }

    private void instantiateSuitsWithValues(String suit) {
        for(String nonNumericValue : nonNumericValues) {
            deckList.add(nonNumericValue + " of " + suit);
        }

        for(int i = 2 ; i <= 10 ; i++) {
            deckList.add(i + " of " + suit);
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

                int lowValue = getNumericValue(deckList.get(j - 1));
                int highValue = getNumericValue(deckList.get(j));

                if(lowValue > highValue) {
                    String lowValueFullCardName = deckList.get(j - 1);
                    deckList.set(j - 1, deckList.get(j));
                    deckList.set(j, lowValueFullCardName);
                }
            }
        }
    }

    public int getNumericValue(String fullCardName) {
        String value = fullCardName.split(" of ")[0];
        int numericValue;
        switch(value) {
            case "ace":
                numericValue = 1;
                break;
            case "jack":
                numericValue = 11;
                break;
            case "queen":
                numericValue = 12;
                break;
            case "king":
                numericValue = 13;
                break;
            default:
                numericValue = Integer.parseInt(value);
        }
        return numericValue;
    }

    public void sortBySuit() {
        int length = deckList.size();

        for(int i = 0 ; i < length ; i++){
            for(int j = 1 ; j < (length - i) ; j++){

                int lowValue = getSuitIndex(deckList.get(j - 1));
                int highValue = getSuitIndex(deckList.get(j));

                if(lowValue > highValue){
                    String lowValueFullCardName = deckList.get(j - 1);
                    deckList.set(j - 1, deckList.get(j));
                    deckList.set(j, lowValueFullCardName);
                }
            }
        }
    }

    public int getSuitIndex(String fullCardName) {
        String value = fullCardName.split(" of ")[1];
        int numericValue;
        switch(value) {
            case "spades":
                numericValue = 1;
                break;
            case "clubs":
                numericValue = 2;
                break;
            case "hearts":
                numericValue = 3;
                break;
            case "diamonds":
                numericValue = 4;
                break;
            default:
                numericValue = Integer.parseInt(value);
        }
        return numericValue;
    }

    public List<String> getDeckList() {
        return deckList;
    }
}
