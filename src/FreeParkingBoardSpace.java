public class FreeParkingBoardSpace extends BoardSpace {
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
    @Override
    public void activateAbility() {

    }
}
