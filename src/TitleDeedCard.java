public class TitleDeedCard extends Card {
    private String cardOwner;
    private boolean mortgage;
    private int mortgageAmount;
    private int level;

    private int[] rentAmounts;

    public TitleDeedCard(int mortgageAmount, int[] rentAmounts) {
        cardOwner = null;
        mortgage = false;
        this.mortgageAmount = mortgageAmount;
        this.rentAmounts = rentAmounts;
        level = 0;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public boolean isMortgage() {
        return mortgage;
    }

    public int getMortgageAmount() {
        return mortgageAmount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
