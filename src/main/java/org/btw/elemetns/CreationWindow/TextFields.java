package org.btw.elemetns.CreationWindow;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class TextFields {
    public TextField inputISO = new TextField("1");
    public TextField inputAperture = new TextField("1");
    public TextField inputZoom = new TextField("1");
    public TextField inputStorage = new TextField("1");
    public TextFields(){
        setInputMaxWidth(inputISO);
        makeOnlyInt(inputISO);
        makePrettyInput(inputAperture);
        makePrettyInput(inputZoom);
        makePrettyInput(inputStorage);
        addFilter();
    }

    private void makePrettyInput(TextField textField){
        setInputMaxWidth(textField);
        makeOnlyDouble(textField);
    }
    private void addFilter(){
        inputISO.setTextFormatter(new TextFormatter<>(filters::filterForISO));
    }
    private void setInputMaxWidth(TextField textField) {
        textField.setMaxWidth(100);
    }
    private void makeOnlyInt(TextField textField) {
        textField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d")) {
                textField.setText(t1.replaceAll("\\D",""));
            }
            if (t1.isEmpty()) {
                textField.setText(String.valueOf(1));
            }
        });
    }
    private void makeOnlyDouble(TextField textField) {
        textField.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*\\.?\\d*")) {
                textField.setText(t1.replaceAll("[^\\d.]",""));
            }
            if (t1.isEmpty()) {
                textField.setText(String.valueOf(1));
            }
        });
    }

    public void setInputISO(String inputISO) {
        this.inputISO.setText(inputISO);
    }

    public void setInputAperture(String inputAperture) {
        this.inputAperture.setText(inputAperture);
    }

    public void setInputZoom(String inputZoom) {
        this.inputZoom.setText(inputZoom);
    }

    public void setInputStorage(String inputStorage) {
        this.inputStorage.setText(inputStorage);
    }
}
