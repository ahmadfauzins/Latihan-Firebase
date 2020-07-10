package com.fauzi.modul3_androidfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {
    TextView nim,nama,hasildata;
    String hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editKey =
                (EditText)findViewById(R.id.editext_key);
        final EditText editValue =
                (EditText)findViewById(R.id.editext_value);
        LinearLayout buttonAdd = (LinearLayout) findViewById(R.id.button_add);

        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        hasildata = findViewById(R.id.hasil);

        FirebaseDatabase firebaseDatabase
                =FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference =
                firebaseDatabase.getReference();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //databaseReference.setValue("Coba Tambah Data");
                databaseReference.child(nim.getText().toString())
                        .setValue(editKey.getText().toString());
                databaseReference.child(nama.getText().toString())
                        .setValue(editValue.getText().toString());

                hasil = "Data : "+editKey.getText().toString()+" "+editValue.getText().toString()+"\n Berhasil Ditambahkan.";
                hasildata.setText(hasil);
                hasildata.setVisibility(View.VISIBLE);

            }


        });
    }

}