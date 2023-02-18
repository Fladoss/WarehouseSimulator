package vlados.warehouse;

public class Owner {
    private volatile static Float money = 0.0f;

    public static Float getMoney() {
        return money;
    }
    public synchronized static void setMoney(Float money) {
        Owner.money = money;
    }

    private volatile static Float moneyMultiplier = 0.0f;

    public static Float getMoneyMultiplier() {
        return moneyMultiplier;
    }
    public static void setMoneyMultiplier(Float moneyMultiplier) {
        Owner.moneyMultiplier = moneyMultiplier;
    }

    private volatile static int numberOfGoods;

    public static int getNumberOfGoods() {
        return numberOfGoods;
    }
    public static void setNumberOfGoods(int numberOfGoods) {
        Owner.numberOfGoods = numberOfGoods;
    }
}
