package obstacle;

import java.awt.*;

public class Grass extends Obstacle {

    public Grass(int x,int y){
        super(false,true,-1);
        this.setX(x);
        this.setY(y);
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(this.getX(),this.getY(),50,50);
    }
}
