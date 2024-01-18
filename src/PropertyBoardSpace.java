public class PropertyBoardSpace extends BoardSpace {

    public PropertyBoardSpace(String color) {
        String[][] layout = new String[6][3];
        for (int i = 0; i < 3; i++) {
            layout[0][i] = color;
        }
        for (int j = 1; j < 6; j++) {
            for (int i = 0; i < 3; i++) {
                layout[j][i] = "⬜";
            }
        }
        setLayout(layout);
    }
    @Override
    public void activateAbility() {

    }
}
