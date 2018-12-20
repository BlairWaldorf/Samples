
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityTextView extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_textview);

        txt1 = (TextView) findViewById(R.id.TextView1);
        txt2 = (TextView) findViewById(R.id.TextView2);
        txt3 = (TextView) findViewById(R.id.TextView3);
        txt4 = (TextView) findViewById(R.id.TextView4);

        /***To make the TextView Selectable to copy the text on TextView by long click on TextView***/
        txt1.setTextIsSelectable(true);
        txt2.setTextIsSelectable(true);
        txt3.setTextIsSelectable(true);
        txt4.setTextIsSelectable(true);

        /***Set Text in TextView Programmatically***/
        txt1.setText("This is My First TextView");

        /***Set The Visibility of TextView [View.GONE = Not Visible]   [View.VISIBLE = Visible]***/
        txt1.setVisibility(View.GONE);
        txt1.setVisibility(View.VISIBLE);

        /**Set Background Color of TextView Programmatically***/
        txt2.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));

        /***OnClick Listener will fire when click on any textview***/
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TextView 1", Toast.LENGTH_SHORT).show();
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TextView 2", Toast.LENGTH_SHORT).show();
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TextView 3", Toast.LENGTH_SHORT).show();
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TextView 4", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
