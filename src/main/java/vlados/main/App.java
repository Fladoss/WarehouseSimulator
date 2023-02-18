package vlados.main;

import vlados.commands.CommandsHandler;
import vlados.messages.Messages;
import vlados.shop.Salesman;
import vlados.threads.GoodsRenewalAtShopThread;
import vlados.threads.MoneyIncreaseThread;
import vlados.warehouse.Warehouse;

public class App {
    public static Object lock = new Object();
    public static Salesman salesman = new Salesman(lock);
    public static MoneyIncreaseThread moneyIncreaseThread = new MoneyIncreaseThread(lock, salesman);
    public static GoodsRenewalAtShopThread goodsRenewalAtShopThread = new GoodsRenewalAtShopThread(lock, salesman);
    public static void main(String[] args) throws Exception {

        // создаем объект класса Warehouse для доступа к полям и методам класса (нестатическим)
        Warehouse warehouse = new Warehouse();

        // создаем объект класса Messages для доступа к полям и методам класса (нестатическим)
        Messages firstMessages = new Messages();

        // выводим на экран приветствие
        firstMessages.printStartMessages();

        // создаем объект класса utilWarehouse для доступа к утильным мутодам класса
        UtilWarehouse utilWarehouse = new UtilWarehouse();

        // инициализируем склад, заполняя его длину, ширину и длину
        utilWarehouse.initializeWarehouse();

        // выводим на экран сообщение что склад инициализирован данными
        firstMessages.printWarehouseReady();

        // спрашиваем у пользователя хочет ли он изменить склад
        firstMessages.printChangeWarehouse();

        System.out.println("Отлично! Теперь Ваш склад точно готов к работе!");

        System.out.println("Теперь, когда у Вас готов склад, вы можете закупать товар, который будет приносить прибыль каждую секунду.");
        System.out.println("С этого момента командная строка открыта всегда для ввода, с помощью нее можно полностью управлять приложением!");
        System.out.println("Напишите \"help\", чтобы узнать какие есть команды. Удачи!");

        //new TestEventThread().start();
        moneyIncreaseThread.start();
        goodsRenewalAtShopThread.start();
        Warehouse.addGoodsAtWarehouse();
        //new GoodsForSale().initializeGoodsAtShop();

        CommandsHandler.execute();
    }
}