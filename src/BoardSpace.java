public abstract class BoardSpace {
    private String name;
    private String[][] layout;
    private String[] playerPositions;

    public String getName() {
        return name;
    }

    public String[][] getLayout() {
        return layout;
    }

    public void setLayout(String[][] layout) {
        this.layout = layout;
    }

    public String[] getPlayerPositions() {
        return playerPositions;
    }

    public abstract void activateAbility();
}
