public class PropertyTitleDeedCard extends TitleDeedCard {
    private int[] rentAmounts;
    public PropertyTitleDeedCard(int mortgageAmount, int[] rentAmounts, String color) {
        super(mortgageAmount, color);
        this.rentAmounts = rentAmounts;
    }

    @Override
    public int getRentAmount() {
        return rentAmounts[getLevel()];
    }
}
