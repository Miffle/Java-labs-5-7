package org.btw.elemetns.mainWindowButtons;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.btw.models.cameras.AllCamerasStorage;
import org.btw.database.DeleteFromDB;
import org.btw.elemetns.Table;
import org.btw.menus_handlers.FromJSONReadHandler;
import org.btw.menus_handlers.JSONSaveHandler;
import org.btw.views.CameraCreationWindow;
import org.btw.views.ChangeCameraWindow;
import org.btw.views.UseCameraWindow;

public class Buttons {

    public final Button add = new Button("Создать камеру");
    public final Button delete = new Button("Удалить камеру");
    public final Button edit = new Button("Изменить камеру");
    public final Button use = new Button("Использовать камеру");
    public final Button saveInJSON = new Button("Сохранить в JSON");
    public final Button loadFromJSON = new Button("Загрузить из JSON");

    public Buttons() {
        addButtonHandler();
        deleteButtonHandler();
        editButtonHandler();
        useButtonHandler();
        jsonButtonHandler();
    }

    private void addButtonHandler() {
        add.setOnAction(e -> new CameraCreationWindow(new Stage()));
    }

    private void deleteButtonHandler() {
        delete.setOnAction(e -> {
            int id = Table.cameraTableView.getSelectionModel().getFocusedIndex();
            new DeleteFromDB((int) Table.cameraTableView.getColumns().get(0).getCellObservableValue(id).getValue());
            AllCamerasStorage.remove(id);
            Table.updateCamerasList();
        });
    }

    private void useButtonHandler() {
        use.setOnAction(e -> new UseCameraWindow(new Stage(), Table.cameraTableView.getSelectionModel().getFocusedIndex()));
    }


    private void editButtonHandler() {
        edit.setOnAction(e -> new ChangeCameraWindow(new Stage(), Table.cameraTableView.getSelectionModel().getFocusedIndex()));
    }
    private void jsonButtonHandler(){
        saveInJSON.setOnAction(e -> new Thread(JSONSaveHandler::new).start());
        loadFromJSON.setOnAction(e-> {FromJSONReadHandler.readFromJSON();
            Table.updateCamerasList();
        });
    }

    public Button getAdd() {
        return add;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getEdit() {
        return edit;
    }

    public Button getUse() {
        return use;
    }

    public Button getSaveInJSON() {
        return saveInJSON;
    }

    public Button getLoadFromJSON() {
        return loadFromJSON;
    }
}
