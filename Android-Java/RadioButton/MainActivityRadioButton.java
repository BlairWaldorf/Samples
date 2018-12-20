
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivityRadioButton extends AppCompatActivity {

    private RadioGroup group;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_radio_button);

        imageView = (ImageView) findViewById(R.id.imageView);
        group = (RadioGroup) findViewById(R.id.group);

        /**When Click on Any Radio Button, This Listener will execute**/
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                switch (id) {
                    /**If Mango is Selected**/
                    case R.id.mango:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.radiobutton_mango));
                        break;
                    /**If Apple is Selected**/
                    case R.id.apple:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.radiobutton_apple));
                        break;
                    /**If Pineapple is Selected**/
                    case R.id.pineapple:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.radiobutton_pineapple));
                        break;
                }
                /******Before Run the Program Copy and Paste Your Images in Drawable inside res/ ********/
                /** For Mango : mango.PNG **/
                /** For Apple : apple.PNG **/
                /** For Pineapple : pineapple.PNG **/
            }
        });
    }
}
