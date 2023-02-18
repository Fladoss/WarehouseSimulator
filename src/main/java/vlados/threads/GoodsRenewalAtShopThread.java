package vlados.threads;

import vlados.main.App;
import vlados.misc.Goods;
import vlados.shop.GoodsForSale;
import vlados.shop.Salesman;

import java.util.Random;

public class GoodsRenewalAtShopThread extends Thread {
    private Object lock;
    private Salesman salesman;

    public GoodsRenewalAtShopThread(Object lock, Salesman salesman) {
        this.lock = lock;
        this.salesman = salesman;
    }
    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            try {
                if (GoodsForSale.getGoodsForSale().size() < Salesman.getMaximumGoodsAtShop()) {
                    Thread.sleep(3000);
                    // generate a random index between 0 and the length of the Goods
                    int randomIndex = rand.nextInt(Goods.values().length);

                    // add the enum value at the random index to the goodsForSale list
                    GoodsForSale.getGoodsForSale().add(Goods.values()[randomIndex]);

                    // добавляем товар в хранилище магазина Salesman
                    Salesman.setGoodsAtShop(Salesman.getGoodsAtShop() + 1);

                    //System.out.println("Good added! See all goods: " + GoodsForSale.getGoodsForSale());

                    synchronized (lock) {
                        while (salesman.isInShop()) {
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException ignored) {}
        }
    }
}
