package vlados.shop;

import vlados.misc.Goods;

import java.util.ArrayList;
import java.util.Random;

public class GoodsForSale {
    public static ArrayList<Goods> getGoodsForSale() {
        return goodsForSale;
    }

    private volatile static ArrayList<Goods> goodsForSale = new ArrayList<>(Salesman.getMaximumGoodsAtShop());

    public synchronized void initializeGoodsAtShop() {
        Random rand = new Random();
        for (int i = 0; i < Salesman.getMaximumGoodsAtShop(); i++) {
            // Generate a random index between 0 and the length of the enum
            int randomIndex = rand.nextInt(Goods.values().length);

            // Add the enum value at the random index to the goodsForSale list
            goodsForSale.add(Goods.values()[randomIndex]);

            // добавляем товар в хранилище магазина
            Salesman.setGoodsAtShop(Salesman.getGoodsAtShop() + 1);
        }
        Salesman.setGoodsAtShop(Salesman.getMaximumGoodsAtShop());

        System.out.println("Товар добавлен! Вот список всех товаров! -> " + goodsForSale);
    }
}
