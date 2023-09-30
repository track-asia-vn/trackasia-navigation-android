package com.mapbox.services.android.navigation.ui.v5.map;

import android.graphics.Bitmap;

import com.trackasia.android.maps.MapView;
import com.trackasia.android.maps.TrackasiaMap;

import static com.mapbox.services.android.navigation.ui.v5.map.NavigationSymbolManager.MAPBOX_NAVIGATION_MARKER_NAME;

class SymbolOnStyleLoadedListener implements MapView.OnDidFinishLoadingStyleListener {

  private final TrackasiaMap mapboxMap;
  private final Bitmap markerBitmap;

  SymbolOnStyleLoadedListener(TrackasiaMap mapboxMap, Bitmap markerBitmap) {
    this.mapboxMap = mapboxMap;
    this.markerBitmap = markerBitmap;
  }

  @Override
  public void onDidFinishLoadingStyle() {
    mapboxMap.getStyle().addImage(MAPBOX_NAVIGATION_MARKER_NAME, markerBitmap);
  }
}
