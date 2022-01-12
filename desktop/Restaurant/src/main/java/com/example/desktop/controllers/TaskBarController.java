package com.example.desktop.controllers;

import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.TaskBarView;


public class TaskBarController {

    private final TaskBarView view;

    public TaskBarController(TaskBarView view){
        this.view = view;

        updateActionListener();
    }

    private void updateActionListener(){
        view.getButton().addActionListener(e -> showCooks());
    }

    private void showCooks(){
        CooksView cooksView = new CooksView();
        new LogIOController(cooksView);
    }
}