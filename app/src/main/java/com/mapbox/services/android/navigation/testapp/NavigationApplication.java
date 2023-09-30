package com.mapbox.services.android.navigation.testapp;

import android.app.Application;

import com.trackasia.android.BuildConfig;
import com.trackasia.android.Trackasia;

import timber.log.Timber;

public class NavigationApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    Trackasia.getInstance(getApplicationContext());
  }

}
