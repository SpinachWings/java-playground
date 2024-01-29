package cards;

public enum CardValue {
    ACE(0, "Ace"),
    TWO(1, "2"),
    THREE(2, "3"),
    FOUR(3, "4"),
    FIVE(4, "5"),
    SIX(5, "6"),
    SEVEN(6, "7"),
    EIGHT(7, "8"),
    NINE(8, "9"),
    TEN(9, "10"),
    JACK(10, "Jack"),
    QUEEN(11, "Queen"),
    KING(12, "King"),
    JOKER(13, "Joker");

    private final int index;
    private final String value;

    CardValue(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public static CardValue[] getAll() {
        return CardValue.values();
    }

    public static CardValue[] getAllExcludingJoker() {
        CardValue[] allValues = getAll();
        CardValue[] allValuesExcludingJoker = new CardValue[allValues.length - 1];
        int j = 0;
        for (CardValue allValue : allValues) {
            if (allValue != JOKER) {
                allValuesExcludingJoker[j] = allValue;
                j++;
            }
        }
        return allValuesExcludingJoker;
    }

    public static CardValue getJoker() {
        return JOKER;
    }

    public static CardValue getByValue(String value) {
        for(CardValue cardValue : CardValue.getAll()) {
            if(cardValue.getValue().equals(value)) {
                return cardValue;
            }
        }
        return ACE; // default
    }
}
