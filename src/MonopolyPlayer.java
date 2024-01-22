import java.util.ArrayList;

public class MonopolyPlayer {
    private String playerName;
    private String playerToken;
    private int playerMoney;
    private ArrayList<Card> playerHand;

    public MonopolyPlayer(String playerName, String playerToken) {
        this.playerName = playerName;
        this.playerToken = playerToken;
        playerMoney = 2500;
        playerHand = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerToken() {
        return playerToken;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }
    public void incrementPlayerMoney(int increment) {
        playerMoney += increment;
    }
    public void decrementPlayerMoney(int decrement) {
        playerMoney += decrement;
    }
    public void addCard(Card addedCard) {
        if (addedCard instanceof ChanceCard || addedCard instanceof CommunityChestCard) {
            playerHand.add(0, addedCard);
        } else {
            playerHand.add(addedCard);
        }
    }
    private void sortHand() {
        String[] colorOrder = {"🟫", "⏹️", "🟪", "🟧", "🟥", "🟨", "🟩", "🟦", "🔳", "✳️"};
        ArrayList<Card> sortedPlayerHand = new ArrayList<>(playerHand.size());
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i) instanceof ChanceCard || playerHand.get(i) instanceof CommunityChestCard) {
                sortedPlayerHand.set(i, playerHand.get(i));
            } else {
                for (int j = i; j < playerHand.size(); j++) {
                    TitleDeedCard card = (TitleDeedCard) playerHand.get(j);
                    for (String color : colorOrder) {
                        if (card.getColor().equals(color)) {
                            sortedPlayerHand.set(i, playerHand.get(j));
                            playerHand.remove(j);
                        }
                    }
                }
            }
        }
        playerHand = sortedPlayerHand;
    }
}
