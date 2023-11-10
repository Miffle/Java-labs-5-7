package org.btw.menus;

import org.btw.menus_handlers.CameraFunctionsHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuOption {
    public String optionName;
    private final Runnable func;
    private static final Logger logger = LoggerFactory.getLogger(CameraFunctionsHandler.class);

    public MenuOption(String optionName, Runnable func) {
        this.optionName = optionName;
        this.func = func;
    }
    public MenuOption(String optionName) {
        this.optionName = optionName;
        this.func = ()-> System.out.println("ок");
    }

    protected void runFunction()
    {
        logger.info("Выбрана функция " + optionName);
        func.run();
    }

    @Override
    public String toString() {
        return optionName;
    }
}
