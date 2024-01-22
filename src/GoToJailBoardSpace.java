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
    @Override
    public void activateAbility() {

    }
}
