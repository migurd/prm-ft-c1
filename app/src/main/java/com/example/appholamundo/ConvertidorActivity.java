package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ConvertidorActivity extends AppCompatActivity {
    private EditText inCoins;
    private Spinner spinnerCoins;
    private TextView outRes;
    private Button btnCalculate;
    private Button btnClean;
    private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_convertidor);

        // init components
        init();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = 0;
                double in = Double.parseDouble(inCoins.getText().toString());
                final double MXNTOUSD = 0.059896414;
                final double MXNTOEUR = 0.055216282;
                final double MXNTOCAD = 0.081852617;
                final double MXNTOLBP = 5360.358;

                switch (spinnerCoins.getSelectedItemPosition()) {
                    case 0:
                        res = in * MXNTOUSD;
                        break;
                    case 1:
                        res = in * MXNTOEUR;
                        break;
                    case 2:
                        res = in * MXNTOCAD;
                        break;
                    case 3:
                        res = in * MXNTOLBP;
                        break;
                }

                DecimalFormat df = new DecimalFormat("#.##");
                String formattedRes = df.format(res);

                outRes.setText("$" + formattedRes);
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outRes.setText("_____");
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
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

    public void init() {
        inCoins = (EditText) findViewById(R.id.inMonedas);
        spinnerCoins = (Spinner) findViewById(R.id.spinnerMonedas);
        outRes = (TextView) findViewById(R.id.outResultado);
        btnCalculate = (Button) findViewById(R.id.btnCalcular);
        btnClean = (Button) findViewById(R.id.btnLimpiar);
        btnReturn = (Button) findViewById(R.id.btnRegresar);

        String[] items = {"Dólares americanos", "Euros", "Dólares canadienses", "Libra esterlina"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items);

        spinnerCoins.setAdapter(adapter);
    }
}