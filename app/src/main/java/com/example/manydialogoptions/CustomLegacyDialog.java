package com.example.manydialogoptions;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class CustomLegacyDialog extends Dialog {

    private EditText etName;
    private Button bOk;

    public interface OnNameEnteredListener {
        void onNameEntered(String name);
    }

    private OnNameEnteredListener listener;

    public CustomLegacyDialog(@NonNull Context context) {
        super(context);
    }

    public CustomLegacyDialog(@NonNull Context context, OnNameEnteredListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_legacy_dialog);

        etName = findViewById(R.id.etName);
        bOk = findViewById(R.id.bOk);

        bOk.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (listener != null) {
                listener.onNameEntered(name);
            }

            dismiss();
        });

        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setGravity(Gravity.CENTER);

            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            window.setAttributes(params);
        }
    }
}