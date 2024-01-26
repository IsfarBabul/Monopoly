import java.util.ArrayList;

public abstract class BoardSpace {
    private String name;
    private String[][] layout;

    private MonopolyPlayer[] occupyingPlayers;

    private String[] occupyingSpaces;

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

    public void changeLayout(String change, int x, int y) {
        layout[y][x] = change;
    }

    public void addOccupyingPlayer(MonopolyPlayer occupyingPlayer) {
        for (int i = 0; i < occupyingPlayers.length; i++) {
            if (occupyingPlayers[i] == null) {
                occupyingPlayers[i] = occupyingPlayer;
                break;
            }
        }
    }

    public void removeOccupyingPlayer(MonopolyPlayer occupyingPlayer) {
        boolean removedOccupyingPlayer = false;
        for (int i = 0; i < occupyingPlayers.length; i++) {
            if (occupyingPlayers[i] == occupyingPlayer) {
                removedOccupyingPlayer = true;
                occupyingPlayers[i] = null;
            }
            if (removedOccupyingPlayer) {
                occupyingPlayers[i] = occupyingPlayers[i + 1];
            }
        }
    }

    public void addOccupyingToken(MonopolyPlayer occupyingPlayer, MonopolyPlayer[] turnOrder) {
        int count = 0;
        if (occupyingSpaces.length != 1) {
            for (int i = 0; i < turnOrder.length; i++) {
                if (turnOrder[i] == occupyingPlayer) {
                    count = i;
                    break;
                }
            }
        }
        if (occupyingSpaces[count].equals("⬜")) {
            occupyingSpaces[count] = occupyingPlayer.getPlayerToken();
        } else {
            occupyingSpaces[count] = "👨‍👩‍👧‍👦";
        }
    }

    public void removeOccupyingToken(MonopolyPlayer occupyingPlayer, MonopolyPlayer[] turnOrder) {
        int count = 0;
        if (occupyingSpaces.length != 1) {
            for (int i = 0; i < turnOrder.length; i++) {
                if (turnOrder[i] == occupyingPlayer) {
                    count = i;
                    break;
                }
            }
        }
        if (occupyingSpaces[count].equals(occupyingPlayer.getPlayerToken())) {
            occupyingSpaces[count] = "⬜";
        } else {
            if (occupyingPlayers.length == 1) {
                occupyingSpaces[count] = occupyingPlayers[0].getPlayerToken();
            }
        }
    }

    public void setOccupyingSpaces(int length, int[] xCoords, int[] yCoords) {
        occupyingPlayers = new MonopolyPlayer[length];
        occupyingSpaces = new String[length];
        for (int i = 0; i < length; i++) {
            this.occupyingSpaces[i] = layout[yCoords[i]][xCoords[i]];
        }
    }

    public void setOccupyingSpaces(int length, int xCoord, int yCoord) {
        occupyingPlayers = new MonopolyPlayer[length];
        occupyingSpaces = new String[1];
            this.occupyingSpaces[0] = layout[yCoord][xCoord];
    }

    public abstract void activateAbility();
}
