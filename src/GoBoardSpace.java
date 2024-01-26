public class GoBoardSpace extends BoardSpace {
    private int[] xCoords = {0, 1, 2, 2, 2, 1, 0, 0};
    private int[] yCoords = {0, 0, 0, 1, 2, 2, 2, 1};

    public GoBoardSpace(String name) {
        super(name);
        String[][] layout = {{"⬜", "⬜", "⬜", "🚥", "🟥", "🚥"},
                             {"⬜", "⬜", "⬜", "⬜", "🟥", "⬜"},
                             {"⬜", "⬜", "⬜", "⬜", "🟥", "⬜"},
                             {"🚥", "🟥", "⬜", "⬜", "🟥", "⬜"},
                             {"🟥", "🟥", "🟥", "🟥", "🟥", "⬜"},
                             {"🚥", "🟥", "⬜", "⬜", "⬜", "⬜"}};
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
