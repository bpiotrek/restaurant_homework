package com.github.bpiotrek.restaurant.ui;

public abstract class MenuView {
    protected UI ui;
    protected MenuView transition;

    public void setUIParent(UI ui) {
        this.ui = ui;
    }

    public String getMenuText() {
        return "";
    }

    public String getMenuPrompt() {
        return "";
    }

    public void acceptInput(String input) {
    }

    public void setTransition(MenuView transition) {
        transition.setUIParent(ui);
        this.transition = transition;
    }

    public MenuView getTransition() {
        var tmp = transition;
        transition = null;
        return tmp;
    }
}
