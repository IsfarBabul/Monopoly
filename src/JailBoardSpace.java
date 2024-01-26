public class JailBoardSpace extends BoardSpace {
    private int[] xCoords = {1, 1, 1, 1, 2, 3, 4, 5};
    private int[] yCoords = {0, 1, 2, 3, 4, 4, 4, 4};
    public JailBoardSpace(String name) {
        super(name);
        String[][] layout = {{"⬜", "⬜", "⛔", "🟧", "🟧", "🟧"},
                             {"⬜", "⬜", "⛔", "🟧", "👺", "🟧"},
                             {"⬜", "⬜", "⛔", "🟧", "🟧", "🟧"},
                             {"⬜", "⬜", "⛔", "⛔", "⛔", "⛔"},
                             {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜"},
                             {"⬜", "⬜", "⬜", "⬜", "⬜", "⬜"}};
        setLayout(layout);
    }

    public void setOccupyingSpaces(int length) {
        super.setOccupyingSpaces(length, xCoords, yCoords);
    }

    public int[] getxCoords() {
        return xCoords;
    }

    public int[] getyCoords() {
        return yCoords;
    }

    @Override
    public void activateAbility() {

    }
}
