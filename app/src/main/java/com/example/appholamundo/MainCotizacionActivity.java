package com.example.appholamundo;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainCotizacionActivity extends AppCompatActivity {
    private TextView outName, outFolio, outMonthlyPayment, outFirstPayment;
    private EditText inDescription, inCarValue, inInitialPaymentPercentage;
    private Button btnCalculate, btnClean, btnReturn;
    private RadioGroup rgPeriods;
    private RadioButton rb12, rb18, rb24, rb36;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_cotizacion);

        // init
        init();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (inDescription.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Descripción no puede estar vacía.");
                    if (inCarValue.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Valor de automóvil no puede estar vacía.");
                    if (inInitialPaymentPercentage.getText().toString().isEmpty())
                        throw new IllegalArgumentException("Pago inicial no puede estar vacía.");

                    double carValue = Double.parseDouble(inCarValue
                            .getText().toString());
                    if (carValue < 0)
                        throw new IllegalArgumentException("El automóvil no puede tener un valor negativo.");
                    double initialPaymentPer = Double.parseDouble(inInitialPaymentPercentage
                            .getText().toString()); // percentage
                    if (initialPaymentPer < 0 || initialPaymentPer > 100)
                        throw new IllegalArgumentException("Porcentaje de pago no puede estar por debajo de 0% ni superar 100%.");

                    int checkedRadioButtonId = rgPeriods.getCheckedRadioButtonId();

                    int period = checkedRadioButtonId == rb12.getId() ? 12 :
                            checkedRadioButtonId == rb18.getId() ? 18 :
                                    checkedRadioButtonId == rb24.getId() ? 24 :
                                            checkedRadioButtonId == rb36.getId() ? 36 : -1;

                    if (period == -1)
                        throw new IllegalArgumentException("Seleccione un periodo de pago, por favor.");

                    // From here on, everything has been validated. So, it should work, SHOULD.
                    double firstPayment = carValue * (initialPaymentPer / 100);
                    double monthlyPayment = (carValue - firstPayment) / period;

                    DecimalFormat df = new DecimalFormat("#.##");
                    String firstPaymentStr = df.format(firstPayment);
                    String monthlyPaymentStr = df.format(monthlyPayment);

                    outFirstPayment.setText(firstPaymentStr);
                    outMonthlyPayment.setText(monthlyPaymentStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainCotizacionActivity.this, "Inserte valores válidos en los inputs, por favor.",
                            Toast.LENGTH_SHORT).show();
                } catch (IllegalArgumentException e) {
                    Toast.makeText(MainCotizacionActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inDescription.setText("");
                inCarValue.setText("");
                inInitialPaymentPercentage.setText("");
                rgPeriods.clearCheck();
                outMonthlyPayment.setText("");
                outFirstPayment.setText("");
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
        outName = (TextView) findViewById(R.id.outClient);
        outFolio = (TextView) findViewById(R.id.outFolio);
        outMonthlyPayment = (TextView) findViewById(R.id.outMonthlyPayment);
        outFirstPayment = (TextView) findViewById(R.id.outFirstMayment);
        inDescription = (EditText) findViewById(R.id.inDescription);
        inCarValue = (EditText) findViewById(R.id.inCarValue);
        inInitialPaymentPercentage = (EditText) findViewById(R.id.inInitialPaymentPercentage);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnClean = (Button) findViewById(R.id.btnClean);
        btnReturn = (Button) findViewById(R.id.btnRegresar);
        rgPeriods = (RadioGroup) findViewById(R.id.rgPeriods);
        rb12 = (RadioButton) findViewById(R.id.rb12);
        rb18 = (RadioButton) findViewById(R.id.rb18);
        rb24 = (RadioButton) findViewById(R.id.rb24);
        rb36 = (RadioButton) findViewById(R.id.rb36);

//        set values for folio and name
        String name = getIntent().getStringExtra("name");
        int folio = getIntent().getIntExtra("folio", 1);

        outName.setText(name);
        outFolio.setText(Integer.toString(folio));
    }
}