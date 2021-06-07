package com.example.uts_akb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        getSupportActionBar().hide();

        Button yesButton = findViewById(R.id.deleteYes);
        Button noButton = findViewById(R.id.deleteNo);

        Database helper = new Database(this);

        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("Id");

        yesButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Integer isSuccess = helper.deteleData(id);

                if (isSuccess > 0) {
                    Toast.makeText(DeleteActivity.this, "Data has been remove", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(DeleteActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(DeleteActivity.this, "Data failed to remove", Toast.LENGTH_SHORT).show();
                }
            }
        });

        noButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteActivity.this, MainActivity.class));
            }
        });
    }
}

