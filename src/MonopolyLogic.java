import java.util.ArrayList;
import java.util.Scanner;

public class MonopolyLogic {

    private String[][] board;
    private BoardSpace[] boardSpaces;
    private TitleDeedCard[] titleDeeds;
    private MonopolyPlayer[] turnOrder;
    private MonopolyPlayer currentPlayer;
    private Die die1;
    private Die die2;
    private SpeedDie speedDie;
    private boolean win;
    private Scanner scan;

    public MonopolyLogic() {
        board = createBoard();
        boardSpaces = new BoardSpace[40];
        scan = new Scanner(System.in);
        placeOnBoard(MonopolyDecorations.moneySign, 9, 9);
        placeOnBoard(MonopolyDecorations.monopolySign, 9, 17);
        placeOnBoard(flipSpace(MonopolyDecorations.monopolyInvertedSign), 9, 29);
        placeOnBoard(MonopolyDecorations.chanceAndCommunityChest, 9, 33);
        createPropertyTitleDeeds();
        createBoardSpaces();
        die1 = new Die();
        die2 = new Die();
        speedDie = new SpeedDie();
        win = false;
    }

    public void run() {
        board();
        System.out.println();
        printBoard();
        initializePlayers();
        int count = 0;
        currentPlayer = turnOrder[count];
        while (!win) {
            System.out.println("It's " + currentPlayer.getPlayerName() + "'s turn to roll. Type anything to roll.");
            scan.nextLine();
            turn();
            count++;
            if (count == turnOrder.length) {
                count = 0;
            }
            currentPlayer = turnOrder[count];
        }
        System.out.println("The winner is " + currentPlayer.getPlayerName());
    }

    private void initializePlayers() {
        ConsoleUtility.clearScreen();
        System.out.print("How many players would like to play? ");
        int numPlayers = scan.nextInt();
        scan.nextLine();
        turnOrder = new MonopolyPlayer[numPlayers];
        GoBoardSpace goSpace = (GoBoardSpace) boardSpaces[0];
        goSpace.setOccupyingSpaces(numPlayers);
        System.out.println(numPlayers); //TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
        for (int i = 0; i < numPlayers; i++) {
            printBoard();
            System.out.print("What name would this player like to have? ");
            String name = scan.nextLine();
            System.out.println();
            System.out.print("What token would this player like to have? (can be any character but an emoji is recommended) ");
            String token = scan.nextLine();
            boardSpaces[0].changeLayout(token, ((GoBoardSpace) boardSpaces[0]).getxCoords()[i], ((GoBoardSpace) boardSpaces[0]).getyCoords()[i]);
            updateBoardSpaces();
            System.out.println();
            token = token.substring(0, 1);
            MonopolyPlayer player = new MonopolyPlayer(name, token);
            turnOrder[i] = player;
            ConsoleUtility.clearScreen();
        }
        printBoard();
        //System.out.println("Now, it's time to determine who goes first.");
        //turnOrder = changeOrder(turnOrder.length);
    }

    /*private MonopolyPlayer[] changeOrder(int numPlayers) {
        int[] rolledAmounts = new int[turnOrder.length];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print(turnOrder[i].getPlayerName() + ", click anything to roll.");
            scan.nextLine();
            int numberRolled = roll();
            System.out.println();
            System.out.print("It looks like you got a " + numberRolled);
            rolledAmounts[i] = numberRolled;
            ConsoleUtility.clearScreen();
        }
        return turnOrder;
    }*/

    private void turn() {
        int rolledNumbers = roll();
        move(rolledNumbers);
    }

