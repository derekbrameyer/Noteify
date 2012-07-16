package com.doomonafireball.noteify.activity;

import com.doomonafireball.noteify.R;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;

import android.os.Bundle;
import android.util.Log;

/**
 * User: derek Date: 7/15/12 Time: 8:31 AM
 */
public class MainActivity extends RoboSherlockFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
