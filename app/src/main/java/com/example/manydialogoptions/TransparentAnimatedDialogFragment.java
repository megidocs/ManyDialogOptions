package com.example.manydialogoptions;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TransparentAnimatedDialogFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_AllVersionsOfDialogs_TransparentAnimatedDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_custom, container, false);

        // Set click listeners for all buttons to dismiss the dialog
        view.findViewById(R.id.bSendSMS).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.bSendEmail).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.bCall).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.bUpdate).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.bDelete).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.bCancel).setOnClickListener(v -> dismiss());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                // Ensure the animation is applied
                window.setWindowAnimations(R.style.DialogAnimation);
            }
        }
    }
}
