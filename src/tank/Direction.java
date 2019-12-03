package tank;

public enum Direction {
    /*
    运动方向的枚举类
    停止，向上，向下，向左，向右
     */
    STOP(0),
    UP(1),
    DOWN(2),
    LEFT(3),
    RIGHT(4);
    private final int value;

    Direction(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
