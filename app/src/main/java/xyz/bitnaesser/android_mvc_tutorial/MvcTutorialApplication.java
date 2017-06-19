package xyz.bitnaesser.android_mvc_tutorial;

import android.app.Application;

import xyz.bitnaesser.android_mvc_tutorial.common.BackgroundThreadPoster;
import xyz.bitnaesser.android_mvc_tutorial.common.MainThreadPoster;

/**
 * Our custom {@link Application}
 */
public class MvcTutorialApplication extends Application {

    private final MainThreadPoster mMainThreadPoster = new MainThreadPoster();
    private final BackgroundThreadPoster mBackgroundThreadPoster = new BackgroundThreadPoster();

    public MainThreadPoster getMainThreadPoster() {
        return mMainThreadPoster;
    }

    public BackgroundThreadPoster getBackgroundThreadPoster() {
        return mBackgroundThreadPoster;
    }
}
