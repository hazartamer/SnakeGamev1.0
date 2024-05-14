public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate coordinate) {
        this.x = coordinate.x;
        this.y = coordinate.y;
    }

    public void addX(int velocity){
        this.x += velocity;
    }
    public void addY(int velocity){
        this.y += velocity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean isEqual(int x, int y){
        return getX() == x && getY() == y;
    }


}
