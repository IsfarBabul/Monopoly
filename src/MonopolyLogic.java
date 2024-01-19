public class MonopolyLogic {

    String[][] board;
    BoardSpace[] boardSpaces;
    TitleDeedCard[] titleDeeds;

    public MonopolyLogic() {
        board = createBoard();
        placeOnBoard(MonopolyDecorations.moneySign, 9, 9);
        placeOnBoard(MonopolyDecorations.monopolySign, 9, 17);
        placeOnBoard(flipSpace(MonopolyDecorations.monopolyInvertedSign), 9, 29);
        placeOnBoard(MonopolyDecorations.chanceAndCommunityChest, 9, 33);
    }

    public void run() {
        board();
        System.out.println();
        printBoard();
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

    }
    public void createBoardSpaces() {

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
        System.out.println("⬜⬜⛔🟧👺🟧⬛⏹️⏹️⏹️⬛⏹️⏹️⏹️⬛⬜🟧⬜⬛⏹️⏹️⏹️⬛🔳🔳🔳⬛⬜🏛️⬜⬛🟫🟫🟫⬛🟦⬜⬜⬛🟫🟫🟫⬛⬜⬜⬜⬜🟥⬜");
        System.out.println("⬜⬜⛔🟧🟧🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧🟧⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🏛️🏢🏛️⬛⬜⬜⬜⬛🟦🟦⬜⬛⬜⬜⬜⬛⬜⬜⬜⬜🟥⬜");
        System.out.println("⬜⬜⛔⛔⛔⛔⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧⬜🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜🏛️⬜⬛⬜⬜⬜⬛🟦⬜⬜⬛⬜⬜⬜⬛🚥🟥⬜⬜🟥⬜");
        System.out.println("⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟧🟧🟧⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛⬜⬜⬜⬛🟦🟦⬜⬛⬜⬜⬜⬛🟥🟥🟥🟥🟥⬜");
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

    public String[][] flipSpace(String[][] space) {
        for (int i = 0; i < 2; i++) {
            space = turnSpaceCounterClockwise(space);
        }
        return space;
    }

    public String[][] turnSpaceClockwise(String[][] space) {
        for (int i = 0; i < 3; i++) {
            space = turnSpaceCounterClockwise(space);
        }
        return space;
    }

}
