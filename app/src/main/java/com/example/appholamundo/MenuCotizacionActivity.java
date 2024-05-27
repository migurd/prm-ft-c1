package com.example.appholamundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MenuCotizacionActivity extends AppCompatActivity {
    private EditText inName;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_cotizacion);

//        init
        init();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int folio = rand.nextInt(99) + 1;

                Intent intent = new Intent(MenuCotizacionActivity.this, MainCotizacionActivity.class);
                try {
                    if (inName.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Inserte un nombre, por favor.");

                    intent.putExtra("name", inName.getText().toString());
                    intent.putExtra("folio", folio);
                    startActivity(intent);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(MenuCotizacionActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void init() {
         inName = (EditText) findViewById(R.id.inNombre);
         btnNext = (Button) findViewById(R.id.btnNext);
    }
}