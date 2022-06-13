package com.github.bpiotrek.restaurant.ui;

import java.io.*;

public class UI {
    private final BufferedWriter outputWriter;
    private final BufferedReader inputReader;
    private final MenuView mainMenu;
    private MenuView currentMenu;

    private String lastInput;
    private boolean stopApplication = false;
    private boolean invalidInput = false;

    public UI(BufferedWriter outputWriter, BufferedReader inputReader, MenuView mainMenu) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        mainMenu.setUIParent(this);
        this.mainMenu = mainMenu;
        this.currentMenu = mainMenu;
    }

    public void write(String message) {
        try {
            outputWriter.write(message);
        } catch (IOException ignored) {

        }
    }

    public void flush() {
        try {
            outputWriter.flush();
        } catch (IOException ignored) {

        }
    }

    public void writeMessage(String message) {
        write(message);
        flush();
    }

    public String getInput() {
        try {
            lastInput = inputReader.readLine();
        } catch (IOException ignored) {
        }

        return lastInput;
    }

    public void invalidResponse() {
        invalidInput = true;
    }

    private void clearScreen() {
        writeMessage("---new screen---\n");
    }

    public void endApp() {
        this.stopApplication = true;
    }

    private void runMenu(MenuView menu) {
        write(menu.getMenuText());
        if(invalidInput) {
            write("response not understood: " + lastInput + "\n");
            invalidInput = false;
        }
        write(menu.getMenuPrompt());
        flush();
        menu.acceptInput(getInput());
        if(stopApplication || invalidInput) {
            return;
        }
        currentMenu = menu.getTransition();
        if(currentMenu == null) {
            currentMenu = mainMenu;
        }
    }

    public void runApp() {
        do {
            clearScreen();
            runMenu(currentMenu);
        } while(!stopApplication);
        writeMessage("Bye, bye!");
    }
}
