import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivityCheckBox extends AppCompatActivity {

    CheckBox apple, mango, pineapple;
    Button btnDisplay;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_check_box);

        /**Init all the Views**/
        apple = (CheckBox) findViewById(R.id.apple);
        pineapple = (CheckBox) findViewById(R.id.pineapple);
        mango = (CheckBox) findViewById(R.id.mango);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        display = (TextView) findViewById(R.id.display);

        /**Click on Display Button will result in TextView**/
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayRes = "";
                if (apple.isChecked()) {

                    /**If Apple Check is Selected**/
                    displayRes = displayRes + "\n" + apple.getText().toString();

                }
                if (mango.isChecked()) {

                    /**If Mango Check is Selected**/
                    displayRes = displayRes + "\n" + mango.getText().toString();

                }
                if (pineapple.isChecked()) {

                    /**If Pineapple Check is Selected**/
                    displayRes = displayRes + "\n" + pineapple.getText().toString();

                }
                /**Set The displayres Text in TextView**/
                display.setText(displayRes);
            }
        });
    }
}
