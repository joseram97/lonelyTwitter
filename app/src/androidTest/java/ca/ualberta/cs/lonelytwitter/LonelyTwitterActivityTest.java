package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    @Override
    public void setUp() {
        // this is for all the testing
        // created a solo instance, and passed 2 parameters that are within the SOLO construct
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() {
        solo.finishOpenedActivities();
    }

    // not all test methods that require testing MUST have the word "test" in the beginning
    public void testTweet() {
        solo.assertCurrentActivity("wrong activity", "LonelyTwitterActivity");
    }

    public void testEqual() {
        assertEquals("not equal", "5", "6");
    }

    public void testAddTweet() {
        solo.enterText((EditText) solo.getView(R.id.body), "new thing");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("new thing"));
    }

}