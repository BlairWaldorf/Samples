import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCheckedTextView extends AppCompatActivity {

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_checked_text_view);

        Fade fade = new Fade();
        fade.setDuration(400);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setEnterTransition(fade);

        /**initiate a ListView**/
        ListView listView = (ListView) findViewById(R.id.listView);

        prepareData();

        /**set the adapter to fill the data in ListView**/
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), list);
        listView.setAdapter(customAdapter);
    }

    private void prepareData() {
        list = new ArrayList<>();
        /**Add Items in List**/
        list.add("Alpha");
        list.add("Beta");
        list.add("CupCake");
        list.add("Donut");
        list.add("Eclair");
        list.add("Froyo");
        list.add("GingerBread");
        list.add("HoneyComb");
        list.add("Ice Cream Sandwich");
        list.add("JellyBean");
        list.add("KitKat");
        list.add("Lollipop");
        list.add("MarshMellow");
        list.add("Nougat");
        list.add("Oreo");
    }
}
