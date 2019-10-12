package com.spritflightapps.memverse

import android.app.Activity
import android.app.Application
import android.os.Bundle
import timber.log.Timber

class MVApplication : Application(), Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) {
        Timber.d("--")
    }

    override fun onActivityStarted(activity: Activity) {
        Timber.d("--")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Timber.d("--")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Timber.d("--")
    }

    override fun onActivityStopped(activity: Activity) {
        Timber.d("--")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Timber.d("--")
    }

    override fun onActivityResumed(activity: Activity) {
        Timber.d("--")
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(LineNumberDebugTree())
        } else {
            // TODO: Plant crashlytics tree.
        }

        this.registerActivityLifecycleCallbacks(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Timber.d("--low")
    }


}


class LineNumberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "(${element.fileName}:${element.lineNumber})#${element.methodName}"
    }
}