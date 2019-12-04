package tank;

import Tool.DrawTool;

import java.awt.*;

public class Base extends Tank {

    public Base(int x,int y){
        this.setX(x);
        this.setY(y);
    }
    @Override
    public void move() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void draw(Graphics graphics) {
        DrawTool.drawImage("base",this.getX(),this.getY(),graphics);
    }
}
