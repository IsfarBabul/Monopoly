public class GoBoardSpace extends BoardSpace {
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
    @Override
    public void activateAbility() {

    }
}
