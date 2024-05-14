public enum Direction {

    RIGHT("R", new Coordinate(0, 1)),
    DOWN("D", new Coordinate(1, 0)),
    LEFT("L", new Coordinate(0, -1)),
    UP("U", new Coordinate(-1, 0));

    private String input;
    private Coordinate coordinateEffect;

    Direction(String input, Coordinate coordinateEffect) {
        this.input = input;
        this.coordinateEffect = coordinateEffect;
    }

    public String getInput() {
        return input;
    }

    public Coordinate getCoordinateEffect() {
        return coordinateEffect;
    }

    public static Direction findByInput(String input){
        for(Direction v : Direction.values()){
            if( v.getInput().equals(input)){
                return v;
            }
        }
        return null;
    }

    public boolean isReverseDirection(Direction direction){
        switch (this){
            case RIGHT -> {
                return direction.equals(Direction.LEFT);
            }
            case DOWN -> {
                return direction.equals(Direction.UP);
            }
            case LEFT -> {
                return direction.equals(Direction.RIGHT);
            }
            case UP -> {
                return direction.equals(Direction.DOWN);
            }
        }
        return false;
    }
}
