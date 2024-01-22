public class CardBoardSpace extends BoardSpace {
    boolean isChance;
    public CardBoardSpace(String name, boolean isChance) {
        super(name);
        this.isChance = isChance;
        String[][] layout;
        if (isChance) {
            layout = new String[][]{{"🟧", "⬜", "🟧"},
                                    {"⬜", "🟧", "⬜"},
                                    {"🟧", "🟧", "⬜"},
                                    {"🟧", "⬜", "🟧"},
                                    {"🟧", "🟧", "🟧"},
                                    {"🟧", "⬜", "🟧"}};
        } else {
            layout = new String[][]{{"⬜", "🟦", "🟦"},
                                    {"🟦", "⬜", "⬜"},
                                    {"🟦", "🟦", "⬜"},
                                    {"🟦", "⬜", "⬜"},
                                    {"🟦", "🟦", "⬜"},
                                    {"🟦", "⬜", "⬜"}};
        }
        setLayout(layout);
    }
    @Override
    public void activateAbility() {
        if (isChance) {

        } else {

        }
    }
}
