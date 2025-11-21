package com.example.manydialogoptions;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class PersistentBottomSheetActivity extends AppCompatActivity {

    private BottomSheetBehavior<FrameLayout> bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent_bottom_sheet);

        FrameLayout bottomSheet = findViewById(R.id.persistent_bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        findViewById(R.id.expandButton).setOnClickListener(v -> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED));
        findViewById(R.id.collapseButton).setOnClickListener(v -> bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));
    }
}
