package vlados.main;

import vlados.warehouse.Warehouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UtilWarehouse {
    Warehouse warehouse = new Warehouse();
    BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public void initializeWarehouse() throws IOException {

        int a = 0;
        int b = 0;
        int c = 0;

        while (true) {
            System.out.println("Задайте длину:");
            System.out.print("> ");
            String line = scanner.readLine();

            try {
                int number = Integer.parseInt(line);
                if (number > 0 && number < 50) {
                    warehouse.setA(number);
                    a = number;
                    //System.out.println("Длина склада равна " + warehouse.getA() + " метров.");
                    break;
                }
                if (number >= 50) {
                    warehouse.setA(number);
                    a = number;
                    //System.out.println("Ну нихуя себе! Ладно, длина равна " + warehouse.getA() + " метров.");
                    break;
                }
                if (number <= 0) {
                    System.out.println("Длина не может быть меньше 0м или быть равной 0м!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }

        while (true) {
            System.out.println("Задайте ширину:");
            System.out.print("> ");
            String line = scanner.readLine();

            try {
                int number = Integer.parseInt(line);
                if (number > 0 && number < 50) {
                    warehouse.setB(number);
                    b = number;
                    //System.out.println("Ширина склада равна " + warehouse.getB() + " метров.");
                    break;
                }
                if (number >= 50) {
                    warehouse.setB(number);
                    b = number;
                    //System.out.println("Блять... Ширина равна " + warehouse.getB() + " метров. Пиздец чел.");
                    break;
                }
                if (number <= 0) {
                    //System.out.println("Ширина не может быть меньше 0 или быть равной 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }

        while (true) {
            System.out.println("Задайте высоту:");
            System.out.print("> ");
            String line = scanner.readLine();

            try {
                int number = Integer.parseInt(line);
                if (number > 0 && number < 50) {
                    warehouse.setC(number);
                    c = number;
                    //System.out.println("Высота склада равна " + warehouse.getC() + " метров.");
                    break;
                }
                else if (number >= 50) {
                    warehouse.setC(number);
                    c = number;
                    //System.out.println("Ну ты реально сумасшедший бро. Вот твоя высота: " + warehouse.getC() + " метров...");
                    break;
                }
                else if (number <= 0) {
                    System.out.println("Высота не может быть меньше 0м или быть равной 0м!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }

        warehouse.setWarehouseArea(((a + a) + (b + b)) * c);
        warehouse.setWarehouseFullness((a * b) * c);
    }

    public void initializeAgain() throws IOException {
        while (true) {
            String line = scanner.readLine();
            if ((line.equals("Да")) || (line.equals("да") || (line.equals("д")) || (line.equals("y")))) {
                initializeWarehouse();
                System.out.println("Ваш склад готов! Длина: " + warehouse.getA() + " метров, ширина: " + warehouse.getB() + " метров, длина: " + warehouse.getC() + " метров.");
                System.out.println("Площадь составляет " + Warehouse.getWarehouseArea() + " метров.");
                System.out.println("Хотите изменить склад? Напишите \"Да\" или \"Нет\".");
                System.out.print("> ");
            }
            else if ((line.equals("Нет")) || (line.equals("нет")) || (line.equals("н")) || (line.equals("n"))) {
                System.out.println("Ваш текущий склад сохранен.");
                break;
            }
            else {
                System.out.println("Введите Да или Нет.");
                System.out.print("> ");
            }
        }
    }
}
