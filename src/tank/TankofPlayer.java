package tank;

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
    public void move(KeyEvent keyEvent,Graphics graphics){
        /*先把当前坦克所在的模块清成背景颜色*/
        drawbBlack(graphics);
        /*获得键盘点击事件并改变坦克的运动方向*/
        getKeyEvent(keyEvent);
        /*根据坦克的方向判断前面是否有障碍物*/

        /*根据当前坦克的方向改变坐标*/
        moveAccordingToDirection();
        /*根据改变后的坐标画出新坦克的位置*/
        draw(graphics);
    }

    public void judgeObstacle(ArrayList<Obstacle> obstacles){
        int tempx=this.getX();
        int tempy=this.getY();
        switch (this.getDirection()){
            case STOP:
                return;
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
                this.setDirection(Direction.STOP);
                break;
            }
        }
    }

    @Override
    public void shoot() {
        //根据从键盘获得的点击事件发射子弹
    }

    private void moveAccordingToDirection(){
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

    private void getKeyEvent(KeyEvent keyEvent){
        switch (keyEvent.getKeyChar()){
            case 'w':
                System.out.println("You clicked w");
                this.setDirection(Direction.UP);
                break;
            case 's':
                System.out.println("You clicked s");
                this.setDirection(Direction.DOWN);
                break;
            case 'a':
                System.out.println("You clicked a");
                this.setDirection(Direction.LEFT);
                break;
            case 'd':
                System.out.println("You clicked d");
                this.setDirection(Direction.RIGHT);
                break;
                default:
                    this.setDirection(Direction.STOP);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(this.getX(),this.getY(),50,50);
    }

    public void drawbBlack(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillRect(this.getX(),this.getY(),50,50);
    }

}
