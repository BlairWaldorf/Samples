
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ToolbarMainActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_toolbar);

        /**Initialize AppBarLayout and Toolbar**/
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        /**Set ActionBar to Toolbar**/
        setSupportActionBar(toolbar);
        /**setDisplayHomeAsUpEnabled will display a back arrow button in Toolbar**/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**Set a Title to Toolbar**/
        getSupportActionBar().setTitle("Toolbar");
        /**Set a Subtitle to Our Toolbar**/
        getSupportActionBar().setSubtitle("subtitle");
        /**setNavigationOnClickListener will invloke when click on Back Button in Toolbar**/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**Set a Menu**/
        getMenuInflater().inflate(R.menu.ex_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**When Select a Menu or SubMenu**/
        if (item.getItemId() == R.id.menu1) {
            Toast.makeText(getApplicationContext(), "Menu 1 is Selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.menu2) {
            Toast.makeText(getApplicationContext(), "Menu 2 is Selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.smenu1) {
            Toast.makeText(getApplicationContext(), "Sub Menu 1 is Selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.smenu2) {
            Toast.makeText(getApplicationContext(), "Sub Menu 2 is Selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
