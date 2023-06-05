package android.hardware.display;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IVirtualDisplayCallback extends IInterface {
    abstract class Stub extends Binder implements IVirtualDisplayCallback {
        public IBinder asBinder() {
            throw new RuntimeException("STUB");
        }
    }
}
