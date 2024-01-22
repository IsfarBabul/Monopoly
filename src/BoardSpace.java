import java.util.ArrayList;

public abstract class BoardSpace {
    private String name;
    private String[][] layout;
    private String playerPosition;
    private ArrayList<MonopolyPlayer> landedPlayers = new ArrayList<>();
    public BoardSpace(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[][] getLayout() {
        return layout;
    }

    public void setLayout(String[][] layout) {
        this.layout = layout;
    }

    public String getPlayerPositions() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void addLandedPlayer(MonopolyPlayer player) {
        landedPlayers.add(player);
    }
    public void removeLandedPlayer(MonopolyPlayer player) {
        landedPlayers.remove(player);
    }

    public abstract void activateAbility();
}
