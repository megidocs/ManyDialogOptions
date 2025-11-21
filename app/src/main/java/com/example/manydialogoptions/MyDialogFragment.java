package com.example.manydialogoptions;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*return new MaterialAlertDialogBuilder(requireActivity())
                .setTitle("DialogFragment")
                .setMessage("This is a DialogFragment.")
                .setIcon(R.drawable.ic_zefra)
                .setPositiveButton("OK", (d, w) -> dismiss())
                .setNegativeButton("Cancel", (d, w) -> dismiss())
                .create();

           return dialog
           */

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());

        builder.setTitle("Completed!")
                .setMessage("Your action was successful. ✓")
                .setIcon(R.drawable.ic_success)
                .setPositiveButton("It's clear", (d, w) -> dismiss())
                .setNegativeButton("Cancel", (d, w) -> dismiss())
                .setNeutralButton("Later", (d, w) -> dismiss())
                .setCancelable(false);


        AlertDialog dialog = builder.create();

        dialog.setOnShowListener(dialogInterface -> {
            // Заголовок белый
            TextView titleView = dialog.findViewById(com.google.android.material.R.id.alertTitle);
            if (titleView != null) {
                titleView.setTextColor(Color.WHITE);
            }

            // Сообщение белый
            TextView messageView = dialog.findViewById(android.R.id.message);
            if (messageView != null) {
                messageView.setTextColor(Color.WHITE);
            }

            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.WHITE);
        });

        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.argb(200, 0, 0, 0))); // тёмный полупрозрачный
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.setGravity(Gravity.CENTER);

            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(params);
        }

        return dialog;
    }
}