    private int roll() {
        for (int i = 0; i < 5; i++) {
            die1.rollDie();
            die2.rollDie();
            placeOnBoard(die1.dieAnimation(), 9, 21);
            placeOnBoard(die2.dieAnimation(), 33, 21);
            updateBoardSpaces();
            printBoard();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
        die1.rollDie();
        die2.rollDie();
        placeOnBoard(Die.getActualRoll(), 8, 20);
        placeOnBoard(Die.getActualRoll(), 32, 20);
        placeOnBoard(die1.dieAnimation(), 9, 21);
        placeOnBoard(die2.dieAnimation(), 33, 21);
        updateBoardSpaces();
        printBoard();
        return die1.getRoll() + die2.getRoll();
    }

    private void move(int rolledNumbers) {
        int boardSpaceNumber = currentPlayer.getBoardSpaceNumber() + rolledNumbers;
        currentPlayer.setBoardSpaceNumber(boardSpaceNumber);
        for (int i = currentPlayer.getBoardSpaceNumber(); i < boardSpaceNumber; i++) {
            boardSpaces[i].removeOccupyingToken(currentPlayer, turnOrder);
            int j;
            if (i >= 40) {
                j = i - 40;
            } else {
                j = i;
            }
            boardSpaces[j + 1].addOccupyingToken(currentPlayer, turnOrder);
            updateBoardSpaces();
            printBoard();
        }
    }

    public String[][] createBoard() {
        String[][] board = new String[50][50];
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                board[y][x] = "⬛";
            }
        }
        return board;
    }

    public void printBoard() {
        for (int y = 0; y < 49; y++) {
            for (int x = 0; x < 49; x++) {
                System.out.print(board[y][x]);
            }
            System.out.println();
        }
    }

    private void createPropertyTitleDeeds() {
        TitleDeedCard mediterraneanAvenue = new PropertyTitleDeedCard(30, new int[]{2, 4, 10, 30, 90, 160, 250}, "🟫");
        TitleDeedCard balticAvenue = new PropertyTitleDeedCard(30, new int[]{4, 8, 20, 60, 180, 320, 450}, "🟫");
        TitleDeedCard orientalAvenue = new PropertyTitleDeedCard(50, new int[]{6, 12, 30, 90, 270, 400, 550}, "⏹️");
        TitleDeedCard vermontAvenue = new PropertyTitleDeedCard(50, new int[]{6, 12, 30, 90, 270, 400, 550}, "⏹️");
        TitleDeedCard connecticutAvenue = new PropertyTitleDeedCard(60, new int[]{8, 16, 40, 100, 300, 450, 600}, "⏹️");
        TitleDeedCard stCharlesPlace = new PropertyTitleDeedCard(70, new int[]{10, 20, 50, 150, 450, 625, 750}, "🟪");
        TitleDeedCard statesAvenue = new PropertyTitleDeedCard(70, new int[]{10, 20, 50, 150, 450, 625, 750}, "🟪");
        TitleDeedCard virginiaAvenue = new PropertyTitleDeedCard(80, new int[]{12, 24, 60, 180, 500, 700, 900}, "🟪");
        TitleDeedCard stJamesPlace = new PropertyTitleDeedCard(90, new int[]{12, 28, 70, 200, 550, 750, 950}, "🟧");
        TitleDeedCard tennesseeAvenue = new PropertyTitleDeedCard(90, new int[]{12, 28, 70, 200, 550, 750, 950}, "🟧");
        TitleDeedCard newYorkAvenue = new PropertyTitleDeedCard(100, new int[]{16, 32, 80, 220, 600, 800, 1000}, "🟧");
        TitleDeedCard kentuckyAvenue = new PropertyTitleDeedCard(110, new int[]{18, 36, 90, 250, 700, 875, 1050}, "🟥");
        TitleDeedCard indianaAvenue = new PropertyTitleDeedCard(110, new int[]{18, 36, 90, 250, 700, 875, 1050}, "🟥");
        TitleDeedCard illinoisAvenue = new PropertyTitleDeedCard(120, new int[]{20, 40, 100, 300, 750, 975, 1100}, "🟥");
        TitleDeedCard atlanticAvenue = new PropertyTitleDeedCard(130, new int[]{22, 44, 110, 330, 800, 975, 1150}, "🟨");
        TitleDeedCard ventnorAvenue = new PropertyTitleDeedCard(130, new int[]{22, 44, 110, 330, 800, 975, 1150}, "🟨");
        TitleDeedCard marvinGardens = new PropertyTitleDeedCard(140, new int[]{24, 48, 120, 350, 850, 1025, 1200}, "🟨");
        TitleDeedCard pacificAvenue = new PropertyTitleDeedCard(150, new int[]{26, 52, 130, 390, 900, 1100, 1275}, "🟩");
        TitleDeedCard northCarolinaAvenue = new PropertyTitleDeedCard(150, new int[]{26, 52, 130, 390, 900, 1100, 1275}, "🟩");
        TitleDeedCard pennsylvaniaAvenue = new PropertyTitleDeedCard(160, new int[]{28, 56, 150, 450, 1000, 1200, 1400}, "🟩");
        TitleDeedCard parkPlace = new PropertyTitleDeedCard(180, new int[]{35, 70, 175, 500, 1100, 1300, 1500}, "🟦");
        TitleDeedCard boardwalk = new PropertyTitleDeedCard(200, new int[]{50, 100, 200, 600, 1400, 1700, 2000}, "🟦");
        TitleDeedCard readingRailroad = new RailroadTitleDeedCard(100, "🔳");
        TitleDeedCard pennsylvaniaRailroad = new RailroadTitleDeedCard(100, "🔳");
        TitleDeedCard bAndORailroad = new RailroadTitleDeedCard(100, "🔳");
        TitleDeedCard shortLine = new RailroadTitleDeedCard(100, "🔳");
        TitleDeedCard electricCompany = new UtilityTitleDeedCard(80, "✳️");
        TitleDeedCard waterWorks = new UtilityTitleDeedCard(80, "✳️");
        titleDeeds = new TitleDeedCard[]{mediterraneanAvenue, balticAvenue, readingRailroad, orientalAvenue, vermontAvenue, connecticutAvenue,
                                         stCharlesPlace, electricCompany, statesAvenue, virginiaAvenue, pennsylvaniaRailroad, stJamesPlace, tennesseeAvenue, newYorkAvenue,
                                         kentuckyAvenue, indianaAvenue, illinoisAvenue, bAndORailroad, atlanticAvenue, ventnorAvenue, waterWorks, marvinGardens,
                                         pacificAvenue, northCarolinaAvenue, pennsylvaniaAvenue, shortLine, parkPlace, boardwalk};

    }

    private void updateBoardSpaces() {
        int startX = 43;
        int startY = 43;
        for (int i = 0; i < 40; i++) {
            int side = i / 10;
            if (side == 1 && i % 10 != 0) {
                placeOnBoard(turnSpaceClockwise(boardSpaces[i].getLayout()), startX, startY);
            } else if (side == 2 && i % 10 != 0) {
                placeOnBoard(flipSpace(boardSpaces[i].getLayout()), startX, startY);
            } else if (side == 3 && i % 10 != 0) {
                placeOnBoard(turnSpaceCounterClockwise(boardSpaces[i].getLayout()), startX, startY);
            } else {
                placeOnBoard(boardSpaces[i].getLayout(), startX, startY);
            }
            int offset;
            if ((i + 1) % 10 == 0) {
                offset = 7;
            } else {
                offset = 4;
            }
            if (i / 20 == 1 && (i + 1) % 10 == 1) {
                offset += 3;
            }
            if (i / 20 == 1 && (i + 1) % 10 == 0) {
                offset -= 3;
            }
            if (side == 0) {
                startX -= offset;
            } else if (side == 1) {
                startY -= offset;
            } else if (side == 2) {
                startX += offset;
            } else {
                startY += offset;
            }
        }
    }

    public void createBoardSpaces() {
        String[] boardSpaceNames = {"Mediterranean Avenue", "Baltic Avenue", "Reading Railroad", "Oriental Avenue", "Vermont Avenue", "Connecticut Avenue",
                                    "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St. James Place", "Tennessee Avenue", "New York Avenue",
                                    "Kentucky Avenue", "Indiana Avenue", "Illinois Avenue", "B&O Railroad", "Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens",
                                    "Pacific Avenue", "North Carolina Avenue", "Pennsylvania Avenue", "Short Line", "Park Place", "Boardwalk"};
        int startX = 43;
        int startY = 43;
        int propertyBoardSpaceIndex = 0;
        for (int i = 0; i < 40; i++) {
            BoardSpace boardSpace;
            int side = i / 10;
            if (i % 10 == 0) {
                if (side == 0) {
                    boardSpace = new GoBoardSpace("Go!");
                } else if (side == 1) {
                    boardSpace = new JailBoardSpace("Jail");
                } else if (side == 2) {
                    boardSpace = new FreeParkingBoardSpace("Free Parking");
                } else {
                    boardSpace = new GoToJailBoardSpace("Go to Jail!");
                }
            } else if (i == 4) {
                boardSpace = new TaxBoardSpace("Income Tax", true);
            } else if (i == 38) {
                boardSpace = new TaxBoardSpace("Luxury Tax", false);
            } else if (i == 2 || i == 17 || i == 33) {
                boardSpace = new CardBoardSpace("Community Chest", false);
            } else if (i == 7 || i == 22 || i == 36) {
                boardSpace = new CardBoardSpace("Chance", true);
            } else {
                boardSpace = new PropertyBoardSpace(boardSpaceNames[propertyBoardSpaceIndex], titleDeeds[propertyBoardSpaceIndex], titleDeeds[propertyBoardSpaceIndex].getColor());
                propertyBoardSpaceIndex++;
            }
            boardSpaces[i] = boardSpace;
            if (side == 1 && i % 10 != 0) {
                placeOnBoard(turnSpaceClockwise(boardSpaces[i].getLayout()), startX, startY);
            } else if (side == 2 && i % 10 != 0) {
                placeOnBoard(flipSpace(boardSpaces[i].getLayout()), startX, startY);
            } else if (side == 3 && i % 10 != 0) {
                placeOnBoard(turnSpaceCounterClockwise(boardSpaces[i].getLayout()), startX, startY);
            } else {
                placeOnBoard(boardSpaces[i].getLayout(), startX, startY);
            }
            int offset;
            if ((i + 1) % 10 == 0) {
                offset = 7;
            } else {
                offset = 4;
            }
            if (i / 20 == 1 && (i + 1) % 10 == 1) {
                offset += 3;
            }
            if (i / 20 == 1 && (i + 1) % 10 == 0) {
                offset -= 3;
            }
            if (side == 0) {
                startX -= offset;
            } else if (side == 1) {
                startY -= offset;
            } else if (side == 2) {
                startX += offset;
            } else {
                startY += offset;
            }
        }
    }

    public void board() {
        System.out.println("🛑🛣️🛣️🛣️🛣️🛑⬛⬜⬜⬜⬛🟧⬜🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟥🟦🟦🟦🟦🟦");
        System.out.println("🌇🚥⬜⬜🚥🌆⬛⬜⬜⬜⬛⬜🟧⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟥🚔🚓🚔🚓🟥");
        System.out.println("🌇⬜⬜⬜⬜🌆⬛⬜⬜⬜⬛🟧🟧⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟥🚓⬜⬜🚔🟥");
        System.out.println("🌇⬜⬜⬜⬜🌆⬛⬜⬜⬜⬛🟧⬜🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟥🚔⬜⬜🚓🟥");
        System.out.println("🌇🚥⬜⬜🚥🌆⬛🟥🟥🟥⬛🟧🟧🟧⬛🟥🟥🟥⬛🟥🟥🟥⬛🔳🔳🔳⬛🟨🟨🟨⬛🟨🟨🟨⬛✳️✳️✳️⬛🟨🟨🟨⬛🟥🚓🚔🚓🚔🟥");
        System.out.println("🛑🌃🌃🌃🌃🛑⬛🟥🟥🟥⬛🟧⬜🟧⬛🟥🟥🟥⬛🟥🟥🟥⬛🔳🔳🔳⬛🟨🟨🟨⬛🟨🟨🟨⬛✳️✳️✳️⬛🟨🟨🟨⬛🟦🟦🟦🟦🟦🟥");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛🟥⬜🟥🟥🟥⬜🟥🟥⬜⬜⬜🟥🟥⬜🟥🟥🟥⬜🟥⬜⬜⬜⬜⬜🟥⬜🟥🟥🟥⬜🟥⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛🟥⬜⬜🟥⬜⬜🟥⬜🟥🟥🟥⬜🟥⬜⬜🟥🟥⬜🟥⬜🟥🟥🟥🟥🟥🟥⬜🟥⬜🟥🟥⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛🟥⬜🟥⬜🟥⬜🟥⬜🟥🟥🟥⬜🟥⬜🟥⬜🟥⬜🟥⬜⬜⬜🟥🟥🟥🟥🟥⬜🟥🟥🟥⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛🟥⬜🟥🟥🟥⬜🟥⬜🟥🟥🟥⬜🟥⬜🟥🟥⬜⬜🟥⬜🟥🟥🟥🟥🟥🟥🟥⬜🟥🟥🟥⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛🟥⬜🟥🟥🟥⬜🟥🟥⬜⬜⬜🟥🟥⬜🟥🟥🟥⬜🟥⬜⬜⬜⬜⬜🟥🟥🟥⬜🟥🟥🟥⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("🟦🟦🟦🟦🟦⬜⬛⬛⬛🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥⬛⬛⬛🟦🟦🟦🟦🟦⬜");
        System.out.println("⬜🟦⬜🟦⬜🟦⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬜🟦⬜🟦⬜🟦");
        System.out.println("⬜⬜⬜⬜⬜🟦⬛⬛⬛⬛🟥⬛🟥⬛⬛⬜⬜⬜⬛🟥⬛⬜⬛⬜⬜⬜⬛⬜🟥⬜⬛⬜⬜⬜⬛⬜⬛⬜⬛⬜⬛⬛⬛⬜⬜⬜⬜⬜🟦");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛⬜⬛🟥⬛⬜⬛⬜⬛⬜⬛⬜🟥⬜⬛⬜⬛⬜⬛🟥⬜🟥⬛⬜⬛⬜⬛🟥⬛⬛⬜⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛⬛⬜⬛⬛⬛⬜⬛⬜⬜⬜⬛⬜⬛🟥⬛⬜⬜⬜⬛🟥⬛⬛⬛⬜⬜⬜⬛⬜🟥⬛⬜⬛⬛⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟧🟧⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛⬛🟨🟥🟥🟥🟥🟥🟥🟥🟨⬛⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛🟩🟩⬜⬜⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛🟨⬜⬛⬜⬜⬜⬛⬜🟨⬛⬛⬛🟨🟥🟥⬛⬛⬛🟥🟥🟨⬛⬛⬛🟨⬜⬜⬜⬜⬜⬛⬜🟨⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🔳🔳⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛⬛🟨🟥🟥⬛⬛⬛🟥🟥🟨⬛⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛🔳🔳⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🔳🔳⬛⬛🟨⬜⬛⬜⬜⬜⬛⬜🟨⬛⬛⬛🟨🟥🟥⬛⬛⬛🟥🟥🟨⬛⬛⬛🟨⬜⬜⬜⬛⬜⬜⬜🟨⬛⬛🔳🔳⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🔳🔳⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛⬛🟨🟥🟥⬛⬛⬛🟥🟥🟨⬛⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛🔳🔳⬜⬜⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛🟨⬜⬛⬜⬜⬜⬛⬜🟨⬛⬛⬛🟨🟥⬛⬛⬛⬛⬛🟥🟨⬛⬛⬛🟨⬜⬛⬜⬜⬜⬜⬜🟨⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛⬛🟨🟥🟥🟥🟥🟥🟥🟥🟨⬛⬛⬛🟨⬜⬜⬜⬜⬜⬜⬜🟨⬛⬛🟧⬜⬜🟧🟧🟧");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛⬜🟧🟧⬜🟧⬜");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛⬛🟥⬛⬜🟥⬛🟥🟥🟥⬛⬛⬛⬜⬛🟥🟥🟥⬛⬜⬛🟥⬛🟥🟥🟥⬛🟥⬛⬛⬛🟥⬛⬛⬛🟧⬜🟧🟧🟧🟧");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟥⬛⬛⬜⬛🟥⬛🟥⬛⬜🟥⬜⬛🟥⬛🟥⬛🟥⬜🟥⬛🟥⬛🟥⬛🟥⬛⬜⬛🟥⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛🟥⬛🟥⬛🟥⬛🟥🟥🟥⬛🟥⬜🟥⬛🟥🟥🟥⬛🟥⬛⬜⬛🟥🟥🟥⬛⬛⬜⬛⬜⬛⬛⬛⬛🟦🟦⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟦🟦⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛🟦🟦⬜⬜⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛⬜🟧🟧🟧🟧🟧🟧🟧🟧🟧⬜🟧🟧🟧⬜⬛⬜🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜✳️✳️⬛⬛⬛⬜🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧⬜🟧🟧⬜⬛⬜🟦🟦🟦🟦🟦⬜⬜🟦🟦🟦🟦⬜🟦⬜⬛⬛⬛⬜⬜⬜🟨⬜⬜");
        System.out.println("⬜⬜⬜⬜✳️✳️⬛⬛⬛⬜🟧⬜🟧⬜⬜⬜⬜🟧🟧🟧🟧⬜🟧⬜⬛⬜🟦🟦⬜🟦⬜⬜⬜⬜🟦🟦⬜🟦🟦⬜⬛⬛⬛⬜💠🟨⬜🟨⬜");
        System.out.println("⬜⬜⬜⬜✳️✳️⬛⬛⬛⬜🟧🟧🟧🟧🟧🟧🟧⬜🟧🟧⬜🟧🟧⬜⬛⬜🟦🟦⬜🟦⬜⬜⬜⬜🟦🟦⬜🟦🟦⬜⬛⬛⬛⬜⬜⬜🟨⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛⬜🟧🟧🟧🟧🟧🟧🟧🟧⬜⬜🟧🟧🟧⬜⬛⬜🟦🟦⬜⬜⬜⬜⬜⬜⬜⬜⬜🟦🟦⬜⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛🟦🟦⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟦🟦⬜⬜⬜⬜");
        System.out.println("⬜⬜⬜⬜🟪🟪⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟦🟦⬜⬜⬜⬜");
        System.out.println("⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        System.out.println("⬜⬜⛔🟧🟧🟧⬛⏹️⏹️⏹️⬛⏹️⏹️⏹️⬛🟧⬜🟧⬛⏹️⏹️⏹️⬛🔳🔳🔳⬛⬜⬜⬜⬛🟫🟫🟫⬛⬜🟦🟦⬛🟫🟫🟫⬛⬜⬜⬜🚥🟥🚥");
        System.out.println("⬜⬜⛔🟧👺🟧⬛⏹️⏹️⏹️⬛⏹️⏹️⏹️⬛⬜🟧⬜⬛⏹️⏹️⏹️⬛🔳🔳🔳⬛⬜♦️⬜⬛🟫🟫🟫⬛🟦⬜⬜⬛🟫🟫🟫⬛⬜⬜⬜⬜🟥⬜");
        System.out.println("⬜⬜⛔🟧🟧🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧🟧⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜🏛️⬜⬛⬜⬜⬜⬛🟦🟦⬜⬛⬜⬜⬜⬛⬜⬜⬜⬜🟥⬜");
        System.out.println("⬜⬜⛔⛔⛔⛔⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧⬜🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛🏛️⬜🏛️⬛⬜⬜⬜⬛🟦⬜⬜⬛⬜⬜⬜⬛🚥🟥⬜⬜🟥⬜");
        System.out.println("⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧🟧🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜🏛️⬜⬛⬜⬜⬜⬛🟦🟦⬜⬛⬜⬜⬜⬛🟥🟥🟥🟥🟥⬜");
        System.out.println("⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧⬜🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟦⬜⬜⬛⬜⬜⬜⬛🚥🟥⬜⬜⬜⬜");
    }

    private void placeOnBoard(String[][] boardPlacer, int startX, int startY) {
        int restartX = boardPlacer[0].length;
        for (String[] strings : boardPlacer) {
            for (String string : strings) {
                board[startY][startX] = string;
                startX++;
            }
            startX -= restartX;
            startY++;
        }
    }

    private String[][] turnSpaceCounterClockwise(String[][] space) {   //will turn counterclockwise sort of like when turning a line around a circle in mathematics to determine radians
        int x = space[0].length;
        int y = space.length;
        String[][] newSpace = new String[x][y];
        for (int i = 0, k = 0; i < y; i++, k++) {
            for (int j = 0, l = x - 1; j < x; j++, l--) {
                newSpace[j][i] = space[k][l];
            }
        }
        space = newSpace;
        return space;
    }

    private String[][] flipSpace(String[][] space) {
        for (int i = 0; i < 2; i++) {
            space = turnSpaceCounterClockwise(space);
        }
        return space;
    }

    private String[][] turnSpaceClockwise(String[][] space) {
        for (int i = 0; i < 3; i++) {
            space = turnSpaceCounterClockwise(space);
        }
        return space;
    }

}
