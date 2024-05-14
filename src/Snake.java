import java.util.ArrayList;

public class Snake {
    private Direction direction = ConfigurationConstants.SNAKE_START_DIRECTION;
    private ArrayList<Coordinate> coordinates = new ArrayList<>();

    public Snake() {
       //coordinates = new ArrayList<>(List.of(game.ConfigurationConstants.SNAKE_START_COORDINATE));
        coordinates.add(ConfigurationConstants.SNAKE_START_COORDINATE);
    }
    public void move(boolean growUp){
        Coordinate nextMovement = getNextMovement();
        if(!growUp){
            removeSnakeTail();
        }
        addSnakeHead(nextMovement);
    }

    public Coordinate getNextMovement(){
        Coordinate nextMovement = new Coordinate(getSnakeHead());
//        switch (direction){
//            case RIGHT ->  nextMovement.addY(1);//sağ
//            case DOWN -> nextMovement.addX(1);//aşağı
//            case LEFT -> nextMovement.addY(-1);//sol
//            case UP ->  nextMovement.addX(-1);//yukarı
//        }
        nextMovement.addX(direction.getCoordinateEffect().getX());
        nextMovement.addY(direction.getCoordinateEffect().getY());
        return nextMovement;
    }

    public Coordinate getSnakeHead(){
        return coordinates.get(coordinates.size() - 1);
    }
    public void removeSnakeTail(){
         coordinates.remove(0);
    }
    public void addSnakeHead(Coordinate newCoordinate){
        coordinates.add(newCoordinate);
    }
    public boolean doesCoordinateExist(int x, int y){
        for(int i = 0;i<coordinates.size();i++){
            if(coordinates.get(i).isEqual(x, y)){
                return true;
            }
        }
        return false;
    }

    public boolean isReverseDirection(Direction newDirection){
        return this.direction.isReverseDirection(newDirection);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
