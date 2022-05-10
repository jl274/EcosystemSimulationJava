public class DemoSimulation {

    public static void main(String[] args) {

        MeadowBoard meadow = new MeadowBoard(5, 5);
        meadow.printBoard();
        System.out.println();

        BoardMovement[] characters = new BoardMovement[]{
                new Grass(), new Grass(), new Grass(), new Sheep()
        };

//        int x = 0;
        int y = 0;
        for (BoardMovement character : characters){
            meadow.placeOnPosition(character, 0, y++);
        }

        meadow.printBoard();
        System.out.println();

        meadow.makeTurnForWholeEcosystem();

        meadow.printBoard();
    }
}
