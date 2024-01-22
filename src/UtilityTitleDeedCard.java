public class UtilityTitleDeedCard extends TitleDeedCard {
    public UtilityTitleDeedCard(int mortgageAmount, String color) {
        super(mortgageAmount, color);
    }

    @Override
    public int getRentAmount() {
        return 0;
    }

    public int getRentAmount(int totalRoll) {
        if (getLevel() == 0) {
            return totalRoll * 4;
        } else {
            return totalRoll * 10;
        }
    }
}
