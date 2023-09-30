package com.mapbox.services.android.navigation.ui.v5.camera;

import com.trackasia.android.camera.CameraUpdate;
import com.trackasia.android.maps.TrackasiaMap;

class CameraOverviewCancelableCallback implements TrackasiaMap.CancelableCallback {

  private static final int OVERVIEW_UPDATE_DURATION_IN_MILLIS = 750;

  private CameraUpdate overviewUpdate;
  private TrackasiaMap mapboxMap;

  CameraOverviewCancelableCallback(CameraUpdate overviewUpdate, TrackasiaMap mapboxMap) {
    this.overviewUpdate = overviewUpdate;
    this.mapboxMap = mapboxMap;
  }

  @Override
  public void onCancel() {
    // No-op
  }

  @Override
  public void onFinish() {
    mapboxMap.animateCamera(overviewUpdate, OVERVIEW_UPDATE_DURATION_IN_MILLIS);
  }
}
