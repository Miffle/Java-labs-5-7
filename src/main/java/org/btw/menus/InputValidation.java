package org.btw.menus;

import org.btw.Main;
import org.btw.cameras.Camera;
import org.btw.cameras.AllCamerasStorage;
import org.btw.mediafiles.MediaFileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InputValidation {
    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Функция, с помощью цикла принимает только int значение.
     *
     * @return int значение
     */
    public static int inputInt() {
        int result = 0;
        boolean accept = false;
        while (!accept) {
            Scanner scanner = makeScanner();
            try {
                result = scanner.nextInt();
                accept = true;
            } catch (InputMismatchException e) {
                logger.error("Ошибка ввода целого числа");
                System.out.println("Ошибка ввода. Пожалуйста, введите целое число.");
            }
        }
        return result;
    }

    /**
     * Функция, с помощью цикла принимает только double значение.
     *
     * @return double значение
     */
    public static double inputDouble() {
        double result = 0;
        boolean accept = false;
        while (!accept) {
            Scanner scanner = makeScanner();
            try {
                result = scanner.nextDouble();
                accept = true;
            } catch (InputMismatchException e) {
                logger.error("Ошибка ввода double числа");
                System.out.println("Ошибка ввода. Пожалуйста, введите double число.");
            }
        }
        return result;
    }

    /**
     * Функция, которая ждет, пока пользователь введёт photo или video.
     *
     * @return photo/video
     */
    public static String inputShootingMod() {
        String result = "";
        boolean accept = false;
        while (!accept) {
            Scanner scanner = makeScanner();
            result = scanner.nextLine();
            if (Objects.equals(result, MediaFileType.PHOTO) | Objects.equals(result, MediaFileType.VIDEO)) {
                accept = true;
            } else {
                logger.error("Ошибка ввода режима съемки");
                System.out.println("Ошибка ввода. Пожалуйста, введите photo или video.");
            }
        }
        return result;
    }
    public static int isoInputValidation(){
        boolean exit = false;
        int input = 0;
        while (!exit){
            input = inputInt();
            if (0<input && input<10000){
                exit = true;
            }else {
                logger.error("Введено неправильное значение ISO");
                System.out.println("Странное значение, давай более правдоподобное.");
            }
        }
        return input;
    }
    public static double apertureInputValidation(){
        boolean exit = false;
        double input = 0;
        while (!exit){
            input = inputDouble();
            if (1<input && input<=16){
                exit = true;
            }
            else {
                logger.error("Введено неправильное значение диафрагмы");
                System.out.println("Странное значение, давай более правдоподобное.");
            }
        }
        return input;
    }

    /**
     * <b>ВАЖНО! Передаваемый ID на 1 больше, чем индекс массива, т.е. подсчёт камер начинается с 1.</b>
     * Проверяет введенный пользователем ID камеры на существование такого индекса. <br>
     *
     * @param id ID камеры
     * @return true/false
     */
    public static boolean cameraIdCheck(int id) {
        for (Camera camera :
                AllCamerasStorage.getAllCamerasArray()) {
            if (AllCamerasStorage.getAllCamerasArray().size() >= id && camera.getId() == id) {
                return true;
            }
        }
        logger.error("Введен несуществующий ID камеры");
        return false;
    }

}
