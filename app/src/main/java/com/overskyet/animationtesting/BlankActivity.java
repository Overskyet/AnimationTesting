package com.overskyet.animationtesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        SlidingPaneLayout slidingPaneLayout = findViewById(R.id.sliding_pane);
        slidingPaneLayout.openPane();

        FrameLayout frameLayout = findViewById(R.id.bottomSheet_frame_layout);
//        BottomSheetBehavior.from(frameLayout).setHideable(true);
        BottomSheetBehavior.from(frameLayout).setPeekHeight(50);
        BottomSheetBehavior.from(frameLayout).setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_out, R.anim.slide_in_down);
    }
}