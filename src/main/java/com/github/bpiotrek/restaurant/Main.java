package com.github.bpiotrek.restaurant;

import com.github.bpiotrek.restaurant.ui.MainMenu;
import com.github.bpiotrek.restaurant.ui.UI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) {
        final var ui = new UI(
                new BufferedWriter(new OutputStreamWriter(System.out)),
                new BufferedReader(new InputStreamReader(System.in)),
                new MainMenu()
        );
        ui.runApp();
    }
}