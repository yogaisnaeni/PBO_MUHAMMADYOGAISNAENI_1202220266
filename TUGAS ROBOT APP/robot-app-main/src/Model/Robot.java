package Model;

public class Robot {
    private char icon;
    private Position position;

    public Robot(char icon, Position position) {
        this.icon = icon;
        this.position = position;
    }

    public char getIcon() {
        return icon;
    }

    public Position getPosition() {
        return position;
    }

    public void moveRight(int steps) {
        position.setX(position.getX() + steps);
    }

    public void moveLeft(int steps) {
        position.setX(position.getX() - steps);
    }

    public void moveUp(int steps) {
        position.setY(position.getY() - steps);
    }

    public void moveDown(int steps) {
        position.setY(position.getY() + steps);
    }
}
