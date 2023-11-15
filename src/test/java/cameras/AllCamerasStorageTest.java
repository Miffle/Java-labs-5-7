package cameras;

import org.btw.cameras.AllCamerasStorage;
import org.btw.cameras.Camera;
import org.btw.cameras.SlrCamera;
import org.btw.mediafiles.MediaFileType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AllCamerasStorageTest {
    private final Camera testCamera = new SlrCamera(2.8, MediaFileType.VIDEO, 1000, 5, 100);

    @BeforeEach
    void addOneCameraInArray() {
        AllCamerasStorage.clearAll();
        AllCamerasStorage.add(testCamera);
    }

    @Test
    void add() {
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
