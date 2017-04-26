package technetium.intentappactivity;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by August-Tancheng on 2017/4/14.
 */

public class WebsiteAdapter extends ArrayAdapter<Website> {

    private int resourceId;

    public WebsiteAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        Website website = getItem(position);
        TextView address = (TextView)view.findViewById(R.id.website_address);
        TextView name = (TextView)view.findViewById(R.id.website_name);
        Button button = (Button)view.findViewById(R.id.delete_button);
        address.setText(website.getAddress());
        name.setText(website.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(getItem(position));
            }
        });
        return view;
    }
}
