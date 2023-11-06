package org.btw.menus;

import org.btw.Main;
import org.btw.cameras.AllCamerasStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMenu {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    static final String menu = """
            Это меню, что будем делать?
            1) Добавим новую камеру в базу.
            2) Удалим камеру из базы.
            3) Поменяем свойства какой-нибудь камеры.
            4) Выведем ID всех камер, которые есть
            5) Поиграем с камерой (сделаем фото, снимем видео и т.д.)
            6) Не будем ничего делать и выйдем.""";

    static public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println(menu);
            int choice = InputValidation.inputInt();
            switch (choice) {
                case 1 -> {
                    logger.info("Выбран пункт создания новой камеры");
                    CameraCreationMenu.cameraChoice();
                }
                case 2 -> {
                    logger.info("Выбран пункт удаления камеры");
                    CameraDeleting.cameraDelete();
                }
                case 3 -> {
                    logger.info("Выбран пункт изменения свойств камеры");
                    CameraFeaturesMenu.featuresChoice();
                }
                case 4 -> {
                    logger.info("Выбран пункт вывода всех камер в консоль");
                    AllCamerasStorage.getAllCameras();
                }
                case 5 -> {
                    logger.info("Выбран пункт взаимодействия с камерой");
                    CameraFunctionsMenu.playingWithFunctions();
                }
                case 6 -> {
                    logger.info("Выход из программы");
                    exit = true;
                }
                default -> {
                    logger.warn("Неправильно введено число при выборе действия в меню");
                    System.out.println("Не знаю такой команды, давай заново");
                }
            }
        }
    }
}
