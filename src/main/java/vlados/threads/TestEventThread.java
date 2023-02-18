package vlados.threads;

public class TestEventThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Test Event happened!");
            } catch (InterruptedException e) {
                System.out.println("Test Event stopped.");
                break;
            }
        }
    }
}
