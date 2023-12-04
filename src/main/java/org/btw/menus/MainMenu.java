package org.btw.menus;

import org.btw.models.cameras.AllCamerasStorage;
import org.btw.menus_handlers.*;

public class MainMenu extends Menu {
    public MainMenu(){
        options.add(new MenuOption("Добавим новую камеру в базу.", CameraCreationHandler::cameraChoice));
        options.add(new MenuOption("Удалим камеру из базы.", CameraDeletingHandler::cameraDelete));
        options.add(new MenuOption("Поменяем свойства какой-нибудь камеры.", CameraFeaturesHandler::featuresChoice));
        options.add(new MenuOption("Выведем ID всех камер, которые есть.", AllCamerasStorage::getAllCameras));
        options.add(new MenuOption("Поиграем с камерой (сделаем фото, снимем видео и т.д.).", CameraFunctionsHandler::playingWithFunctions));
//        options.add(new MenuOption("Экспорт в JSON", new Thread(()->new JSONSaveHandler()).start()));
        options.add(new MenuOption("Импорт из JSON", FromJSONReadHandler::readFromJSON));
        options.add(new MenuOption("Не будем ничего делать и выйдем."));
    }

}