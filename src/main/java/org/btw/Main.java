package org.btw;

import org.btw.cameras.Camera;
import org.btw.cameras.PhoneCamera;
import org.btw.cameras.SlrCamera;
import org.btw.cameras.WebCamera;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static ArrayList<Camera> allCameras = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            menu();
            int choice = inputInt();
            switch (choice) {
                case 1 -> cameraChoice();// Создать камеру
                case 2 -> cameraDelete();// Удалить камеру
                case 3 -> featuresChoice(); // Изменить свойства (iso, разрешение..?)
                case 4 -> getAllCameras();// Вывести список камер
                case 5 -> playingWithFunctions();// функциональная работа с камерами, тут вообще хз
                case 6 -> exit = true;
                default -> System.out.println("Не знаю такой команды, давай заново");
            }
        }
    }

    private static void cameraChoice() {
        cameraChoiceMenu();
        int cameraChoice = inputInt();
        boolean exit = false;
        while (!exit) {
            exit = cameraChoiceSwitch(cameraChoice, exit);
        }
    }

    private static void cameraDelete() {
        int cameraId = getCameraId("Введи id камеры, которую хочешь удалить");
        if (cameraIdCheck(cameraId)) {
            allCameras.remove(cameraId - 1);
            System.out.println("Удалил!");
        } else System.out.println("Нет камеры с таким id.");
    }

    private static void featuresChoice() {
        featuresChoiceMenu();
        int functionsChoice = inputInt();
        int cameraId = getCameraId("Введи id камеры, свойства которой хочешь поменять");
        if (cameraIdCheck(cameraId)) {
            boolean exit = false;
            while (!exit) {
                exit = featuresChangeSwitch(functionsChoice, cameraId, exit);
            }
        } else {
            System.out.println("Нет камеры с таким id");
        }
    }

    private static void playingWithFunctions() {
        int cameraId = getCameraId("Введите ID камеры, которой попробуем воспользоваться");
        if (cameraIdCheck(cameraId)) {
            final Camera camera = allCameras.get(cameraId-1);
            boolean exit = false;
            while (!exit) {
                functionsChoiceMenu();
                int choice = inputInt();
                switch (choice) {
                    case 1 -> camera.takePicture();
                    case 2 -> camera.takeVideo();
                    case 3 -> camera.toggleChangeShootingMode();
                    case 4 -> camera.showAllMedia();
                    case 5 ->exit = true;
                    default -> throw new IllegalStateException("Не знаю такую команду: " + choice);
                }
            }
        }
    }

    private static boolean cameraChoiceSwitch(int cameraChoice, boolean exit) {
        switch (cameraChoice) {
            case 1 -> {
                allCameras.add(new SlrCamera(getApertureForCameras(), getShootingMod(), getIsoForCameras()));
                exit = true;
            }
            case 2 -> {
                allCameras.add(new PhoneCamera(getApertureForCameras(), getShootingMod(), getIsoForCameras()));
                exit = true;
            }
            case 3 -> {
                allCameras.add(new WebCamera(getApertureForCameras(), getShootingMod(), getIsoForCameras()));
                exit = true;
            }
            case 4 -> {
                System.out.println("Ладно, не буду создавать");
                exit = true;
            }
            default -> System.out.println("Я не знаю такую команду, давай заново.");
        }
        return exit;
    }

    private static boolean featuresChangeSwitch(int functionsChoice, int cameraId, boolean exit) {
        switch (functionsChoice) {
            case 1 -> {
                allCameras.get(cameraId - 1).changeISO(getIsoForCameras());
                exit = true;
            }
            case 2 -> {
                allCameras.get(cameraId - 1).changeAperture(getApertureForCameras());
                exit = true;
            }
            case 3 -> {
                allCameras.get(cameraId - 1).toggleChangeShootingMode();
                exit = true;
            }
            case 4 -> {
                System.out.println("Ну ладно, выходим");
                exit = true;
            }
            default -> System.out.println("Не знаю такого свойства");
        }
        return exit;
    }

    private static boolean cameraIdCheck(int id) {
        return allCameras.size() >= id;
    }
    private static void getAllCameras(){
        for (Camera cam :
                allCameras) {
            cam.getCamera();
        }
    }
    private static int getCameraId(String x) {
        System.out.println(x);
        return inputInt();
    }

    private static int getIsoForCameras() {
        System.out.println("Введи целое число для значения ISO");
        return inputInt();
    }

    private static String getShootingMod() {
        System.out.println("Введи 'photo' или 'video' для выбора начального режима съёмки");
        return inputShootingMod();
    }

    private static double getApertureForCameras() {
        System.out.println("Введи число для значения диафрагмы");
        return inputDouble();
    }

    public static int inputInt() {
        int result = 0;
        boolean accept = false;
        while (!accept) {
            Scanner scanner = makeScanner();
            try {
                result = scanner.nextInt();
                accept = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите целое число.");
            }
        }
        return result;
    }

    public static double inputDouble() {
        double result = 0;
        boolean accept = false;
        while (!accept) {
            Scanner scanner = makeScanner();
            try {
                result = scanner.nextDouble();
                accept = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите double число.");
            }
        }
        return result;
    }

    public static String inputShootingMod() {
        String result = "";
        boolean accept = false;
        while (!accept) {
            Scanner scanner = makeScanner();
            result = scanner.nextLine();
            if (Objects.equals(result, "photo") | Objects.equals(result, "video")) {
                accept = true;
            } else {
                System.out.println("Ошибка ввода. Пожалуйста, введите photo или video.");
            }
        }
        return result;
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

    private static void cameraChoiceMenu() {
        System.out.println("""
                Какую камеру хочешь создать?
                1. SLR Камера (зеркалка),
                2. Камера телефона,
                3. Веб камера,
                4. Выход из создания.""");
    }

    private static void featuresChoiceMenu() {
        System.out.println("""
                Что будем менять?
                1. ISO,
                2. Диафрагму,
                3. Режим съёмки,
                4. Выход.""");
    }

    private static void functionsChoiceMenu() {
        System.out.println("""
                Что будем делать?
                1. Сделаем фото.
                2. Снимем видео.
                3. Поменяем режим съемки.
                4. Посмотрим все медиафайлы, которые хранятся на камере.
                5. Выход.""");
    }

    public static void menu() {
        System.out.println("""
                Это меню, что будем делать?
                1) Добавим новую камеру в базу.
                2) Удалим камеру из базы.
                3) Поменяем свойства какой-нибудь камеры.
                4) Выведем ID всех камер, которые есть
                5) Поиграем с камерой (сделаем фото, снимем видео и т.д.)
                6) Не будем ничего делать и выйдем.""");
    }
}