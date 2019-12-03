package tank;

import java.awt.*;

public class TankofEnemy extends Tank {
    /*
    敌方坦克类，运动方向与攻击方向一致
     */
    @Override
    public void move() {
        //自动寻路，攻打我方基地
    }

    @Override
    public void shoot() {
        //一定事件间隔发射子弹
    }

    @Override
    public void draw(Graphics graphics) {

    }
}
