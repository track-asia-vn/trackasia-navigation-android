package com.mapbox.services.android.navigation.ui.v5.camera;

import com.trackasia.android.camera.CameraUpdate;
import com.trackasia.android.location.modes.CameraMode;
import com.trackasia.android.maps.TrackasiaMap;

class CameraAnimationDelegate {

  private final TrackasiaMap mapboxMap;

  CameraAnimationDelegate(TrackasiaMap mapboxMap) {
    this.mapboxMap = mapboxMap;
  }

  void render(NavigationCameraUpdate update, int durationMs, TrackasiaMap.CancelableCallback callback) {
    CameraUpdateMode mode = update.getMode();
    CameraUpdate cameraUpdate = update.getCameraUpdate();
    if (mode == CameraUpdateMode.OVERRIDE) {
      mapboxMap.getLocationComponent().setCameraMode(CameraMode.NONE);
      mapboxMap.animateCamera(cameraUpdate, durationMs, callback);
    } else if (!isTracking()) {
      mapboxMap.animateCamera(cameraUpdate, durationMs, callback);
    }
  }

  private boolean isTracking() {
    int cameraMode = mapboxMap.getLocationComponent().getCameraMode();
    return cameraMode != CameraMode.NONE;
  }
}