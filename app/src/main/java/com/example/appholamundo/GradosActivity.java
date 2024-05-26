package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class GradosActivity extends AppCompatActivity {
    private EditText inputDegrees;
    private RadioGroup rgDegrees;
    private TextView txtResult;
    private Button btnCalculate;
    private Button btnClean;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grados);

        // init
        inputDegrees = (EditText) findViewById(R.id.inputGrados);
        rgDegrees = (RadioGroup) findViewById(R.id.rgGrados);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnCalculate = (Button) findViewById(R.id.btnCalcular);
        btnClean = (Button) findViewById(R.id.btnLimpiar);
        btnReturn = (Button) findViewById(R.id.btnRegresar);
        final int[] selectedIndex = {-1}; // man, im too lazy to implement smth better than this

        // logic
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Celsius to fahrenheit when 0, backwards if 1
                double res = 0;
                if (selectedIndex[0] == 0)
                    res = (double) 9 / 5 * Double.parseDouble(inputDegrees.getText().toString()) + 32;
                else if (selectedIndex[0] == 1)
                    res = (Double.parseDouble(inputDegrees.getText().toString()) - 32) * 5 / 9;

                DecimalFormat df = new DecimalFormat("#.##");
                String formattedResult = df.format(res);
                txtResult.setText(formattedResult);
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // L radio btns logic --> Add Event Listener kinda
        rgDegrees.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rbCelsius)
                    selectedIndex[0] = 0;
                else if (checkedId == R.id.rbFahrenheit)
                    selectedIndex[0] = 1;

                Toast.makeText(GradosActivity.this, "hey: " + selectedIndex[0], Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}