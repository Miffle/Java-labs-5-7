package org.btw;

import javafx.application.Application;
import javafx.stage.Stage;
import org.btw.database.ReadFromDB;
import org.btw.views.MainWindow;

public class Main extends Application {
    public static void main(String[] args) {
        new ReadFromDB();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        new MainWindow(stage);
    }

}