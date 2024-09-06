package iteractive_tiles;
import Bomberman2D.GameWindow;
import  Character.Entity;

public class Interactive_Tile extends Entity{
    GameWindow gw;
    public boolean collision = false;
    public boolean destructible = false;
    public Interactive_Tile(GameWindow gw, int col, int row) {
        super(gw);
        this.gw = gw;
    }

    public void update() {

    }
}
