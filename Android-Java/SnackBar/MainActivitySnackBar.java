
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivitySnackBar extends AppCompatActivity {

    Button btnDefaultSnack, btnCustomSnac, btnSnacWithAction, btnSnacWithTextPos, btnCustomSnacPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_snack_bar);

        /**Initialize Layout**/
        btnDefaultSnack = (Button) findViewById(R.id.btnDefaultSnack);
        btnCustomSnac = (Button) findViewById(R.id.btnCustomSnac);
        btnSnacWithAction = (Button) findViewById(R.id.btnSnacWithAction);
        btnSnacWithTextPos = (Button) findViewById(R.id.btnSnacWithTextPos);
        btnCustomSnacPos = (Button) findViewById(R.id.btnCustomSnacPos);

        /**Display Simple Snackbar**/
        btnDefaultSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Default Snackbar", Snackbar.LENGTH_SHORT).show();
            }
        });

        /**Display Snackbar With Custom Background and Text Color**/
        btnCustomSnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Snackbar with Custom Background and Custom Text";
                Snackbar snac = Snackbar.make(v, Html.fromHtml("<font color=\"#FFFFFF\"><b>" + message + "</b></font>"), Snackbar.LENGTH_SHORT);
                snac.getView().setBackgroundColor(ContextCompat.getColor(v.getContext(), android.R.color.holo_blue_dark));
                snac.show();
            }
        });

        /**Display Snackbar With Action Button**/
        btnSnacWithAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snac = Snackbar.make(v, "Snackbar With Action", Snackbar.LENGTH_SHORT);
                snac.getView().setBackgroundColor(ContextCompat.getColor(v.getContext(), android.R.color.holo_blue_dark));
                snac.setActionTextColor(getResources().getColor(android.R.color.holo_red_dark));
                snac.show();
                snac.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snac.dismiss();
                    }
                });
            }
        });

        /**Display Snackbar With Custom Text Position**/
        btnSnacWithTextPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snac = Snackbar.make(v, "Snackbar With Action", Snackbar.LENGTH_SHORT);
                snac.getView().setBackgroundColor(ContextCompat.getColor(v.getContext(), android.R.color.holo_blue_dark));
                snac.setActionTextColor(getResources().getColor(android.R.color.holo_red_dark));
                View view = snac.getView();
                TextView setTxtGravity = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                setTxtGravity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snac.show();
            }
        });

        /**Display Snackbar With Custom Position (Show int Top of the Screen)**/
        btnCustomSnacPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View customPos = (View) findViewById(R.id.customSnac);
                final Snackbar snac = Snackbar.make(customPos, "Snackbar in Top of the Screen", Snackbar.LENGTH_LONG);
                snac.getView().setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.colorPrimaryDark));
                snac.setActionTextColor(getResources().getColor(android.R.color.white));
                snac.show();
                snac.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snac.dismiss();
                    }
                });
            }
        });
    }
}
