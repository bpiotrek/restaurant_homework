package com.github.bpiotrek.restaurant.ui;

import java.util.regex.Pattern;

public abstract class MenuView {

    protected UI ui;
    protected MenuView transition;

    public String getMenuTitle() {
        return this.getClass().getSimpleName().replaceAll("([A-Z])", " $1");
    }

    public String getMenuText() {
        return "";
    }

    public String getMenuPrompt() {
        return "";
    }

    public void acceptInput(String input) {
    }

    public MenuView getTransition() {
        var tmp = transition;
        transition = null;
        return tmp;
    }

    public void setTransition(MenuView transition) {
        transition.setUIParent(ui);
        this.transition = transition;
    }

    public void setUIParent(UI ui) {
        this.ui = ui;
    }
}
