package com.example.projectpbp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText hasil_nama;
    private EditText hasil_tempat;
    private EditText hasil_tanggal;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        hasil_nama = (EditText) findViewById(R.id.hasil_nama);
        disableEditText(hasil_nama);
        hasil_tempat = (EditText) findViewById(R.id.hasil_tempat);
        disableEditText(hasil_tempat);
        hasil_tanggal = (EditText) findViewById(R.id.hasil_tanggal);
        disableEditText(hasil_tanggal);
        btn_back = (Button) findViewById(R.id.btn_back);

        Intent intent = getIntent();

        String outputNama = intent.getStringExtra("nama");
        String outputTempat= intent.getStringExtra("tempat");
        String outputTanggal = intent.getStringExtra("tanggal");


        hasil_nama.setText(outputNama);
        hasil_tempat.setText(outputTempat);
        hasil_tanggal.setText(outputTanggal);


        btn_back.setOnClickListener(this);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_back){
            startActivity(new Intent(DetailActivity.this, MainActivity.class));
        }
    }
}