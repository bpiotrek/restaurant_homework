package com.github.bpiotrek.restaurant.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class UI {

    private final BufferedWriter outputWriter;
    private final BufferedReader inputReader;
    private final MenuView mainMenu;
    private MenuView currentMenu;

    private String lastInput;
    private boolean stopApplication = false;
    private boolean invalidInput = false;
    private String invalidInputMessage = "";
    private final static String defaultInvalidInputMessage = "response not understood: ";

    public UI(BufferedWriter outputWriter, BufferedReader inputReader, MenuView mainMenu) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        mainMenu.setUIParent(this);
        this.mainMenu = mainMenu;
        this.currentMenu = mainMenu;
    }

    public void write(String message) throws IOException {
        outputWriter.write(message);

    }

    public void flush() throws IOException {
        outputWriter.flush();
    }

    public void writeMessage(String message) throws IOException {
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
        invalidResponse(defaultInvalidInputMessage);
    }

    public void invalidResponse(String message) {
        invalidInputMessage = message;
        invalidInput = true;
    }

    private void clearScreen() throws IOException {
        write("---new screen---\n\033[H\033[2J");
    }

    public void endApp() {
        this.stopApplication = true;
    }

    public void runApp() throws IOException {
        do {
            clearScreen();
            write("   --- " + currentMenu.getMenuTitle() + " ---   \n");
            write(currentMenu.getMenuText());
            if (invalidInput) {
                write(invalidInputMessage + lastInput + "\n");
                invalidInput = false;
            }
            write(currentMenu.getMenuPrompt());
            flush();
            currentMenu.acceptInput(getInput());
            if (stopApplication || invalidInput) {
                continue;
            }
            currentMenu = currentMenu.getTransition();
            if (currentMenu == null) {
                currentMenu = mainMenu;
            }
        } while (!stopApplication);
        writeMessage("Bye, bye!\n");
    }
}
