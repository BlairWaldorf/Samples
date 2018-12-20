
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivityTimePicker extends AppCompatActivity {

    TimePicker timePicker;
    TextView eTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_time_picker);

        //  initiate the textview
        eTime = (TextView) findViewById(R.id.time);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(false); // used to display AM/PM mode

        // perform set on time changed listener event
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // display a toast with changed values of time picker
                Toast.makeText(getApplicationContext(), hourOfDay + "  " + minute, Toast.LENGTH_SHORT).show();
            }
        });

        // perform click event listener on TextView
        eTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(MainActivityTimePicker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        eTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true); //Yes 24 hour time
                mTimePicker.setTitle("Choose Time");
                mTimePicker.show();
            }
        });
    }
}
