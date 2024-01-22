public class RailroadTitleDeedCard extends TitleDeedCard {
    public RailroadTitleDeedCard(int mortgageAmount, String color) {
        super(mortgageAmount, color);
    }

    @Override
    public int getRentAmount() {
        return 25 * (int) Math.pow(2, getLevel());
    }
}
