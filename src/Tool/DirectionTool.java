package Tool;

import tank.Direction;

public class DirectionTool {
    public static void changetempPoint(Direction direction,IntTool intTool){
        switch (direction) {
            case UP:
                intTool.setY(intTool.getY()-50);
                break;
            case DOWN:
                intTool.setY(intTool.getY()+50);
                break;
            case LEFT:
                intTool.setX(intTool.getX()-50);
                break;
            case RIGHT:
                intTool.setX(intTool.getX()+50);
                break;
            default:
        }
    }
}
