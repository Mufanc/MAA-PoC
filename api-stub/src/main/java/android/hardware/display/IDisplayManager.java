package android.hardware.display;

import android.media.projection.IMediaProjection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IDisplayManager extends IInterface {
    int createVirtualDisplay(VirtualDisplayConfig config, IVirtualDisplayCallback callback, IMediaProjection projection, String packageName);

    int[] getDisplayIds(boolean includeDisabled);

    abstract class Stub extends Binder implements IDisplayManager {
        public static IDisplayManager asInterface(IBinder binder) {
            throw new RuntimeException("STUB");
        }
    }
}
