import java.util.ArrayList;
import java.util.Scanner;

public class MonopolyLogic {

    String[][] board;
    BoardSpace[] boardSpaces;
    TitleDeedCard[] titleDeeds;
    ArrayList<MonopolyPlayer> turnOrder;
    Scanner scan;

    public MonopolyLogic() {
        board = createBoard();
        boardSpaces = new BoardSpace[40];
        turnOrder = new ArrayList<>();
        scan = new Scanner(System.in);
        placeOnBoard(MonopolyDecorations.moneySign, 9, 9);
        placeOnBoard(MonopolyDecorations.monopolySign, 9, 17);
        placeOnBoard(flipSpace(MonopolyDecorations.monopolyInvertedSign), 9, 29);
        placeOnBoard(MonopolyDecorations.chanceAndCommunityChest, 9, 33);
        createPropertyTitleDeeds();
        createBoardSpaces();
    }

    public void run() {
        board();
        System.out.println();
        printBoard();
        initializePlayers();

    }

    public void initializePlayers() {
        ConsoleUtility.clearScreen();
        System.out.print("How many players would like to play? ");
        int numPlayers = scan.nextInt();
        scan.nextLine();
        System.out.println(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            printBoard();
            System.out.print("What name would this player like to have? ");
            String name = scan.nextLine();
            System.out.println();
            System.out.print("What token would this player like to have? (can be any character but an emoji is recommended) ");
            String token = scan.nextLine();
            System.out.println();
            token = token.substring(0, 1);
            MonopolyPlayer player = new MonopolyPlayer(name, token);
            turnOrder.add(player);
            ConsoleUtility.clearScreen();
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
                if (side == 1) {
                    placeOnBoard(turnSpaceClockwise(boardSpaces[i].getLayout()), startX, startY);
                } else if (side == 2) {
                    placeOnBoard(flipSpace(boardSpaces[i].getLayout()), startX, startY);
                } else if (side == 3) {
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
            } else if (side == 3) {
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
