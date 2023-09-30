package com.mapbox.services.android.navigation.ui.v5.map;

import com.trackasia.android.maps.TrackasiaMap;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MapPaddingAdjustorTest {

  @Test
  public void adjustLocationIconWith_customPaddingIsSet() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};
    int[] customPadding = {0, 0, 0, 0};
    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);

    paddingAdjustor.adjustLocationIconWith(customPadding);

    verify(mapboxMap).setPadding(0, 0, 0, 0);
  }

  @Test
  public void isUsingDefault_falseAfterCustomPaddingIsSet() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};
    int[] customPadding = {0, 0, 0, 0};
    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);

    paddingAdjustor.adjustLocationIconWith(customPadding);

    assertFalse(paddingAdjustor.isUsingDefault());
  }

  @Test
  public void isUsingDefault_trueWithoutCustomPadding() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};

    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);

    assertTrue(paddingAdjustor.isUsingDefault());
  }

  @Test
  public void updatePaddingWithZero_updatesMapToZeroPadding() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};
    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);

    paddingAdjustor.updatePaddingWith(new int[]{0, 0, 0, 0});

    verify(mapboxMap).setPadding(0, 0, 0, 0);
  }

  @Test
  public void updatePaddingWithZero_retainsCustomPadding() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};
    int[] customPadding = {0, 350, 0, 0};
    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);
    paddingAdjustor.adjustLocationIconWith(customPadding);
    paddingAdjustor.updatePaddingWith(new int[]{0, 0, 0, 0});

    paddingAdjustor.resetPadding();

    verify(mapboxMap, times(2)).setPadding(0, 350, 0, 0);
  }

  @Test
  public void updatePaddingWithDefault_defaultIsRestoredAfterCustom() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};
    int[] customPadding = {0, 0, 0, 0};
    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);
    paddingAdjustor.adjustLocationIconWith(customPadding);

    paddingAdjustor.updatePaddingWithDefault();

    verify(mapboxMap).setPadding(0, 250, 0, 0);
  }

  @Test
  public void retrieveCurrentPadding_returnsCurrentMapPadding() {
    TrackasiaMap mapboxMap = mock(TrackasiaMap.class);
    int[] defaultPadding = {0, 250, 0, 0};
    MapPaddingAdjustor paddingAdjustor = new MapPaddingAdjustor(mapboxMap, defaultPadding);

    paddingAdjustor.retrieveCurrentPadding();

    verify(mapboxMap).getPadding();
  }
}