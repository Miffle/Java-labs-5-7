package cameras;

import org.btw.cameras.*;
import org.btw.mediafiles.MediaFileType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CameraTest {
    @BeforeEach
    void clearArray(){
        AllCamerasStorage.clearAll();
    }
    @Test
    void SlrCameraCreation(){
        Camera slrTestCamera = new SlrCamera(10, MediaFileType.PHOTO, 1000, 5, 1000);
        AllCamerasStorage.add(slrTestCamera);
        Assertions.assertEquals(AllCamerasStorage.get(0), slrTestCamera);
    }
    @Test
    void WebCameraCreation(){
        Camera webTestCamera = new WebCamera(10, MediaFileType.PHOTO, 1000, "A");
        AllCamerasStorage.add(webTestCamera);
        Assertions.assertEquals(AllCamerasStorage.get(0), webTestCamera);
    }
    @Test
    void PhoneCameraCreation(){
        Camera phoneTestCamera = new PhoneCamera(10, MediaFileType.VIDEO, 1000, 5, "Iphone");
        AllCamerasStorage.add(phoneTestCamera);
        Assertions.assertEquals(AllCamerasStorage.get(0), phoneTestCamera);
    }
}
