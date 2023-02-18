package vlados.shop;

import vlados.main.App;
import vlados.misc.Goods;
import vlados.threads.GoodsRenewalAtShopThread;
import vlados.threads.MoneyIncreaseThread;

import java.util.Scanner;

public class Salesman extends GoodsForSale {
    private Object lock;
    private volatile boolean isInShop;

    public Salesman(Object lock) {
        this.lock = lock;
        isInShop = false;
    }

    private static final String ENTER = "[Вы вошли в магазин...]";
    private static final String LEAVE = "[Вы вышли из магазина.]";
    private static final String HELLO = "Боб > Здравствуй! Добро пожаловать, снова, хех.";
    private static final String AVAILABLE_GOODS = "Боб > Вот мой ассортимент: ";
    private static final String WANT_TO_BUY_SOMETHING = "Боб > Хочешь что-то купить?";
    private static final String NOT_AVAILABLE = "Боб > Прости! Весь товар раскуплен! Заходи попозже.";
    private static final String GOODBYE = "Боб > Давай, счастливо!";
    private static final String GOODBYE_AFTER_PURCHASE = "Боб > Спасибо за покупки, до скорого!";
    private static final String PURCHASE_SUCCESSFUL = "[Покупка успешна!]";
    private static final String PURCHASE_FAILURE = "[Покупка не удалась!]";
    private volatile static int maximumGoodsAtShop = 20;
    private volatile static int goodsAtShop = 0;

    public static int getMaximumGoodsAtShop() {
        return maximumGoodsAtShop;
    }

    public synchronized static void setMaximumGoodsAtShop(int maximumGoodsAtShop) {
        Salesman.maximumGoodsAtShop = maximumGoodsAtShop;
    }

    public static int getGoodsAtShop() {
        return goodsAtShop;
    }

    public synchronized static void setGoodsAtShop(int goodsAtShop) {
        Salesman.goodsAtShop = goodsAtShop;
    }

    public void shopCycle() {
        isInShop = true;

        // блокируем все потоки - теперь они на паузе
        synchronized (lock) {
            lock.notifyAll();
        }

        try {

            System.out.println(ENTER);
            Thread.sleep(1000);
            System.out.println(HELLO);

            if (Salesman.goodsAtShop > 0) {
                StringBuilder sb = new StringBuilder();
                System.out.println(AVAILABLE_GOODS);
                for (Goods good : GoodsForSale.getGoodsForSale()) {
                    sb.append(good.name).append(" ");
                }
                System.out.println(sb);

                Thread.sleep(1000);

                while (true) {
                    System.out.println(WANT_TO_BUY_SOMETHING);
                    System.out.print("> ");
                    String l = new Scanner(System.in).nextLine();
                    if (l.equals("Да") || l.equals("да") || l.equals("д") || l.equals("yes") || l.equals("y")) {
                        System.out.println("> Да, хочу.");
                        Thread.sleep(1000);
                        System.out.println("ИЗВИНИТЕ! ПРОГРАММА В РАЗРАБОТКЕ! ЭЛЬ ПСАЙ КОНГРУ");
                        break;

                    }
                    else if (l.equals("Нет") || l.equals("нет") || l.equals("н") || l.equals("no") || l.equals("n")) {
                        System.out.println(GOODBYE);
                        Thread.sleep(1000);
                        System.out.println(LEAVE);
                        Thread.sleep(1000);
                        break;
                    }
                    else {
                        System.out.println("[Такой команды нет!]");
                    }
                }

            }

            else {
                System.out.println(NOT_AVAILABLE);
                Thread.sleep(1000);
                System.out.println(LEAVE);
                Thread.sleep(1000);
            }

        } catch (InterruptedException ignored) {}

        isInShop = false;

        // разблокировали потоки - флаг isInShop равен false, поэтому потоки могут продолжить работу
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public boolean isInShop() {
        return isInShop;
    }
}
