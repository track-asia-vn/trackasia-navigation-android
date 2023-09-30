package com.mapbox.services.android.navigation.ui.v5.map;

import android.os.Parcel;
import android.os.Parcelable;

public class NavigationTrackasiaMapInstanceState implements Parcelable {

  private final NavigationMapSettings settings;

  NavigationTrackasiaMapInstanceState(NavigationMapSettings settings) {
    this.settings = settings;
  }

  NavigationMapSettings retrieveSettings() {
    return settings;
  }

  private NavigationTrackasiaMapInstanceState(Parcel in) {
    settings = in.readParcelable(NavigationMapSettings.class.getClassLoader());
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(settings, flags);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<NavigationTrackasiaMapInstanceState> CREATOR =
    new Creator<NavigationTrackasiaMapInstanceState>() {
      @Override
      public NavigationTrackasiaMapInstanceState createFromParcel(Parcel in) {
        return new NavigationTrackasiaMapInstanceState(in);
      }

      @Override
      public NavigationTrackasiaMapInstanceState[] newArray(int size) {
        return new NavigationTrackasiaMapInstanceState[size];
      }
    };
}
