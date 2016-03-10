package vlad.com.br.tempcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View view){
        RadioButton toCelsius = (RadioButton)findViewById(R.id.radioCelsius);
        RadioButton toFahr = (RadioButton)findViewById(R.id.radioFahrenheit);
        EditText input = (EditText)findViewById(R.id.editTxtInput);
        TextView output = (TextView)findViewById(R.id.textViewOutput);

        if (input.length() == 0){
            Toast.makeText(this, "Forneça uma temperatura!", Toast.LENGTH_LONG).show();
            return;
        }

        float inputTemp = Float.parseFloat(input.getText().toString());
        if (toCelsius.isChecked())
            output.setText("Resultado: " + String.valueOf(C2F(inputTemp)) + "C");
        else
            output.setText("Resultado: " + String.valueOf(F2C(inputTemp)) + "F");
    }

    private float F2C(float celsius){
        return ((celsius * 9 / 5) + 32);
    }

    private float C2F(float fahr){
        return ((fahr - 32) * 5 / 9);
    }
}
