package com.example.contacts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPhone;
    private Button btnAddContact;
    private TextView tvAddedContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        btnAddContact = findViewById(R.id.btnAddContact);
        tvAddedContacts = findViewById(R.id.tvAddedContacts);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                if (!name.isEmpty() && !phone.isEmpty()) {
                    String currentContacts = tvAddedContacts.getText().toString();
                    String newContact = "Имя: " + name + "\nТелефон: " + phone;

                    tvAddedContacts.setText(currentContacts + "\n\n" + newContact);

                    etName.setText("");
                    etPhone.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Заполните оба поля", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
