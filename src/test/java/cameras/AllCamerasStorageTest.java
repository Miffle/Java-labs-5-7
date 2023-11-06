package cameras;

import org.apache.log4j.PropertyConfigurator;
import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.cameras.SlrCamera;
import org.junit.jupiter.api.*;

import java.util.List;

public class AllCamerasStorageTest {
    private final Camera testCamera = new SlrCamera(2.8, "video", 1000);
    @BeforeEach
    void addOneCameraInArray(){
        for (int i = 0; i < AllCamerasStorage.getAllCamerasArray().size(); i++) {
            AllCamerasStorage.remove(i);
        }
        AllCamerasStorage.add(testCamera);
    }
    @Test
    void add(){
        AllCamerasStorage.add(testCamera);
        int allCamerasCount = AllCamerasStorage.getAllCamerasArray().size();
        Assertions.assertEquals(2, allCamerasCount);
    }
    @Test
    void remove() {
        AllCamerasStorage.remove(0);
        int allCamerasCount = AllCamerasStorage.getAllCamerasArray().size();
        Assertions.assertEquals(0, allCamerasCount);
    }
    @Test
    void get_throwIndexOutException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> AllCamerasStorage.get(2));
    }
}
