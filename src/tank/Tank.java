package tank;

import java.awt.*;

public abstract class Tank {
    /*
    所有坦克的父类，定义为抽象类:
       成员变量：坐标x,y
               运动方向direction
       成员方法：基本的setter getter
               移动
               发射子弹
     */
    private int x;
    private int y;
    private Direction direction;


    public abstract void move();
    public abstract void shoot();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public abstract void draw(Graphics graphics);

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
