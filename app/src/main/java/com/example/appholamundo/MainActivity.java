package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView lblSaludo;
    private EditText txtSaludo;
    private Button btnSaludo;
    private Button btnClean;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // relacionar los objetos con los componentes del layout
        lblSaludo = (TextView) findViewById(R.id.lblSaludo);
        txtSaludo = (EditText) findViewById(R.id.txtNombre);
        btnSaludo = (Button) findViewById(R.id.btnPulsame);
        btnClean = (Button) findViewById(R.id.btnClean);
        btnClose = (Button) findViewById(R.id.btnClose);

        // check how to do an event listener
        btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtSaludo.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Faltó agregar información",
                            Toast.LENGTH_SHORT).show();
                } else {
                    lblSaludo.setText("Hola, " + txtSaludo.getText() + "!");
                }
            }
        });

        // clean clean btn
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblSaludo.setText("");
                txtSaludo.setText("");
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}