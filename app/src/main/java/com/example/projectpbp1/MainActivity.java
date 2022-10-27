package com.example.projectpbp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nama;
    private EditText tempat_lahir;
    private EditText set_tanggal;
    private Button tanggal_lahir;
    private Button btn_lihat_hasil;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText)findViewById(R.id.nama);
        tempat_lahir = (EditText)findViewById(R.id.tempat_lahir);
        tanggal_lahir = (Button) findViewById(R.id.tanggal_lahir);
        set_tanggal = (EditText) findViewById(R.id.set_tanggal);
        disableEditText(set_tanggal);
        btn_lihat_hasil = (Button) findViewById(R.id.btn_lihat_hasil);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tanggal_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        btn_lihat_hasil.setOnClickListener(this);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setTextColor(Color.BLACK);
    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                set_tanggal.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_lihat_hasil){
            String inputNama = nama.getText().toString().trim();
            String inputTempat = tempat_lahir.getText().toString().trim();
            String inputTanggal = set_tanggal.getText().toString().trim();

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("nama",inputNama);
            intent.putExtra("tempat", inputTempat);
            intent.putExtra("tanggal", inputTanggal);
            startActivity(intent);
        }
    }
}