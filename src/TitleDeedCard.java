public abstract class TitleDeedCard extends Card {
    private String color;
    private String cardOwner;
    private boolean mortgage;
    private int mortgageAmount;
    private int level;


    public TitleDeedCard(int mortgageAmount, String color) {
        this.color = color;
        cardOwner = null;
        mortgage = false;
        this.mortgageAmount = mortgageAmount;
        level = 0;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getColor() {
        return color;
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

    public abstract int getRentAmount();
}
