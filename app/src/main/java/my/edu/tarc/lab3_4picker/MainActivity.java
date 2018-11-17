package my.edu.tarc.lab3_4picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int age;
    EditText editTextAccountBalance;
    TextView textViewAge;
    Button buttonDOB;
    TextView textViewEligibleAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextAccountBalance = findViewById(R.id.editTextAccountBalance);
        textViewAge = findViewById(R.id.textViewAge);
        buttonDOB = findViewById(R.id.buttonDOB);
        textViewEligibleAmount = findViewById(R.id.textViewEligibleAmount);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        age = currentYear - Integer.valueOf(year_string);
        buttonDOB.setText(dateMessage);
        textViewAge.setText(age + "");
    }

    public void calculate(View view)
    {
        Boolean isError = false;
        float minSaving = 0.0f;
        float excessSaving = 0.0f;
        float eligible = 0.0f;
        if (age <= 15)
        {

        }

        else if (age <= 20)
        {
            minSaving = 5000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 25)
        {
            minSaving = 14000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 30)
        {
            minSaving = 29000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 35)
        {
            minSaving = 50000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 40)
        {
            minSaving = 78000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 45)
        {
            minSaving = 116000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 50)
        {
            minSaving = 165000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        else if (age <= 55)
        {
            minSaving = 228000;
            excessSaving = Float.valueOf(editTextAccountBalance.getText().toString()) - minSaving;
        }

        if (excessSaving < 0)
        {
            isError = true;
            Toast.makeText(this, "Not Eligible! You too poor!",
                    Toast.LENGTH_SHORT).show();
        }

        else
        {
            eligible = excessSaving * 30 / 100;
            textViewEligibleAmount.setText(eligible + "");
        }
    }

    public void reset(View view)
    {
        editTextAccountBalance.setText("");
        textViewAge.setText(R.string.age);
        textViewEligibleAmount.setText(R.string.eligibleAmount);
        buttonDOB.setText(R.string.DOB);
    }
}
