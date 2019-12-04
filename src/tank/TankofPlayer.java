package tank;

import Tool.DrawTool;
import obstacle.Obstacle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TankofPlayer extends Tank {
    /*
    玩家坦克类，继承自抽象类Tank
     */
    public TankofPlayer(int x,int y){
        this.setX(x);
        this.setY(y);
        this.setDirection(Direction.STOP);
    }

    @Override
    public void move() {
    }
    public void move(KeyEvent keyEvent,Graphics graphics,ArrayList<Obstacle> obstacles){
        /*获得键盘点击事件并改变坦克的运动方向*/
        if(getKeyEvent(keyEvent,graphics)==0 && !judgeObstacle(obstacles))
            moveAccordingToDirection(graphics);

        /*根据坦克的方向判断前面是否有障碍物*/

        /*根据当前坦克的方向改变坐标*/
        /*根据改变后的坐标画出新坦克的位置*/
        draw(graphics);
    }

    public boolean judgeObstacle(ArrayList<Obstacle> obstacles){
        int tempx=this.getX();
        int tempy=this.getY();
        switch (this.getDirection()){
            case STOP:
                return false;
            case UP:
                tempy-=50;
                break;
            case DOWN:
                tempy+=50;
                break;
            case LEFT:
                tempx-=50;
                break;
            case RIGHT:
                tempx+=50;
                break;
                default:
        }
        for (Obstacle o:obstacles){
            if(tempx==o.getX()&&tempy==o.getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void shoot() {
        //根据从键盘获得的点击事件发射子弹
    }

    private void moveAccordingToDirection(Graphics graphics){
        this.drawbBlack(graphics);
        //画图时上下相反
        switch (this.getDirection()){
            case STOP:
                break;
            case UP:
                this.setY(this.getY()-50);
                break;
            case DOWN:
                this.setY(this.getY()+50);
                break;
            case LEFT:
                this.setX(this.getX()-50);
                break;
            case RIGHT:
                this.setX(this.getX()+50);
                break;
                default:
        }
    }

    private int getKeyEvent(KeyEvent keyEvent,Graphics graphics){
        Direction directionBefore=this.getDirection();
        Direction directionNext;
        switch (keyEvent.getKeyChar()){
            case 'w':
                directionNext=Direction.UP;
                break;
            case 's':
                directionNext=Direction.DOWN;
                break;
            case 'a':
                directionNext=Direction.LEFT;
                break;
            case 'd':
                directionNext=Direction.RIGHT;
                break;
                default:
                    directionNext=directionBefore;
                    return 1;
        }
        if (directionNext!=directionBefore){
            this.setDirection(directionNext);
            draw(graphics);
            return 1;
        }
        return 0;

    }

    @Override
    public void draw(Graphics graphics) {
        switch (this.getDirection()){
            case STOP:
                DrawTool.drawImage("tankright",this.getX(),this.getY(),graphics);
                break;
            case UP:
                DrawTool.drawImage("tankup",this.getX(),this.getY(),graphics);
                break;
            case DOWN:
                DrawTool.drawImage("tankdown",this.getX(),this.getY(),graphics);
                break;
            case LEFT:
                DrawTool.drawImage("tankleft",this.getX(),this.getY(),graphics);
                break;
            case RIGHT:
                DrawTool.drawImage("tankright",this.getX(),this.getY(),graphics);
                break;
        }
    }

    public void drawbBlack(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillRect(this.getX(),this.getY(),50,50);
    }

}
