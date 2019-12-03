package obstacle;

import java.awt.*;

public class WallCanBeDestroyed extends Obstacle {

    public WallCanBeDestroyed(int x,int y){
        super(true,false,1);
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(this.getX(),this.getY(),50,50);
    }
}
