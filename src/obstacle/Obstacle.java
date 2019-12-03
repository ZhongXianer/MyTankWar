package obstacle;

import java.awt.*;

public abstract class Obstacle {
    /*
    所有障碍物的父类,障碍物的性质包括：
       坐标x,y
       是否能被子弹摧毁
       子弹攻打几次可以被摧毁
     */
    private int x;
    private int y;

    private boolean canBeDestroyed;   //障碍物是否能被摧毁
    private boolean canThrough;
    private int shootTimes;     //子弹攻打几次可以被摧毁

    public Obstacle(boolean canBeDestroyed,boolean canThrough,int shootTimes){
        this.canBeDestroyed=canBeDestroyed;
        this.canThrough=canThrough;
        this.shootTimes=shootTimes;
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

    public void setY(int y) {
        this.y = y;
    }



    public int getShootTimes() {
        return shootTimes;
    }

    public void setShootTimes(int shootTimes) {
        this.shootTimes = shootTimes;
    }

    public boolean isCanBeDestroyed() {
        return canBeDestroyed;
    }

    public void setCanBeDestroyed(boolean canBeDestroyed) {
        this.canBeDestroyed = canBeDestroyed;
    }

    public boolean isCanThrough() {
        return canThrough;
    }

    public void setCanThrough(boolean canThrough) {
        this.canThrough = canThrough;
    }

    public abstract void draw(Graphics graphics);
}
