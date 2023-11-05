package org.btw.menus;

import org.btw.cameras.Camera;
import org.btw.mediafiles.AllCamerasStorage;
import org.btw.mediafiles.MediaFileType;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InputValidation {
    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

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
            if (Objects.equals(result, MediaFileType.getPHOTO()) | Objects.equals(result, MediaFileType.getVIDEO())) {
                accept = true;
            } else {
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
            if (0<input && input<1000){
                exit = true;
            }else System.out.println("Странное значение, давай более правдоподобное.");
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
            else System.out.println("Странное значение, давай более правдоподобное.");
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
        return false;
    }

}
