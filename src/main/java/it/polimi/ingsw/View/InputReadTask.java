package it.polimi.ingsw.View;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * This class is used to read the input stream and making the input kind of interruptible.
 */
public class InputReadTask implements Runnable {
    private boolean freeInput;
    private final Scanner scanner;
    private final View view;
    private boolean isOn;

    public InputReadTask(View view){
        this.view = view;
        freeInput = true;
        scanner = new Scanner (System.in);
        isOn = true;
    }

    @Override
    public void run() {
        while (isOn){
            String input = scanner.nextLine();
            if(freeInput){
                //view.command(input);
            }
        }
    }

    public void setFreeInput(boolean freeInput) {
        this.freeInput = freeInput;
    }

    public void close() {
        freeInput = false;
        isOn = false;
    }
}