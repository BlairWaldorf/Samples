
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivitySwipeRefresh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_swipe_refresh);

        final SwipeRefreshLayout refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                /**Set Refreshing to True**/
                refresh.setRefreshing(true);

                //Write Your Code to Refresh any View

                /**Below Code will not execute for 2000 Millisecond (i.e 2 seconds)**/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    Toast.makeText(MainActivitySwipeRefresh.this, "Refresh Completed", Toast.LENGTH_SHORT).show();

                        /**Set Refreshing to False**/
                        refresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }
}
