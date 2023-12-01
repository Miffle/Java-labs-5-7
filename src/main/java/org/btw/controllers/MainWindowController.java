package org.btw.controllers;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import org.btw.elemetns.mainWindowButtons.Buttons;

public class MainWindowController {

    public static VBox allMainWindowButtons() {
        Buttons buttons = new Buttons();
        VBox vBox = new VBox(buttons.getAdd(), buttons.getDelete(), buttons.getEdit(), buttons.getUse(), buttons.getSaveInJSON(), buttons.getLoadFromJSON());
        vBox.setAlignment(Pos.TOP_RIGHT);
        return vBox;
    }


}
