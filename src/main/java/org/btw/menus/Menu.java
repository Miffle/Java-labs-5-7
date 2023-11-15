package org.btw.menus;

import org.btw.menus_handlers.CameraFunctionsHandler;
import org.btw.menus_handlers.InputValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<MenuOption> options = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(CameraFunctionsHandler.class);

    public boolean optionChoice() {
        int optionsCount = options.size() - 1;
        while (true) {
            this.showMenu();
            System.out.println("Выбери пункт, который тебя интересует.");
            int userChoice = InputValidation.inputInt();
            if (userChoice < 0 || userChoice > optionsCount) {
                indexOutOfBounds();
            } else if (userChoice == optionsCount) {
                exitOption();
                return true;
            } else {
                runChosenOption(userChoice);
            }
        }
    }

    private void indexOutOfBounds() {
        logger.error("Неправильно введено число при выборе действия в меню.");
        System.out.println("Ладно, ещё попытка.");
    }

    private void exitOption() {
        logger.info("Выход из " + getClass().getSimpleName());
    }

    private void runChosenOption(int userChoice) {
        this.options.get(userChoice).runFunction();
    }

    public void showMenu() {
        for (MenuOption option :
                options) {
            System.out.println(options.indexOf(option) + ") " + option.optionName);
        }
    }
}
