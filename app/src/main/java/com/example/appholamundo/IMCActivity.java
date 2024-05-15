package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class IMCActivity extends AppCompatActivity {
    private TextView lblResultado;
    private EditText txtWeight;
    private EditText txtHeight;
    private Button btnCalcular;
    private Button btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcactivity);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        txtHeight = (EditText) findViewById(R.id.txtAltura);
        txtWeight = (EditText) findViewById(R.id.txtPeso);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Float.parseFloat(txtHeight.getText().toString());
                double weight = Double.parseDouble(txtWeight.getText().toString());

                double imc = weight / Math.pow(height, 2);

                DecimalFormat df = new DecimalFormat("#.##");
                String imcStr =  df.format(imc);

                lblResultado.setText("Tu IMC es: " + imcStr);

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}