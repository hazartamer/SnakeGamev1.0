import java.util.Random;

public class Board {
    private Random random = new Random();
    private Coordinate target;
    private Snake snake;
    private String[][] boardMatrix;
    private int boardLength;
    public Board(int boardLength, Snake snake) {
        this.boardMatrix = new String[boardLength][boardLength];
        this.boardLength = boardLength;
        this.snake = snake;
        generateRandomTarget();
        initializeBoardMatrix();
    }
    public void initializeBoardMatrix(){
        for(int i =0;i<boardMatrix.length;i++){
            for(int j =0;j<boardMatrix[i].length;j++){
                if(snake.doesCoordinateExist(i, j)) {
                    boardMatrix[i][j] = "*";
                    continue;
                }
                if (doesTargetExist(i, j)) {
                    boardMatrix[i][j] = "x";
                    continue;
                }
                boardMatrix[i][j] = "-";
            }
        }
    }
    public void printBoard(){
        System.out.println("#".repeat(boardLength * 4 + 1));
        for(int i =0;i<boardMatrix.length;i++) {
            System.out.print("#");
            for (int j = 0; j < boardMatrix[i].length; j++) {
                System.out.print(" ");
                System.out.print(boardMatrix[i][j]);
                System.out.print(" ");
                System.out.print("#");
            }
            System.out.println();
            System.out.println("#".repeat(boardLength * 4 + 1));
        }
    }


    public void generateRandomTarget(){
        while(true){
            int x = random.nextInt(0,boardLength);
            int y = random.nextInt(0,boardLength);
            if(!snake.doesCoordinateExist(x,y)){
                this.target=new Coordinate(x,y);
                return;
            }
        }

    }
    public boolean doesTargetExist(int x,int y){
        return target.isEqual(x, y);
    }
    public boolean doesCoordinateCrossTheBorder(Coordinate coordinate){
        return coordinate.getX() > boardLength
                || coordinate.getX() < -1
                || coordinate.getY() > boardLength
                || coordinate.getY() < -1;
    }

}
