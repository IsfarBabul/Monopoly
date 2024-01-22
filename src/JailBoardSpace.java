public class JailBoardSpace extends BoardSpace {
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
    @Override
    public void activateAbility() {

    }
}
