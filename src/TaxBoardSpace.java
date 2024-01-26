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

    public void setOccupyingSpaces(int length) {
        super.setOccupyingSpaces(length, 1, 3);
    }

    @Override
    public void activateAbility() {
        if (isIncome) {

        } else {

        }
    }
}
