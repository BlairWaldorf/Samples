
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivitySharedPref extends AppCompatActivity {

    private EditText firstName, lastName;
    private SharedPreferences mPref;
    private static final String PREF_NAME = "sp_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_shared_pref);

        mPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);

        /**Get First Name from Saved Shared Preference**/
        String storedFirstName = mPref.getString("FIRST_NAME", "");
        firstName.setText(storedFirstName);

        /**Get Last Name from Saved Shared Preference**/
        String storedLastName = mPref.getString("LAST_NAME", "");
        lastName.setText(storedLastName);

        Button saveButton = (Button) findViewById(R.id.save);

        /**When Click on Saved, Then store the first name and last name in shared preference**/
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Get First and Last Name**/
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                /**Check is it blank or not**/
                if (TextUtils.isEmpty(first) || TextUtils.isEmpty(last)) {
                    Toast.makeText(MainActivitySharedPref.this, "All fields must be filled ", Toast.LENGTH_LONG).show();
                } else {
                    /**set the preference in edit mode**/
                    SharedPreferences.Editor editor = mPref.edit();
                    /**Set the First and Last Name into shared preference**/
                    editor.putString("FIRST_NAME", first);
                    editor.putString("LAST_NAME", last);
                    /**Apply the Preference after changes**/
                    editor.apply();
                    /**After Saving set the fields blank**/
                    firstName.setText("");
                    lastName.setText("");
                    Toast.makeText(MainActivitySharedPref.this, "Saved...", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}