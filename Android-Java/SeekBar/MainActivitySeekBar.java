
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivitySeekBar extends AppCompatActivity {

    TextView text, fontSize;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_seek_bar);

        text = (TextView) findViewById(R.id.text);
        fontSize = (TextView) findViewById(R.id.fontSize);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        /**Whenever the SeekBar Change, this listener will fire**/
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                /**Change the TextSize According to SeekBar Position**/
                text.setTextSize(progress);
                /**Change Font Size Text According to SeekBar Position**/
                fontSize.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
