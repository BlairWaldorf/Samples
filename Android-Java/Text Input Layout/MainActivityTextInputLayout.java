
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

public class MainActivityTextInputLayout extends AppCompatActivity implements TextWatcher, View.OnFocusChangeListener {

    TextInputLayout layoutText, layoutEmail, layoutNumber, layoutPassword;
    TextInputEditText text, email, number, password;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_text_input_layout);

        layoutText = (TextInputLayout) findViewById(R.id.layoutText);
        layoutEmail = (TextInputLayout) findViewById(R.id.layoutEmail);
        layoutNumber = (TextInputLayout) findViewById(R.id.layoutNumber);
        layoutPassword = (TextInputLayout) findViewById(R.id.layoutPassword);

        text = (TextInputEditText) findViewById(R.id.text);
        email = (TextInputEditText) findViewById(R.id.email);
        number = (TextInputEditText) findViewById(R.id.number);
        password = (TextInputEditText) findViewById(R.id.password);

        display = (TextView) findViewById(R.id.display);

        /**Register a TextChangeListener for all TextInputEditText**/
        text.addTextChangedListener(this);
        email.addTextChangedListener(this);
        number.addTextChangedListener(this);
        password.addTextChangedListener(this);

        /**Register a FocusChangeListener for Validation**/
        email.setOnFocusChangeListener(this);
        password.setOnFocusChangeListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        /**Set a Entered Text to TextView**/
        display.setText(s);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        /**If not Focus then Check for validation**/
        if (!hasFocus) {
            /**[a-zA-Z0-9._-]+@[a-z]+\.+[a-z]+ will be use for Email Pattern Matching**/
            String pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (!email.getText().toString().trim().matches(pattern)) {

                /**Set Error Enable to True and Display Error if the Entered Text is not a valid email**/
                layoutEmail.setErrorEnabled(true);
                layoutEmail.setError("Enter a Valid Email...");
            } else {
                /**Else set to false**/
                layoutEmail.setErrorEnabled(false);
            }

            if (password.getText().toString().length() <= 6) {

                /**Set Error Enable to True and Display Error if the Entered Password is not greater than 6**/
                layoutPassword.setErrorEnabled(true);
                layoutPassword.setError("Password should be Greater than 6");
            } else {
                /**Else set to false**/
                layoutPassword.setErrorEnabled(false);
            }
        }
    }
}
