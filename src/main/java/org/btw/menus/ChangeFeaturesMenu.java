package org.btw.menus;

import org.btw.menus_handlers.CameraFeaturesHandler;

public class ChangeFeaturesMenu extends Menu {
    public ChangeFeaturesMenu() {
        options.add(new MenuOption("ISO", CameraFeaturesHandler::FChangeISO));
        options.add(new MenuOption("Диафрагму", CameraFeaturesHandler::FChangeAperture));
        options.add(new MenuOption("Режим съемки", CameraFeaturesHandler::FChangeShootingMode));
        options.add(new MenuOption("Выйти"));
    }
}
