package com.github.bpiotrek.restaurant.ui;

public class ConfirmationScreen extends MenuView {

    private final String confirmationText;
    private final Runnable action;

    public ConfirmationScreen(final String confirmationText, final Runnable action) {
        this.confirmationText = confirmationText;
        this.action = action;
    }

    @Override
    public String getMenuText() {
        return confirmationText;
    }

    @Override
    public String getMenuPrompt() {
        return "Yes or No [y]: ";
    }

    @Override
    public void acceptInput(final String input) {
        if (input.equalsIgnoreCase("n")) {
            return;
        }
        switch (input.toLowerCase()) {
            case "", "y" -> action.run();
            default -> ui.invalidResponse();
        }
    }
}
