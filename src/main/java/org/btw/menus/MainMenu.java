package org.btw.menus;

import org.btw.mediafiles.AllCamerasStorage;

public class MainMenu {
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
                case 1 -> CameraCreationMenu.cameraChoice();// Создать камеру
                case 2 -> CameraDeleting.cameraDelete();// Удалить камеру
                case 3 -> CameraFeaturesMenu.featuresChoice(); // Изменить свойства (iso, разрешение..?)
                case 4 -> AllCamerasStorage.getAllCameras();// Вывести список камер
                case 5 -> CameraFunctionsMenu.playingWithFunctions();// функциональная работа с камерами, тут вообще хз
                case 6 -> exit = true;
                default -> System.out.println("Не знаю такой команды, давай заново");
            }
        }
    }
}
