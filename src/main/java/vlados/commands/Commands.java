package vlados.commands;

public enum Commands {
    HELP("help"),
    MONEY("m"),
    GOODS("g"),
    LEAVE("l"),
    YES("yes"),
    NO("no"),
    AREA("area"),
    BUY("buy"),
    SHOP("s"),
    SELL("sell");

    public final String command;

    Commands(String command) {
        this.command = command;
    }
}
