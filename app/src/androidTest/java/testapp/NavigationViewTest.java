package testapp;

import com.mapbox.services.android.navigation.testapp.test.TestNavigationActivity;
import com.mapbox.services.android.navigation.ui.v5.map.NavigationTrackasiaMap;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;

import org.junit.Test;

import testapp.activity.BaseNavigationActivityTest;

import static junit.framework.Assert.assertNotNull;

public class NavigationViewTest extends BaseNavigationActivityTest {

  @Override
  protected Class getActivityClass() {
    return TestNavigationActivity.class;
  }

  @Test
  public void onInitialization_navigationTrackasiaMapIsNotNull() {
    validateTestSetup();

    NavigationTrackasiaMap navigationTrackasiaMap = getNavigationView().retrieveNavigationTrackasiaMap();

    assertNotNull(navigationTrackasiaMap);
  }

  @Test
  public void onNavigationStart_mapboxNavigationIsNotNull() {
    validateTestSetup();

    MapboxNavigation mapboxNavigation = getNavigationView().retrieveMapboxNavigation();

    assertNotNull(mapboxNavigation);
  }
}
