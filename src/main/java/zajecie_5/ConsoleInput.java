package zajecie_5;

import java.util.concurrent.*;

public class ConsoleInput {

    private final int timeout;
    private final TimeUnit unit;

    public ConsoleInput(int timeout, TimeUnit unit) {

        this.timeout = timeout;
        this.unit = unit;
    }

    public Integer readLine() throws InterruptedException {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Integer input = null;
        try {
            // start working
            Future<Integer> result = ex.submit(
                    new ConsoleInputReadTask());
            try {
                input = result.get(timeout, unit);
            } catch (ExecutionException e) {
                e.getCause().printStackTrace();
            } catch (TimeoutException e) {
                result.cancel(true);
            }

        } finally {
            ex.shutdownNow();
        }
        return input;
    }
}

