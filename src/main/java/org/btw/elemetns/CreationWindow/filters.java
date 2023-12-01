package org.btw.elemetns.CreationWindow;

import javafx.scene.control.TextFormatter;

public class filters {
    private static final String REGEX_VALID_INTEGER_TO_ISO = "^([1-9][0-9]{0,2}|1000)$";

    public static TextFormatter.Change filterForISO(TextFormatter.Change change) {
        if (!change.getControlNewText().matches(REGEX_VALID_INTEGER_TO_ISO)) {
            change.setText("");
        }
        return change;
    }
}
