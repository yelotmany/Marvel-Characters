package com.yelotmany.marvelcharacters

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.runner.AndroidJUnit4
import com.yelotmany.marvelcharacters.features.model.repository.impl.CharactersRepositoryImpl
import com.yelotmany.marvelcharacters.features.view.activities.CharactersListActivity

@RunWith(AndroidJUnit4::class)
@LargeTest
class CharactersListTest {

    @get:Rule
    val mActivityTestRule: ActivityTestRule<CharactersListActivity> = ActivityTestRule(
        CharactersListActivity::class.java)

    @Test
    fun toolbar_name_test() {
        // Type text and then press the button.
        onView(withId(R.id.toolbar_title))
            .check(matches(withText("MARVEL")))
    }

    //TODO: update test
    @Test
    fun recycler_view_elements_test() {
        // Type text and then press the button.
        onView(withId(R.id.fragment_characters_list_recycler_view))
            .perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3//CharactersRepositoryImpl.getInstance().getCharactersList().size - 1
            ))
    }
}