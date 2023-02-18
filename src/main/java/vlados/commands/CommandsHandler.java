package vlados.commands;

import vlados.main.App;
import vlados.shop.Salesman;
import vlados.warehouse.Owner;
import vlados.warehouse.Warehouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsHandler {
    public static void execute() throws IOException {
        BufferedReader playerCommand = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("> ");
            String command = playerCommand.readLine();
            if (command.equals(Commands.HELP.command)) {
                System.out.println("Список всех комманд:");
                System.out.println(Commands.HELP.command + " - выводит все команды,");
                System.out.println(Commands.MONEY.command + " - выводит ваши средства,");
                System.out.println(Commands.SHOP.command + " - отправляет вас в магазин.");
                System.out.println(Commands.AREA.command + " - выводит вместительность и площадь Вашего склада.");
                System.out.println(Commands.GOODS.command + " - показывает Ваш товар на складе.");
            }
            else if (command.equals(Commands.MONEY.command)) {
                System.out.println("На вашем счету: $" + String.format("%.2f", Owner.getMoney()));
            }
            else if (command.equals(Commands.GOODS.command)) {
                Warehouse.printGoods();
            }
            else if (command.equals(Commands.SHOP.command)) {
                Salesman salesman = App.salesman;
                salesman.shopCycle();
            }
            else System.out.println("Такой команды нет!");
        }
    }
}
