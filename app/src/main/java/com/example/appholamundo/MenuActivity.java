package com.example.appholamundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {
    private CardView crvPrimer, crvIMC, crvCambio, crvConversion, crvCotizacion, crvSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        // Assign components
        initComponents();

        // Codificar los eventos clic de :las tarjetas
        crvPrimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        crvIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, IMCActivity.class);
                startActivity(intent);
            }
        });
        crvConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, GradosActivity.class);
                startActivity(intent);
            }
        });
        crvCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ConvertidorActivity.class);
                startActivity(intent);
            }
        });
        crvCotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MenuCotizacionActivity.class);
                startActivity(intent);
            }
        });
        crvSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initComponents() {
        crvPrimer = (CardView) findViewById(R.id.crvHola);
        crvIMC = (CardView) findViewById(R.id.crvIMC);
        crvCambio = (CardView) findViewById(R.id.crvMoneda);
        crvConversion = (CardView) findViewById(R.id.crvConversiones);
        crvCotizacion = (CardView) findViewById(R.id.crvCotizacion);
        crvSpinner = (CardView) findViewById(R.id.crvSpinner);
    }
}


