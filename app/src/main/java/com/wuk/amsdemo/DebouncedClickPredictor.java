package com.wuk.amsdemo;

import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wuk
 * @date 2022/7/27
 */
public class DebouncedClickPredictor {

    public static long FROZEN_WINDOW_MILLIS = 300L;

    private static final String TAG = DebouncedClickPredictor.class.getSimpleName();

    private static final Map<View, FrozenView> viewWeakHashMap = new WeakHashMap<>();

    public static boolean shouldDoClick(View targetView) {

        FrozenView frozenView = viewWeakHashMap.get(targetView);
        final long now = now();

        if (frozenView == null) {
            frozenView = new FrozenView(targetView);
            frozenView.setFrozenWindow(now + FROZEN_WINDOW_MILLIS);
            viewWeakHashMap.put(targetView, frozenView);
            return true;
        }

        if (now >= frozenView.getFrozenWindowTime()) {
            frozenView.setFrozenWindow(now + FROZEN_WINDOW_MILLIS);
            return true;
        }

        return false;
    }

    private static long now() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    private static class FrozenView extends WeakReference<View> {
        private long FrozenWindowTime;

        FrozenView(View referent) {
            super(referent);
        }

        long getFrozenWindowTime() {
            return FrozenWindowTime;
        }

        void setFrozenWindow(long expirationTime) {
            this.FrozenWindowTime = expirationTime;
        }
    }
}
