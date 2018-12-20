
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityAlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_alert_dialog);
    }

    public void showDefaultAlert(View view) {

        /**Initialize AlertDialog**/
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityAlertDialog.this);
        builder.setCancelable(true);    /**Set Cancelable to True if you want to cancel on Outside Click**/
        builder.setTitle("Title Here"); /**Set Title**/
        builder.setMessage("This is My Message Here");  /**Set Dialog Message**/
        builder.setIcon(android.R.drawable.ic_dialog_info); /**Set an Icon to Alert Dialog**/

        /**Show No Button**/
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /**When Click on No, Shows a Toast**/
                dialog.cancel();
                Toast.makeText(MainActivityAlertDialog.this, "No is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        /**Show Yes Button**/
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /**When Click on Yes, Shows a Toast**/
                dialog.cancel();
                Toast.makeText(MainActivityAlertDialog.this, "Yes is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        /**Show Ok Button**/
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /**When Click on Ok, Shows a Toast**/
                dialog.cancel();
                Toast.makeText(MainActivityAlertDialog.this, "Ok is CLicked", Toast.LENGTH_SHORT).show();
            }
        });
        /**Set an Icon to No Button**/
        //builder.setNegativeButtonIcon(getDrawable(android.R.drawable.btn_minus));
        /**Set an Icon to Yes Button**/
        //builder.setPositiveButtonIcon(getDrawable(android.R.drawable.btn_plus));
        /**Show an Icon to Ok Button**/
        //builder.setNeutralButtonIcon(getDrawable(android.R.drawable.btn_default));

        /**Create alert Alert Dialog**/
        AlertDialog alert = builder.create();
        /**Set Gravity to Bottom, change the position according to your need**/
        alert.getWindow().setGravity(Gravity.BOTTOM);
        /**Now Show the Dialog**/
        alert.show();
    }

    public void showCustomAlert(View view) {

        LayoutInflater inflater = LayoutInflater.from(MainActivityAlertDialog.this);
        /**Inflate the custom Layout for Custom Alert Dialog**/
        final View v = inflater.inflate(R.layout.custom_alert_dialog, null);
        /**Init the Alert Dialog**/
        AlertDialog.Builder builer = new AlertDialog.Builder(MainActivityAlertDialog.this);
        /**Set the Infalted Custom Layout to Alert Dialog**/
        builer.setView(v);

        /**Init the button in custom layout**/
        Button btn = (Button) v.findViewById(R.id.dismiss);

        builer.setCancelable(true);
        final AlertDialog alert = builer.create();
        alert.getWindow().setGravity(Gravity.BOTTOM);
        /**Set Background of Alert dialog to Transparent**/
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        /**Show the alert**/
        alert.show();

        /**Click listenert to Button**/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**Cancel the ALert and show Toast**/
                alert.cancel();
                Toast.makeText(MainActivityAlertDialog.this, "Custom Alert Dialog Closed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
