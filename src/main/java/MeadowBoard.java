import lombok.Getter;

import java.util.Random;

public class MeadowBoard {

    @Getter private BoardMovement[][] meadow;
    private final String meadowEmoji;
    @Getter private final int xSize;
    @Getter private final int ySize;
    private final Random random;

    public MeadowBoard(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        this.meadow = new BoardMovement[xSize][ySize];
        this.meadowEmoji = "\uD83D\uDFE9";
        this.random = new Random();
    }

    public boolean isFieldEmpty(int x, int y){
        return this.meadow[x][y] == null;
    }


    public void printBoard(){
        for (int iX = 0; iX < xSize; iX++){
            for (int iY = 0; iY < ySize; iY++){

                if (this.isFieldEmpty(iX, iY)){
                    System.out.print(this.meadowEmoji);
                } else {
                    System.out.print(this.getMeadow()[iX][iY].getEmoji());
                }

            }
            System.out.println("");
        }
    }

    private int getRandomIntBetween(int from, int to){
        return this.random.nextInt(to) + from;
    }

    private int getRandomVector(){
        return this.getRandomIntBetween(-1, 2);
    }

    private void move(int xFrom, int yFrom, int xTo, int yTo){
        BoardMovement object = this.getMeadow()[xFrom][yFrom];
        this.getMeadow()[xFrom][yFrom] = null;
        this.getMeadow()[xTo][yTo] = object;
    }

    private int reverseVectorIfExceedBoardSize(int vector, int oldPosition, String dimension){
        if (dimension.equalsIgnoreCase("x")){
            return vector + oldPosition < 0 || vector + oldPosition  >= this.xSize ? -vector : vector;
        } else if (dimension.equalsIgnoreCase("y")){
            return vector + oldPosition  < 0 || vector + oldPosition  >= this.ySize ? -vector : vector;
        } else {
            throw new IllegalArgumentException("Board have only two dimensions X and Y");
        }
    }

    private void makeTurn(int iX, int iY){

        int xVector;
        int yVector;
        while (true){
            xVector = this.reverseVectorIfExceedBoardSize(getRandomVector(), iX, "x");
            yVector = this.reverseVectorIfExceedBoardSize(getRandomVector(), iY, "y");
            if (xVector == yVector && xVector == 0){
                continue;
            }
            break;
        }

        int xNew = iX + xVector;
        int yNew = iY + yVector;
        BoardMovement thisBoardCharacter = this.getMeadow()[iX][iY];

        if (isFieldEmpty(xNew, yNew)){

            BoardMovement possibleReproduction = thisBoardCharacter.makeMovementAction();
            // if not deceased and does not reproducing then move
            // if not deceased and reproducing, create new board character on move position and resign from moving
            // if deceased then delete and do nothing more
            if (thisBoardCharacter.didDeceased()){
                this.eraseFromPosition(iX, iY);
            } else {
                if (possibleReproduction != null){
                    this.placeOnPosition(possibleReproduction, xNew, yNew);
                } else {
                    if (thisBoardCharacter.canMove()){
                        this.move(iX, iY, xNew, yNew);
                    }
                }
            }


        } else {

            BoardMovement interacted = this.getMeadow()[xNew][yNew];
            BoardMovement possibleReproduction = thisBoardCharacter.makeInteraction(interacted);
            if (interacted.didDeceased()){
                this.eraseFromPosition(xNew, yNew);
                if (possibleReproduction != null){
                    this.placeOnPosition(possibleReproduction, xNew, yNew);
                }
            } else if (possibleReproduction != null){
                this.placeOnAnySurroundingEmptyPosition(possibleReproduction, iX, iY);
            }

        }
    }

    public void makeTurnForWholeEcosystem(){
        for (int iX = 0; iX < xSize; iX++){
            for (int iY = 0; iY < ySize; iY++){

                if (!this.isFieldEmpty(iX, iY)){
                    this.makeTurn(iX, iY);
                }

            }
        }
    }

    public void placeOnPosition(BoardMovement objectToBePlaced, int iX, int iY){
        this.getMeadow()[iX][iY] = objectToBePlaced;
    }

    private void placeOnAnySurroundingEmptyPosition(BoardMovement objectToBePlaced, int iX, int iY){
        int[] possibleX = new int[]{iX-1, iX-1, iX-1, iX, iX, iX+1, iX+1, iX+1};
        int[] possibleY = new int[]{iY-1, iY, iY+1, iY-1, iY+1, iY-1, iY, iY+1};
        for (int i = 0; i < 8; i++){
            int x = possibleX[i];
            int y = possibleY[i];
            if (isFieldEmpty(x, y)){
                this.placeOnPosition(objectToBePlaced, x, y);
                break;
            }
        }
    }

    private void eraseFromPosition(int iX, int iY){
        this.getMeadow()[iX][iY] = null;
    }
}
