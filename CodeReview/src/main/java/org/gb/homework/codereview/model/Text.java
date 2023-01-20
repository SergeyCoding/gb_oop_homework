package org.gb.homework.codereview.model;

import org.gb.homework.codereview.controllers.Processable;

public class Text implements Processable {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void processing() {
        System.out.println("Текст сохранен");
        System.out.println(getText());
    }
}
