package org.btw.menus;

import org.btw.cameras.AllCamerasStorage;
import org.btw.menus_handlers.CameraCreationHandler;
import org.btw.menus_handlers.CameraDeletingHandler;
import org.btw.menus_handlers.CameraFeaturesHandler;
import org.btw.menus_handlers.CameraFunctionsHandler;

public class MainMenu extends Menu {
    public MainMenu(){
        options.add(new MenuOption("Добавим новую камеру в базу.", CameraCreationHandler::cameraChoice));
        options.add(new MenuOption("Удалим камеру из базы.", CameraDeletingHandler::cameraDelete));
        options.add(new MenuOption("Поменяем свойства какой-нибудь камеры.", CameraFeaturesHandler::featuresChoice));
        options.add(new MenuOption("Выведем ID всех камер, которые есть.", AllCamerasStorage::getAllCameras));
        options.add(new MenuOption("Поиграем с камерой (сделаем фото, снимем видео и т.д.).", CameraFunctionsHandler::playingWithFunctions));
        options.add(new MenuOption("Не будем ничего делать и выйдем."));
    }

}