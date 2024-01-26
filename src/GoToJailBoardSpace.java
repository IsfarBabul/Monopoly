public class GoToJailBoardSpace extends BoardSpace {
    public GoToJailBoardSpace(String name) {
        super(name);
        String[][] layout = {{"🟥", "🟦", "🟦", "🟦", "🟦", "🟦"},
                             {"🟥", "🚔", "🚓", "🚔", "🚓", "🟥"},
                             {"🟥", "🚓", "⬜", "⬜", "🚔", "🟥"},
                             {"🟥", "🚔", "⬜", "⬜", "🚓", "🟥"},
                             {"🟥", "🚓", "🚔", "🚓", "🚔", "🟥"},
                             {"🟦", "🟦", "🟦", "🟦", "🟦", "🟥"}};
        setLayout(layout);
    }

    public void setOccupyingSpaces(int length) {
        super.setOccupyingSpaces(length, 2, 2);
    }

    @Override
    public void activateAbility() {

    }
}
