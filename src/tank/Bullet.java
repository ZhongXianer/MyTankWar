package tank;

import Tool.DirectionTool;
import Tool.DrawTool;
import Tool.IntTool;
import obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;

public class Bullet {
    private int x;
    private int y;
    private Direction direction;

    public Bullet(int x, int y,Direction direction){
        this.x=x;
        this.y=y;
        this.direction=direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics graphics)
    {
        DrawTool.drawImage("bullet",this.x,this.y,graphics);
    }

    public void move(ArrayList<Obstacle> obstacles,Graphics graphics){
        while (!judgeObstacle(obstacles,graphics)&&!judgeBroader()){
            DrawTool.drawBlack(graphics,this.x,this.y);
            changeAccordDirection(graphics);
            draw(graphics);
            try {
                Thread.sleep(30);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        DrawTool.drawBlack(graphics,x,y);
    }
    private Boolean judgeObstacle(ArrayList<Obstacle> obstacles,Graphics graphics){
        IntTool intTool=new IntTool(this.x,this.y);
        DirectionTool.changetempPoint(this.direction,intTool);
        for (Obstacle o:obstacles){
            if (intTool.getX()==o.getX()&&intTool.getY()==o.getY()){
                o.setShootTimes(o.getShootTimes()+1);
                if (o.judgeDestroyed()){
                    o.updateObstacle(graphics);
                    obstacles.remove(o);
                }
                return true;
            }
        }
        return false;
    }
    private Boolean judgeBroader(){
        if (this.x+50==800&&direction==Direction.RIGHT)
            return true;
        if (this.x==0&&direction==Direction.LEFT)
            return true;
        if(this.y==0&&direction==Direction.UP)
            return true;
        if (this.y+50==600&&direction==Direction.DOWN)
            return true;
        return false;
    }
    private void changeAccordDirection(Graphics graphics){
        switch (this.direction){
            case UP:
                this.y-=50;
                break;
            case DOWN:
                this.y+=50;
                break;
            case LEFT:
                this.x-=50;
                break;
            case RIGHT:
                this.x+=50;
                break;
                default:
        }
    }
}
