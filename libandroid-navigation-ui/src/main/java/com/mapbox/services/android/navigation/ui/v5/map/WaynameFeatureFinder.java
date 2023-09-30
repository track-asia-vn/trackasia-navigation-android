package com.mapbox.services.android.navigation.ui.v5.map;

import android.graphics.PointF;

import com.mapbox.geojson.Feature;
import com.trackasia.android.maps.TrackasiaMap;

import java.util.List;

class WaynameFeatureFinder {

  private TrackasiaMap mapboxMap;

  WaynameFeatureFinder(TrackasiaMap mapboxMap) {
    this.mapboxMap = mapboxMap;
  }

  List<Feature> queryRenderedFeatures(PointF point, String[] layerIds) {
    return mapboxMap.queryRenderedFeatures(point, layerIds);
  }
}
