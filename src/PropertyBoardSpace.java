public class PropertyBoardSpace extends BoardSpace {
    private TitleDeedCard titleDeedCard;

    public PropertyBoardSpace(String name, TitleDeedCard titleDeedCard, String color) {
        super(name);
        this.titleDeedCard = titleDeedCard;
        String[][] layout = new String[6][3];
        for (int i = 0; i < 3; i++) {
            layout[0][i] = color;
            layout[1][i] = color;
        }
        for (int j = 2; j < 6; j++) {
            for (int i = 0; i < 3; i++) {
                layout[j][i] = "⬜";
            }
        }
        setLayout(layout);

    }

    public void setOccupyingSpaces(int length) {
        super.setOccupyingSpaces(length, 1, 4);
    }

    @Override
    public void activateAbility() {
        if (titleDeedCard.getCardOwner() == null) {

        }
    }
}
