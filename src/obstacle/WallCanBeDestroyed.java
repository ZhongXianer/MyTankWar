package obstacle;

import Tool.DrawTool;

import java.awt.*;

public class WallCanBeDestroyed extends Obstacle {

    public WallCanBeDestroyed(int x,int y){
        super(true,false,1);
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void draw(Graphics graphics) {
        DrawTool.drawImage("wallCanBeDestroyed",this.getX(),this.getY(),graphics);
    }
}
