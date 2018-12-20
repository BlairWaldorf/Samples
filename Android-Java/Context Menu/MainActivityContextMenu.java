
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivityContextMenu extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_context_menu);

        btn = (Button) findViewById(R.id.btn);
        /**Register Context Menu for Button**/
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        /**Set title for Context Menu**/
        menu.setHeaderTitle("Choose Color");
        /**Set Icon for Context Menu**/
        menu.setHeaderIcon(getDrawable(R.drawable.choosecolor));

        /**Add Menu's**/
        menu.add(0, v.getId(), 0, "Red");
        menu.add(0, v.getId(), 0, "Green");
        menu.add(0, v.getId(), 0, "Blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        /**When Click on Any Item of Menu, Change Background Color of button accordingly**/
        if (item.getTitle() == "Red") {
            btn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        } else if (item.getTitle() == "Green") {
            btn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        } else if (item.getTitle() == "Blue") {
            btn.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        }
        return true;
    }
}
