package com.mapbox.services.android.navigation.ui.v5;

import com.trackasia.android.Trackasia;

class MapConnectivityController {

  void assign(Boolean state) {
    Trackasia.setConnected(state);
  }
}
