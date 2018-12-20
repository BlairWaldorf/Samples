
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityEditText extends AppCompatActivity {

    EditText txtName, txtAge;
    TextView display;
    Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_edittext);

        txtName = (EditText) findViewById(R.id.name);
        txtAge = (EditText) findViewById(R.id.age);

        display = (TextView) findViewById(R.id.txtDisplay);

        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        /***When Click on Display Button then Name and Age will be display in TextView below Button***/
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /***Check if Name and Age Field is Empty or Not(If Empty then Show toast Else Display in TextView)***/
                if (txtName.getText().toString().isEmpty() || txtAge.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields can not be blank!", Toast.LENGTH_SHORT).show();
                } else {
                    /***Store Name and Age in String After CLick on Button***/
                    String name = txtName.getText().toString();
                    String age = txtAge.getText().toString();

                    /***Display the name and age in TextView***/
                    display.setText(name + "\n" + age);         //  \n indicates new line
                }
            }
        });
    }
}
