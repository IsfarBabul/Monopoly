public class FreeParkingBoardSpace extends BoardSpace {
    private int[] xCoords = {1, 1, 1, 1, 2, 2, 2, 2};
    private int[] yCoords = {1, 2, 3, 4, 1, 2, 3, 4};
    public FreeParkingBoardSpace(String name) {
        super(name);
        String[][] layout = {{"🛑", "🛣️", "🛣️", "🛣️", "🛣️", "🛑"},
                             {"🌇", "🚥", "⬜", "⬜", "🚥", "🌆"},
                             {"🌇", "⬜", "⬜", "⬜", "⬜", "🌆"},
                             {"🌇", "⬜", "⬜", "⬜", "⬜", "🌆"},
                             {"🌇", "🚥", "⬜", "⬜", "🚥", "🌆"},
                             {"🛑", "🌃", "🌃", "🌃", "🌃", "🛑"}};
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
