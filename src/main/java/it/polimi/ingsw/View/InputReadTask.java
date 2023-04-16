package it.polimi.ingsw.View;

import java.io.*;
import java.util.concurrent.Callable;

/**
 * This class is used to read the input stream and making the input kind of interruptible.
 */
public class InputReadTask implements Callable<String> {
    private final BufferedReader br;

    public InputReadTask() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String call() throws IOException, InterruptedException {
        String input;
        // wait until there is data to complete a readLine()
        while (!br.ready()) {
            Thread.sleep(200);
        }
        input = br.readLine();
        return input;
    }
}