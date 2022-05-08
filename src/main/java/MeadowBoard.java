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
                    System.out.println(this.getMeadow()[iX][iY].getEmoji());
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

    public void makeTurn(int iX, int iY){
        int xVector = this.reverseVectorIfExceedBoardSize(getRandomVector(), iX, "x");
        int yVector = this.reverseVectorIfExceedBoardSize(getRandomVector(), iY, "y");
        int xNew = iX + xVector;
        int yNew = iY + yVector;
        if (isFieldEmpty(xNew, yNew)){
            this.move(iX, iY, xNew, yNew);
        } else {
            BoardMovement possibleReproduction = this.getMeadow()[iX][iY].makeInteraction(this.getMeadow()[xNew][yNew]);
            if (possibleReproduction != null){
                // placing new
            }
        }
    }
}
