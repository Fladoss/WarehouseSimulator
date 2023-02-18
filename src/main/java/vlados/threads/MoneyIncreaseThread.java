package vlados.threads;

import vlados.main.App;
import vlados.shop.Salesman;
import vlados.warehouse.Owner;
import vlados.warehouse.Warehouse;

public class MoneyIncreaseThread extends Thread {
    private Object lock;
    private Salesman salesman;

    public MoneyIncreaseThread(Object lock, Salesman salesman) {
        this.lock = lock;
        this.salesman = salesman;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Warehouse.addMoneyMultiplier();
                Owner.setMoney(Owner.getMoneyMultiplier());
                //System.out.println("Money: $" + String.format("%.2f", Owner.getMoney()) + Salesman.getGoodsAtShop());
                Thread.sleep(1000);
                synchronized (lock) {
                    while (salesman.isInShop()) {
                        lock.wait();
                    }
                }
            } catch (InterruptedException ignored) {}
        }
    }
}
