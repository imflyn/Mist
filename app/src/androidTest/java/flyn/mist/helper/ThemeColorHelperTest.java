package flyn.mist.helper;

import android.graphics.Color;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import flyn.mist.R;

@RunWith(AndroidJUnit4.class)
public class ThemeColorHelperTest {

    private ThemeColorHelper themeColorHelper;

    @Before
    public void setUp() {
        themeColorHelper = ThemeColorHelper.Companion.getInstance();
    }

    @Test
    public void getThemeColor() {
        assert themeColorHelper.getThemeColor() == R.color.colorAccent;
    }

    @Test
    public void switchThemeColor() {
        themeColorHelper.switchThemeColor(Color.RED);
        assert themeColorHelper.getThemeColorFromSP() == Color.RED;
        assert themeColorHelper.getThemeColor() == Color.RED;
    }

}
