package vlados.warehouse;

import vlados.misc.Goods;

import java.util.ArrayList;

public class Warehouse {
    private static int a;
    private static int b;
    private static int c;
    private static int warehouseArea;

    public synchronized void setWarehouseArea(int warehouseArea) {
        Warehouse.warehouseArea = warehouseArea;
    }
    public static int getWarehouseArea() {
        return warehouseArea;
    }

    private static int warehouseFullness;

    public int getWarehouseFullness() {
        return warehouseFullness;
    }
    public synchronized void setWarehouseFullness(int warehouseFullness) {
        Warehouse.warehouseFullness = warehouseFullness;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        Warehouse.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        Warehouse.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        Warehouse.c = c;
    }

    static volatile ArrayList<Goods> goodsAtWarehouse = new ArrayList<>();

    // test initialization of Goods array
    public static void addGoodsAtWarehouse() {
        goodsAtWarehouse.add(Goods.BOX);
        goodsAtWarehouse.add(Goods.BOX);
        goodsAtWarehouse.add(Goods.BOX2);
        System.out.println(goodsAtWarehouse);
    }

    // print all goods from an array to console
    public static void printGoods() {
        if (goodsAtWarehouse.size() != 0) {
            StringBuilder sb = new StringBuilder();
            System.out.print("Список ваших товаров: ");
            for (Goods good : goodsAtWarehouse) {
                sb.append(good).append(" ");
            }
            System.out.println(sb);
        }
        else {
            System.out.println("У вас нет товара!");
        }
    }

    // берем в цикле у каждого элемента Goods кол-во денег что он приносит и добавляем в Owner
    public static void addMoneyMultiplier() {
        for (Goods good : goodsAtWarehouse) {
            Owner.setMoneyMultiplier(Owner.getMoneyMultiplier() + good.moneyGain);
        }
    }
}
