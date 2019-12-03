package obstacle;

import java.awt.*;

public class WallCannotBeDestroyed extends Obstacle {
    public WallCannotBeDestroyed(int x,int y){
        super(false,false,-1);
        this.setX(x);
        this.setY(y);
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.gray);
        graphics.fillRect(this.getX(),this.getY(),50,50);
    }
}
