import java.util.Scanner;

public class GameManager {
    Board board;
    Snake snake;
    boolean isGameOver = false;
    public GameManager() {
        startGame();
        controlGame();
    }

    private void startGame(){
        snake = new Snake();
        this.board = new Board(ConfigurationConstants.INITIAL_BOARD_LENGTH, snake);
    }

    private void controlGame(){
        Scanner scanner = new Scanner(System.in);
        while(!isGameOver){
            board.printBoard();
            System.out.println(ConfigurationConstants.POSSIBLE_MOVEMENT_INPUTS);
            System.out.printf("Current direction: %s%n", snake.getDirection().toString());
            System.out.print("Please make a movement: ");
            String input = scanner.nextLine();
            makeMovementByInput(input);
            checkIsGameOver();

        }
    }

    private void makeMovementByInput(String input){
        if(!input.isEmpty()){
            Direction newDirection = Direction.findByInput(input);
            if(!snake.isReverseDirection(newDirection)){
                snake.setDirection(newDirection);
            }
        }
        Coordinate nextMovement = snake.getNextMovement();
        boolean doesTargetExist = board.doesTargetExist(nextMovement.getX(), nextMovement.getY());
        snake.move(doesTargetExist);
        if(doesTargetExist)
            board.generateRandomTarget();
        board.initializeBoardMatrix();
    }
    private void checkIsGameOver(){
        Coordinate nextMovement =snake.getNextMovement();
        boolean doesCoordinateCrossTheBorder = board.doesCoordinateCrossTheBorder(nextMovement);
        boolean doesHitItSelf = snake.doesCoordinateExist(nextMovement.getX(), nextMovement.getY());
        isGameOver = doesHitItSelf ||doesCoordinateCrossTheBorder;
        if (isGameOver)
            System.out.println("Game Over!");
    }




}
