public class TaxBoardSpace extends BoardSpace {
    boolean isIncome;
    public TaxBoardSpace(String name, boolean isIncome) {
        super(name);
        this.isIncome = isIncome;
        String[][] layout;
        if (isIncome) {
            layout = new String[][]{{"⬜", "⬜", "⬜"},
                                    {"⬜", "♦️", "⬜"},
                                    {"⬜", "🏛️", "⬜"},
                                    {"🏛️", "⬜", "🏛️"},
                                    {"⬜", "🏛️", "⬜"},
                                    {"⬜", "⬜", "⬜"}};
        } else {
            layout = new String[][]{{"⬜", "⬜", "⬜"},
                                    {"⬜", "💠", "⬜"},
                                    {"⬜", "🟨", "⬜"},
                                    {"🟨", "⬜", "🟨"},
                                    {"⬜", "🟨", "⬜"},
                                    {"⬜", "⬜", "⬜"}};
        }
        setLayout(layout);
    }
    @Override
    public void activateAbility() {
        if (isIncome) {

        } else {

        }
    }
}
