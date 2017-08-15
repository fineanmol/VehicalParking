package com.example.anmolagarwal.vehicalparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SlotConformation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_conformation);
        Button conform_btn = (Button) findViewById(R.id.conform_btn);
        conform_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SlotConformation.this, SlotSelection.class);
                startActivity(i);
            }

        });
    } // on create end
}
