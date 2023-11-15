package org.btw.menus;

import org.btw.menus_handlers.CameraFunctionsHandler;

public class ChoiceFunctionsMenu extends Menu{
    public ChoiceFunctionsMenu(){
        options.add(new MenuOption("Сделать фото",CameraFunctionsHandler::newPhoto));
        options.add(new MenuOption("Снять видео", CameraFunctionsHandler::newVideo));
        options.add(new MenuOption("Поменять режим съемки", CameraFunctionsHandler::changeShootingMood));
        options.add(new MenuOption("Посмотреть все медиафайлы", CameraFunctionsHandler::showAllMedia));
        options.add(new MenuOption("Выйти"));
    }
}
