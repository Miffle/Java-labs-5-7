package menus_handlers;

import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.SlrCamera;
import org.btw.mediafiles.MediaFileType;
import org.btw.menus_handlers.JSONSaveHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JSONSaveHandlerTest {
    @BeforeEach
    void clearArray(){
        AllCamerasStorage.clearAll();
    }
    @Test
    void fileCreation(){
        AllCamerasStorage.add(new SlrCamera(10, MediaFileType.PHOTO, 1000, 5, 1000));
        System.out.println(AllCamerasStorage.getAllCamerasArray());
        JSONSaveHandler.createJSONFile();
        File f = new File("result.json");
        assert(f.exists());
    }
}
