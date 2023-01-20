package org.gb.homework.codereview.model;

import org.gb.homework.codereview.controllers.Processable;

/**
 *
 */
public class Picture implements Processable {

    private int myPicture;

    public Picture(int myPicture) {
        this.myPicture = myPicture;
    }

    public int getMyPicture() {
        return myPicture;
    }

    public void setMyPicture(int myPicture) {
        this.myPicture = myPicture;
    }

    @Override
    public void processing() {
        System.out.println("Картинка сохранена");
        System.out.println(getMyPicture());
    }
}
