package Tool;

import java.awt.*;

public class DrawTool {

    public static void drawImage(String imageName,int x,int y,Graphics graphics){
        Image image=Toolkit.getDefaultToolkit().getImage("./image/"+imageName+".jpg");
        graphics.drawImage(image,x,y,null);
    }
}
