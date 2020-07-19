package unsw.dungeon;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    public void moveUp() {
        Entity e = dungeon.getEntityByPos(getX(), getY() - 1);
        if (e != null && e instanceof Wall) {
            return;
        }
        if (e != null && e instanceof Boulder) {
            Entity f = dungeon.getEntityByPos(getX(), getY() - 2);
            if (f != null && (f instanceof Wall || f instanceof Boulder)) {
                System.out.println("Can't push boulder! Path blocked.");
                return;
            }
            e.y().set(getY() - 2);
            y().set(getY() - 1);
            System.out.println("Boulder pushed up!");
            return;
        }
        if (getY() > 0) {
            y().set(getY() - 1);
        }
        if (e != null && e instanceof Exit) {
            System.out.println("Puzzle Complete! Congratulations!");
            dungeon.removeEntity(e);
        }
    }

    public void moveDown() {
        Entity e = dungeon.getEntityByPos(getX(), getY() + 1);
        if (e != null && e instanceof Wall) {
            return;
        }
        if (e != null && e instanceof Boulder) {
            Entity f = dungeon.getEntityByPos(getX(), getY() + 2);
            if (f != null && (f instanceof Wall || f instanceof Boulder)) {
                System.out.println("Can't push boulder! Path blocked.");
                return;
            }
            e.y().set(getY() + 2);
            y().set(getY() + 1);
            System.out.println("Boulder pushed down!");
            return;
        }
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
        if (e != null && e instanceof Exit) {
            System.out.println("Puzzle Complete! Congratulations!");
            dungeon.removeEntity(e);
        }
    }

    public void moveLeft() {
        Entity e = dungeon.getEntityByPos(getX() - 1, getY());
        if (e != null && e instanceof Wall) {
            return;
        }
        if (e != null && e instanceof Boulder) {
            Entity f = dungeon.getEntityByPos(getX() - 2, getY());
            if (f != null && (f instanceof Wall || f instanceof Boulder)) {
                System.out.println("Can't push boulder! Path blocked.");
                return;
            }
            e.x().set(getX() - 2);
            x().set(getX() - 1);
            System.out.println("Boulder pushed left!");
            return;
        }
        if (getX() > 0)
            x().set(getX() - 1);
        if (e != null && e instanceof Exit) {
            System.out.println("Puzzle Complete! Congratulations!");
            dungeon.removeEntity(e);
        }
    }

    public void moveRight() {
        Entity e = dungeon.getEntityByPos(getX() + 1, getY());
        if (e != null && e instanceof Wall) {
            return;
        }
        if (e != null && e instanceof Boulder) {
            Entity f = dungeon.getEntityByPos(getX() + 2, getY());
            if (f != null && (f instanceof Wall || f instanceof Boulder)) {
                System.out.println("Can't push boulder! Path blocked.");
                return;
            }
            e.x().set(getX() + 2);
            x().set(getX() + 1);
            System.out.println("Boulder pushed right!");
            return;
        }
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
        if (e != null && e instanceof Exit) {
            System.out.println("Puzzle Complete! Congratulations!");
            dungeon.removeEntity(e);
        }
    }
}
