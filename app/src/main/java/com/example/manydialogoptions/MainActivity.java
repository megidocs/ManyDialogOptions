package com.example.manydialogoptions;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button //----  classic AlertDialog
            classicAlertDialogButton,
            //----custom AlertDialog
            customAlertDialogButton,
            // ----single Choice AlertDialog
            singleChoiceAlertDialogButton,
            //----radio Buttons AlertDialog
            radioButtonsAlertDialogButton,
            //----multiChoice AlertDialog
            multiChoiceAlertDialogButton,
            //----custom Legacy Dialog
            customLegacyDialogButton,
            //----dialog Fragment
            dialogFragmentButton,
            //----alertDialog In DialogFragment
            alertDialogInDialogFragmentButton,
            //----fullscreen DialogFragment
            fullscreenDialogFragmentButton,
            //----transparent Animated Dialog
            transparentAnimatedDialogButton,
            //----datePicker Dialog
            datePickerDialogButton,
            //----datePicker Dialog Spinner
            datePickerDialogSpinnerButton,
            //----datePicker Dialog Spinner
            datePickerDialogCalendarButton,
            //----timePicker Dialog24h
            timePickerDialog24hButton,
            //----timePicker Dialog12h
            timePickerDialog12hButton,
            //----dateRange Picker
            dateRangePickerButton,
            //----materialDate Picker
            materialDatePickerButton,
            //----materialTime Picker
            materialTimePickerButton,
            //----materialAlert Dialog
            materialAlertDialogButton,
            //----materialSingleChoice Dialog
            materialSingleChoiceDialogButton,
            //----materialMultiChoice Dialog
            materialMultiChoiceDialogButton,
            //----materialList Dialog
            materialListDialogButton,
            //----materialCustom Content
            materialCustomContentButton,
            //----bottomSheet Dialog
            bottomSheetDialogButton,
            //----bottomSheet DialogFragment
            bottomSheetDialogFragmentButton,
            //----modal NonDismissible BottomSheet
            modalNonDismissibleBottomSheetButton,
            //----persistent BottomSheet Activity
            persistentBottomSheetActivityButton,
            //----popupWindow
            popupWindowButton,
            //----popupMenu
            popupMenuButton,
            //----dropdownMenu Activity
            dropdownMenuActivityButton,
            //----toast
            toastButton,
            //----customToast
            customToastButton,
            //----snackbar
            snackbarButton,
            //----snackbar With Action
            snackbarWithActionButton,
            //----progress DialogB
            progressDialogButton,
            //----circular Progress Dialog
            circularProgressDialogButton,
            //----horizontal Progress Dialog
            horizontalProgressDialogButton,
            //----custom Animated Dialog
            customAnimatedDialogButton,
            //----spotlight Dialog
            spotlightDialogButton,
            //----topRounded Dialog
            topRoundedDialogButton;




    private int selectedItem = 0;
    private ArrayList<Integer> selectedItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniComponenntsAndListeners();


    }



    //-------------------
    private void showClassicAlertDialog() {
            new AlertDialog.Builder(this)
                    .setTitle("Classic Alert Dialog")
                    .setMessage("This is a classic AlertDialog from the old builder.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .setNeutralButton("Later", (dialog, which) -> dialog.dismiss())
                    .show();
        }
    private void showCustomAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(dialogView).create();
        Button bCancel = dialogView.findViewById(R.id.bCancel);
        bCancel.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
    private void showSingleChoiceAlertDialog() {
        final String[] items = {"Praha", "Brno", "Ostrava","Olomouc"};
        selectedItem = 0;
        TextView selectionText = new TextView(this);
        selectionText.setText("Selected: " + items[selectedItem]);
        selectionText.setPadding(50, 40, 50, 40);
        selectionText.setTextSize(18);
        selectionText.setGravity(Gravity.CENTER);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Single Choice Dialog")
                .setSingleChoiceItems(items, selectedItem, (d, which) -> {
                    selectedItem = which;
                    // Обновляем текст сразу при выборе
                    selectionText.setText("Selected: " + items[which]);
                })
                // Добавляем наш TextView как кастомную view
                .setView(selectionText)

                .setPositiveButton("OK", (d, which) -> {
                    Toast.makeText(this, "Selected as final: " + items[selectedItem], Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .create();

        dialog.show();
    }
    private void showRadioButtonsAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_radio_buttons, null);
        RadioGroup radioGroup = dialogView.findViewById(R.id.radioGroup);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Radio Buttons Dialog")
                .setView(dialogView)
                .setPositiveButton("OK", (d, which) -> {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    if (selectedId != -1) {
                        RadioButton rb = dialogView.findViewById(selectedId);
                        Toast.makeText(this, "Selected sa final: " + rb.getText(), Toast.LENGTH_LONG).show();
                    }
                    d.dismiss();
                })
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .create();
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) { // -1
                RadioButton selectedRadioButton = dialogView.findViewById(checkedId);
                Toast.makeText(this,
                        "Selected: " + selectedRadioButton.getText(),
                        Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();
    }
    private void showMultiChoiceAlertDialog() {
        final String[] items = {"Ford", "Opel", "Toyota"};
        final boolean[] checkedItems = {false, false, false};
        selectedItems.clear();

        new AlertDialog.Builder(this)
                .setTitle("Multi Choice Dialog")
                .setIcon(android.R.drawable.ic_dialog_alert)
                //.setMessage("You can see your choices in the Toast after clicking OK")
                .setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
                    if (isChecked) {
                        selectedItems.add(which);
                    } else {
                        selectedItems.remove(Integer.valueOf(which));
                    }
                })
                .setPositiveButton("OK", (dialog, which) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < selectedItems.size(); i++) {
                        sb.append(items[selectedItems.get(i)]);
                        if (i != selectedItems.size() - 1) {
                            sb.append(", ");
                        }
                    }
                    Toast.makeText(MainActivity.this, "Selected: " + sb.toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }
    private void showCustomLegacyDialog() {
        CustomLegacyDialog dialog = new CustomLegacyDialog(this, name -> {
            if (!name.isEmpty()) {
                Toast.makeText(this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    private void showDialogFragment() {
        new MyDialogFragment().show(getSupportFragmentManager(), "my_dialog_fragment");
    }
    private void showAlertDialogInDialogFragment() {
        new AlertDialogInDialogFragment().show(getSupportFragmentManager(), "alert_dialog_in_dialog_fragment");
    }
    private void showFullScreenDialogFragment() {
        new FullScreenDialogFragment().show(getSupportFragmentManager(), "fullscreen_dialog_fragment");
    }
    private void showTransparentAnimatedDialogFragment() {
        new TransparentAnimatedDialogFragment().show(getSupportFragmentManager(), "transparent_animated_dialog_fragment");
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showDatePickerDialogSpinner() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                (view, year, month, dayOfMonth) -> {
                    String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                    Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.show();
    }
    private void showDatePickerDialogCalendar() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(MainActivity.this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setSpinnersShown(false);
        datePickerDialog.getDatePicker().setCalendarViewShown(true);
        datePickerDialog.show();
    }
    private void showTimePickerDialog24h() {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            String time = hourOfDay + ":" + minute;
            Toast.makeText(MainActivity.this, "Selected time: " + time, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
    }

    private void showTimePickerDialog12h() {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            String time = hourOfDay + ":" + minute;
            Toast.makeText(MainActivity.this, "Selected time: " + time, Toast.LENGTH_SHORT).show();
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
    }
    private void showDateRangePicker() {
        MaterialDatePicker<Pair<Long, Long>> picker = MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select a date range")
                .build();
        picker.show(getSupportFragmentManager(), picker.toString());
        picker.addOnPositiveButtonClickListener(selection -> Toast.makeText(MainActivity.this, "Selected range: " + selection.first + " - " + selection.second, Toast.LENGTH_LONG).show());
    }

    private void showMaterialDatePicker() {
        MaterialDatePicker<Long> picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select a date")
                .build();
        picker.show(getSupportFragmentManager(), picker.toString());
        picker.addOnPositiveButtonClickListener(selection -> Toast.makeText(MainActivity.this, "Selected date: " + picker.getHeaderText(), Toast.LENGTH_LONG).show());
    }

    private void showMaterialTimePicker() {
        MaterialTimePicker picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select time")
                .build();
        picker.show(getSupportFragmentManager(), picker.toString());
        picker.addOnPositiveButtonClickListener(v -> Toast.makeText(MainActivity.this, "Selected time: " + picker.getHour() + ":" + picker.getMinute(), Toast.LENGTH_SHORT).show());
    }

    private void showMaterialAlertDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Alert Dialog")
                .setMessage("This is a dialog built with MaterialAlertDialogBuilder.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showMaterialSingleChoiceDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        selectedItem = 0;
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Single Choice")
                .setSingleChoiceItems(items, selectedItem, (dialog, which) -> selectedItem = which)
                .setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Selected: " + items[selectedItem], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showMaterialMultiChoiceDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        final boolean[] checkedItems = {false, false, false};
        selectedItems.clear();
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Multi Choice")
                .setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
                    if (isChecked) {
                        selectedItems.add(which);
                    } else {
                        selectedItems.remove(Integer.valueOf(which));
                    }
                })
                .setPositiveButton("OK", (dialog, which) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < selectedItems.size(); i++) {
                        sb.append(items[selectedItems.get(i)]);
                        if (i != selectedItems.size() - 1) {
                            sb.append(", ");
                        }
                    }
                    Toast.makeText(MainActivity.this, "Selected: " + sb.toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showMaterialListDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material List")
                .setItems(items, (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Selected: " + items[which], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .show();
    }

    private void showMaterialCustomContentDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
        new MaterialAlertDialogBuilder(this)
                .setTitle("Material Custom Content")
                .setView(dialogView)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetView.findViewById(R.id.closeButton).setOnClickListener(v -> bottomSheetDialog.dismiss());
        bottomSheetDialog.show();
    }

    private void showBottomSheetDialogFragment() {
        BottomSheetDialogFragment bottomSheetDialogFragment = new MyBottomSheetDialogFragment();
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }

    private void showModalNonDismissibleBottomSheet() {
        ModalNonDismissibleBottomSheet bottomSheet = new ModalNonDismissibleBottomSheet();
        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
    }

    private void openPersistentBottomSheetActivity() {
        Intent intent = new Intent(this, PersistentBottomSheetActivity.class);
        startActivity(intent);
    }

    private void showPopupWindow(View anchor) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAsDropDown(anchor);
    }

    private void showPopupMenu(View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Selected: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        });

        popup.show();
    }

    private void openDropdownMenuActivity() {
        Intent intent = new Intent(this, DropdownMenuActivity.class);
        startActivity(intent);
    }

    private void showToast() {
        Toast.makeText(this, "This is a simple Toast!", Toast.LENGTH_SHORT).show();
    }

    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    private void showSnackbar(View view) {
        Snackbar.make(view, "This is a simple Snackbar", Snackbar.LENGTH_LONG).show();
    }

    private void showSnackbarWithAction(View view) {
        Snackbar.make(view, "Snackbar with action", Snackbar.LENGTH_INDEFINITE)
                .setAction("UNDO", v -> {
                    Toast.makeText(MainActivity.this, "Action clicked!", Toast.LENGTH_SHORT).show();
                })
                .setActionTextColor(Color.YELLOW)
                .show();
    }

    private void showProgressDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Please wait...");
        builder.setMessage("Closing in 5 seconds...");
        builder.setCancelable(false);

        AlertDialog progressDialog = builder.create();
        progressDialog.show();

        new CountDownTimer(5000, 1000) {
            int secondsLeft = 5;

            @Override
            public void onTick(long millisUntilFinished) {
                secondsLeft--;
                progressDialog.setMessage("Closed after " + secondsLeft + " sec...");
            }

            @Override
            public void onFinish() {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        }.start();
    }


    private void showCircularProgressDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_circular_progress, null);

        AlertDialog progressDialog = new MaterialAlertDialogBuilder(this)
                .setTitle("Loading")
                .setView(dialogView)
                .setCancelable(false)   // нельзя закрыть вручную
                .create();               // используем create(), а не show() сразу

        progressDialog.show();

        // Автоматически закрываем ровно через 5 секунд (БЕЗ показа счётчика)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }, 5000);  // 5000 мс = 5 секунд
    }

    private void showHorizontalProgressDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_horizontal_progress, null);
        LinearProgressIndicator progressIndicator = dialogView.findViewById(R.id.horizontal_progress);

        AlertDialog dialog = new MaterialAlertDialogBuilder(this)
                .setTitle("Loading")
                .setView(dialogView)
                .setCancelable(false)
                .show();

        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                final int progress = i;
                handler.post(() -> progressIndicator.setProgressCompat(progress, true));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            handler.post(dialog::dismiss);
        }).start();
    }


    private void showCustomAnimatedDialog() {
        Dialog dialog = new Dialog(this, R.style.CustomAnimatedDialog);
        dialog.setContentView(R.layout.dialog_custom_animated);
        dialog.findViewById(R.id.closeButton).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showSpotlightDialog() {
        DialogFragment dialogFragment = new SpotlightDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "spotlight_dialog_fragment");
    }

    private void showTopRoundedDialog() {
        DialogFragment dialogFragment = new TopRoundedDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "top_rounded_dialog_fragment");
    }

    private void iniComponenntsAndListeners() {
        classicAlertDialogButton= findViewById(R.id.classicAlertDialogButton);
        customAlertDialogButton= findViewById(R.id.customAlertDialogButton);
        singleChoiceAlertDialogButton= findViewById(R.id.singleChoiceAlertDialogButton);
        radioButtonsAlertDialogButton= findViewById(R.id.radioButtonsAlertDialogButton);
        multiChoiceAlertDialogButton= findViewById(R.id.multiChoiceAlertDialogButton);
        customLegacyDialogButton= findViewById(R.id.customLegacyDialogButton);
        dialogFragmentButton= findViewById(R.id.dialogFragmentButton);
        alertDialogInDialogFragmentButton= findViewById(R.id.alertDialogInDialogFragmentButton);
        fullscreenDialogFragmentButton= findViewById(R.id.fullscreenDialogFragmentButton);
        transparentAnimatedDialogButton= findViewById(R.id.transparentAnimatedDialogFragmentButton);
        datePickerDialogButton= findViewById(R.id.datePickerDialogButton);
        datePickerDialogSpinnerButton= findViewById(R.id.datePickerDialogSpinnerButton);
        datePickerDialogCalendarButton= findViewById(R.id.datePickerDialogCalendarButton);
        timePickerDialog24hButton= findViewById(R.id.timePickerDialog24hButton);
        timePickerDialog12hButton= findViewById(R.id.timePickerDialog12hButton);
        dateRangePickerButton= findViewById(R.id.dateRangePickerButton);
        materialDatePickerButton= findViewById(R.id.materialDatePickerButton);
        materialTimePickerButton= findViewById(R.id.materialTimePickerButton);
        materialAlertDialogButton= findViewById(R.id.materialAlertDialogButton);
        materialSingleChoiceDialogButton= findViewById(R.id.materialSingleChoiceDialogButton);
        materialMultiChoiceDialogButton= findViewById(R.id.materialMultiChoiceDialogButton);
        materialListDialogButton= findViewById(R.id.materialListDialogButton);
        materialCustomContentButton= findViewById(R.id.materialCustomContentButton);
        bottomSheetDialogButton= findViewById(R.id.bottomSheetDialogButton);
        bottomSheetDialogFragmentButton= findViewById(R.id.bottomSheetDialogFragmentButton);
        modalNonDismissibleBottomSheetButton= findViewById(R.id.modalNonDismissibleBottomSheetButton);
        persistentBottomSheetActivityButton= findViewById(R.id.persistentBottomSheetActivityButton);
        popupWindowButton= findViewById(R.id.popupWindowButton);
        popupMenuButton= findViewById(R.id.popupMenuButton);
        dropdownMenuActivityButton= findViewById(R.id.dropdownMenuActivityButton);
        toastButton= findViewById(R.id.toastButton);
        customToastButton= findViewById(R.id.customToastButton);
        snackbarButton= findViewById(R.id.snackbarButton);
        snackbarWithActionButton= findViewById(R.id.snackbarWithActionButton);
        progressDialogButton= findViewById(R.id.progressDialogButton);
        circularProgressDialogButton= findViewById(R.id.circularProgressDialogButton);
        horizontalProgressDialogButton= findViewById(R.id.horizontalProgressDialogButton);
        customAnimatedDialogButton= findViewById(R.id.customAnimatedDialogButton);
        spotlightDialogButton= findViewById(R.id.spotlightDialogButton);
        topRoundedDialogButton= findViewById(R.id.topRoundedDialogButton);




        classicAlertDialogButton.setOnClickListener(v -> showClassicAlertDialog());
        customAlertDialogButton.setOnClickListener(v -> showCustomAlertDialog());
        singleChoiceAlertDialogButton.setOnClickListener(v -> showSingleChoiceAlertDialog());
        radioButtonsAlertDialogButton.setOnClickListener(v -> showRadioButtonsAlertDialog());
        multiChoiceAlertDialogButton.setOnClickListener(v -> showMultiChoiceAlertDialog());
        customLegacyDialogButton.setOnClickListener(v -> showCustomLegacyDialog());
        dialogFragmentButton.setOnClickListener(v -> showDialogFragment());
        alertDialogInDialogFragmentButton.setOnClickListener(v -> showAlertDialogInDialogFragment());
        fullscreenDialogFragmentButton.setOnClickListener(v -> showFullScreenDialogFragment());
        transparentAnimatedDialogButton.setOnClickListener(v -> showTransparentAnimatedDialogFragment());
        datePickerDialogButton.setOnClickListener(v -> showDatePickerDialog());
        datePickerDialogSpinnerButton.setOnClickListener(v -> showDatePickerDialogSpinner());
        datePickerDialogCalendarButton.setOnClickListener(v -> showDatePickerDialogCalendar());
        timePickerDialog24hButton.setOnClickListener(v -> showTimePickerDialog24h());
        timePickerDialog12hButton.setOnClickListener(v -> showTimePickerDialog12h());
        dateRangePickerButton.setOnClickListener(v -> showDateRangePicker());
        materialDatePickerButton.setOnClickListener(v -> showMaterialDatePicker());
        materialTimePickerButton.setOnClickListener(v -> showMaterialTimePicker());
        materialAlertDialogButton.setOnClickListener(v -> showMaterialAlertDialog());
        materialSingleChoiceDialogButton.setOnClickListener(v -> showMaterialSingleChoiceDialog());
        materialMultiChoiceDialogButton.setOnClickListener(v -> showMaterialMultiChoiceDialog());
        materialListDialogButton.setOnClickListener(v -> showMaterialListDialog());
        materialCustomContentButton.setOnClickListener(v -> showMaterialCustomContentDialog());
        bottomSheetDialogButton.setOnClickListener(v -> showBottomSheetDialog());
        bottomSheetDialogFragmentButton.setOnClickListener(v -> showBottomSheetDialogFragment());
        modalNonDismissibleBottomSheetButton.setOnClickListener(v -> showModalNonDismissibleBottomSheet());
        persistentBottomSheetActivityButton.setOnClickListener(v -> openPersistentBottomSheetActivity());
        popupWindowButton.setOnClickListener(this::showPopupWindow);
        popupMenuButton.setOnClickListener(this::showPopupMenu);
        dropdownMenuActivityButton.setOnClickListener(v -> openDropdownMenuActivity());
        toastButton.setOnClickListener(v -> showToast());
        customToastButton.setOnClickListener(v -> showCustomToast());
        snackbarButton.setOnClickListener(this::showSnackbar);
        snackbarWithActionButton.setOnClickListener(this::showSnackbarWithAction);
        progressDialogButton.setOnClickListener(v -> showProgressDialog());
        circularProgressDialogButton.setOnClickListener(v -> showCircularProgressDialog());
        horizontalProgressDialogButton.setOnClickListener(v -> showHorizontalProgressDialog());
        customAnimatedDialogButton.setOnClickListener(v -> showCustomAnimatedDialog());
        spotlightDialogButton.setOnClickListener(v -> showSpotlightDialog());
        topRoundedDialogButton.setOnClickListener(v -> showTopRoundedDialog());

    }
}