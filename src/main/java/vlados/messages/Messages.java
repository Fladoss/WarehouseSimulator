package vlados.messages;

import vlados.main.UtilWarehouse;
import vlados.warehouse.Warehouse;

import java.io.IOException;

public class Messages implements Printable {
    @Override
    public void print() {
    }

    public void printStartMessages() {
        //Thread.sleep(1000);
        System.out.println("Добро пожаловать в Ваш новый склад!");
        //Thread.sleep(2000);
        System.out.println("У склада есть площадь, уровень дохода и его заполненность.");
        //Thread.sleep(2000);
        System.out.println("1 товар равен 1 метру пространства вашего склада.");
        //Thread.sleep(2000);
        System.out.println("Для начала, вы должны задать параметры Вашему складу.");
        //Thread.sleep(2000);
    }

    public void printWarehouseReady() {
        Warehouse warehouse = new Warehouse();
        System.out.println("Ваш склад готов! Длина: " + warehouse.getA() + " метров, ширина: " + warehouse.getB() + " метров, длина: " + warehouse.getC() + " метров.");
        System.out.println("Площадь составляет " + Warehouse.getWarehouseArea() + " метров кв.");
    }

    public void printChangeWarehouse() {
        UtilWarehouse utilWarehouse = new UtilWarehouse();
        System.out.println("Хотите изменить склад? Напишите \"Да\" или \"Нет\".");
        System.out.print("> ");
        try {
            utilWarehouse.initializeAgain();
        } catch (IOException ignored) {}
    }
}
