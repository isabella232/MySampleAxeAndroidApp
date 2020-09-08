package com.sandeeppr.mysampleaxeandroidapp;

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
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleAxeTest {
    @Test
    public void runAxeTest() {
        final AxeConf axeConf = new AxeConf();
        MyAxeViewBuilder axeViewBuilder = new MyAxeViewBuilder();
        //axeViewBuilder.viewIdResourceName("id:helloButton");
        axeViewBuilder.viewIdResourceName("android:id/helloButton"); // attempted to link button

        Axe axe = new Axe(axeConf);
        AxeResult axeResult = axe.run(new AxeContext(
                axeViewBuilder.build(),
                new AxeDevice(222, "Pixel XL API 28", "android", 200, 100),
                null,
                null)
        );
        System.out.println("AxeResult Size: "+axeResult.axeRuleResults.size());
        Assert.assertEquals(1, axeResult.axeRuleResults.size());
    }
}