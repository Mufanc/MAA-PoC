package android.hardware.display;

import java.util.concurrent.Executor;

public class DisplayManagerGlobal {
    public static final class VirtualDisplayCallback extends IVirtualDisplayCallback.Stub {
        public VirtualDisplayCallback(VirtualDisplay.Callback callback, Executor executor) {
            throw new RuntimeException("STUB");
        }
    }
}
