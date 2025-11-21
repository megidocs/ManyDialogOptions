package com.example.manydialogoptions;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogInDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        builder.setTitle("AlertDialog in DialogFragment")
                .setMessage("This is an AlertDialog built inside a DialogFragment.")
                .setPositiveButton("OK", (dialog, which) -> dismiss());

        AlertDialog dialog = builder.create();

        dialog.setOnShowListener(dialogInterface -> {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2E7D32")));
                // Color.RED
                // Color.parseColor("#FF5722")
                // Color.argb(230, 30, 30, 30)
            }

            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            if (positiveButton != null) {
                positiveButton.setTextColor(Color.WHITE);
                positiveButton.setAllCaps(false);
            }
        });

        return dialog;
    }
}
