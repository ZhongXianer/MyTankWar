import Tool.DrawTool;
import obstacle.Obstacle;
import obstacle.WallCanBeDestroyed;
import tank.Base;
import tank.TankofEnemy;
import tank.TankofPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    /*
    游戏的主界面包括UI界面以及游戏的基本逻辑
     */
    private ArrayList<Obstacle> obstacles=new ArrayList<>();
    private ArrayList<TankofEnemy> enemyTanks=new ArrayList<>();
    private TankofPlayer playerTank=new TankofPlayer(50,50);
    private Base base=new Base(350,500);
    /*construct*/
    public MainWindow(){
        super("坦克大战");


        MyPanel panel=new MyPanel();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("type");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("press");
                playerTank.move(e,panel.getGraphics(),obstacles);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("release");
            }
        });
        this.add(panel);
        this.setSize(800,600);
        this.setLocation(200,50);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        System.out.println("start");
        new MainWindow();
    }

    class MyPanel extends JPanel{
        private static final long serialVersionUID=1L;
        @Override
        public void paint(Graphics g){
            super.paint(g);
            this.setBackground(Color.black);
            initObstacle();
            for (Obstacle o:obstacles)
                DrawTool.drawImage("wallCanBeDestroyed",o.getX(),o.getY(),g);
            playerTank.draw(g);
            base.draw(g);
        }
    }


    private void initObstacle(){
        int initialx=100;
        int initialy=100;
        for(int i=0;i<5;i++){
            Obstacle obstacle=new WallCanBeDestroyed(initialx,initialy);
            obstacles.add(obstacle);
            initialy+=50;
        }
    }
}
