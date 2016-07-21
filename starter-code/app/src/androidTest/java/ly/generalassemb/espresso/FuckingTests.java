package ly.generalassemb.espresso;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Qube on 7/21/16.
 */
@RunWith(AndroidJUnit4.class)
public class FuckingTests {

    @Rule
    public ActivityTestRule<BalanceActivity> mainActivityActivityTestRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void testCheckBalance() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testWithdraw() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Hes an elite"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("1337"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("-$1,337.00")));
    }

    @Test
    public void testDeposit() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("It's over 9000!"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("9001"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$9,001.00")));
    }

    @Test
    public void testMultipleTest() throws Exception {
        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("BAM MONEY~!"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("20"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$20.00")));

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Banking it!"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("20"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$40.00")));

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Them bills..."), closeSoftKeyboard());
        onView(withId(R.id.amountEditText))
                .perform(typeText("40"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$0.00")));
    }
}
