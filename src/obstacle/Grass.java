package obstacle;

import Tool.DrawTool;

import java.awt.*;

public class Grass extends Obstacle {

    public Grass(int x,int y){
        super(false,true,-1);
        this.setX(x);
        this.setY(y);
    }


    @Override
    public void draw(Graphics graphics) {
        DrawTool.drawImage("grass",this.getX(),this.getY(),graphics);
    }
}
