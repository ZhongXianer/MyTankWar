package obstacle;

import Tool.DrawTool;

import java.awt.*;

public class WallCannotBeDestroyed extends Obstacle {
    public WallCannotBeDestroyed(int x,int y){
        super(false,false,-1);
        this.setX(x);
        this.setY(y);
    }


    @Override
    public void draw(Graphics graphics) {
        DrawTool.drawImage("wallCannotBeDestroyed",this.getX(),this.getY(),graphics);
    }
}
