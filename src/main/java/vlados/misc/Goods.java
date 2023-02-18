package vlados.misc;

import java.util.Arrays;
import java.util.List;

public enum Goods {
    BOX("Box", 0, 1.0f, 1 , 1, 1),
    BOX2("Box2", 0, 2.0f, 1, 1, 1),
    BOX3("Box3", 0, 3.0f, 1, 1, 1);

    public final String name;
    public final int quantity;
    public final Float moneyGain;
    public final int length;
    public final int width;
    public final int height;

    Goods(String name, int quantity, Float moneyGain, int length, int width, int height) {
        this.name = name;
        this.quantity = quantity;
        this.moneyGain = moneyGain;
        this.length = length;
        this.width = width;
        this.height = height;
    }

}
