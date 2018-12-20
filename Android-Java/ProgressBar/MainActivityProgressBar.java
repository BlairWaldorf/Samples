
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivityProgressBar extends AppCompatActivity {

    ProgressBar circle, horizontal;
    Button btnHoriStart, btnHoriStop;
    int progressBarStatus = 0;
    boolean command = false;    /**If Start Button is Clicked then False, If Stop Button is Clicked then True**/
    boolean alreadyRunning = false;
    Handler progressBarbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_progress_bar);

        circle = (ProgressBar) findViewById(R.id.circle);

        horizontal = (ProgressBar) findViewById(R.id.horizontal);
        btnHoriStart = (Button) findViewById(R.id.horiStart);
        btnHoriStop = (Button) findViewById(R.id.horiStop);

        /**Set Progress for Horizontal ProgressBar**/
        horizontal.setMax(100);

        /**Set Progress to Zero after init ProgressBar**/
        horizontal.setProgress(0);

        /**When Click on Start Button**/
        btnHoriStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**Set Command to False When Click on Start Button**/
                command = false;

                /**Check Whether the Progress is Already Running or Nor
                 * If Running Then Show Toast saying 'Already Runny...'
                 * else Start The loop By Calling progressOperation Method**/
                if (!alreadyRunning) {
                    progressOperation();
                } else {
                    Toast.makeText(MainActivityProgressBar.this, "Already Running...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHoriStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Set To True When click on Stop Button**/
                command = true;
                /**Set to False because Stop button will pause the Loop**/
                alreadyRunning = false;
            }
        });
    }

    private void progressOperation() {
        /**Need to Run the in Background,
         * so we need a Thread to run the Loop
         * Otherwise the Activity will Crash**/
        progressBarbHandler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                /**Loop to Increment the Progress Status (We can use any loop like for, do while, etc)**/
                while (progressBarStatus < 100 && !command) {
                    /**Set the alreadyRunning to True, Because We are inside the loop now**/
                    alreadyRunning = true;
                    /**Increment progressStatus with 1**/
                    progressBarStatus = progressBarStatus + 1;
                    /**sleep for 200 millisecond**/
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /**Update the progress bar with progressStatus**/
                    progressBarbHandler.post(new Runnable() {
                        public void run() {
                            horizontal.setProgress(progressBarStatus);
                        }
                    });
                }
                /**if the loop is completed,**/
                if (progressBarStatus == 100) {
                    /**sleep 1 seconds, so that you can see the 100%**/
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /**and then set ProgressBar and progressStatus to 0**/
                    horizontal.setProgress(0);
                    progressBarStatus = 0;
                }

                /**In the End, Set the alreadyRunning status to false**/
                alreadyRunning = false;
            }
        }).start(); /**Start the Thread/Background Task using thread.start()**/
    }
}
