package org.btw.menus;

import org.btw.menus_handlers.CameraCreationHandler;

public class CreationMenu extends Menu {
    public CreationMenu() {
        options.add(new MenuOption("SLR камера", CameraCreationHandler::addNewSlrCamera));
        options.add(new MenuOption("Камера телефона", CameraCreationHandler::addNewPhoneCamera));
        options.add(new MenuOption("Веб камера", CameraCreationHandler::addNewWebCamera));
        options.add(new MenuOption("Никакую, выйдем лучше"));
    }
}
