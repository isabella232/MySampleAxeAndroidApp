package com.sandeeppr.mysampleaxeandroidapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.deque.axe.android.Axe;
import com.deque.axe.android.AxeConf;
import com.deque.axe.android.AxeContext;
import com.deque.axe.android.AxeDevice;
import com.deque.axe.android.AxeResult;
import com.sandeeppr.mysampleaxeandroidapp.axeutils.MyAxeViewBuilder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedAxeTest {
    @Test
    public void runAxeTest() {
        final AxeConf axeConf = new AxeConf();
        MyAxeViewBuilder axeViewBuilder = new MyAxeViewBuilder();
        //axeViewBuilder.viewIdResourceName("id:helloButton");
        axeViewBuilder.viewIdResourceName("android:id/helloButton");

        Axe axe = new Axe(axeConf);
        AxeResult axeResult = axe.run(new AxeContext(
                axeViewBuilder.build(),
                new AxeDevice(222, "Pixel XL API 28", "android", 200, 100),
                null,
                null)
        );

        //Assert.assertTrue(axeResult.axeRuleResults.size() == 0);
        Assert.assertTrue(axeResult.axeRuleResults.size() > 0);
    }
}
