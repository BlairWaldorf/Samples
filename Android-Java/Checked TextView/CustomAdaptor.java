import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<String> list;
    Context context;
    LayoutInflater inflter;

    public CustomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        CheckedTextView cTextView;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        Holder holder = new Holder();
        if (view == null) {

            /**Initialize View**/
            view = inflter.inflate(R.layout.checkedtextview_item, null);
            holder.cTextView = (CheckedTextView) view.findViewById(R.id.cTextView);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        holder.cTextView.setText(list.get(position));

        /**perform on Click Event Listener on CheckedTextView**/
        final Holder finalHolder = holder;
        holder.cTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalHolder.cTextView.isChecked()) {

                    /**set cheek mark drawable and set checked property to false**/
                    finalHolder.cTextView.setCheckMarkDrawable(0);
                    finalHolder.cTextView.setChecked(false);
                } else {

                    /**set cheek mark drawable and set checked property to true**/
                    finalHolder.cTextView.setCheckMarkDrawable(R.drawable.checked);
                    finalHolder.cTextView.setChecked(true);
                }
            }
        });
        return view;
    }
}