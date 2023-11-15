package menus_handlers;

import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.cameras.SlrCamera;
import org.btw.mediafiles.MediaFileType;
import org.btw.menus_handlers.FromJSONReadHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FromJSONReadHandlerTest {
    @BeforeEach
    void clearArray(){
        AllCamerasStorage.clearAll();
    }

    @Test
    void readFile(){
        Camera camera = new SlrCamera(10, MediaFileType.PHOTO, 1000, 5, 1000);
        AllCamerasStorage.add(camera);
        FromJSONReadHandler.readFromJSON();
        Assertions.assertEquals(camera.toString(), AllCamerasStorage.get(0).toString());
    }
    @Test
    void readNotExistedFile(){
        Camera camera = new SlrCamera(10, MediaFileType.PHOTO, 1000, 5, 1000);
        AllCamerasStorage.add(camera);
        File f = new File("result.json");
        if(f.exists()){
            f.delete();
        }
        FromJSONReadHandler.readFromJSON();
        Assertions.assertEquals(camera.toString(), AllCamerasStorage.get(0).toString());
    }
}
