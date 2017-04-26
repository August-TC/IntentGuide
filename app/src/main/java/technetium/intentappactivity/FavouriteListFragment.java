package technetium.intentappactivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by August-Tancheng on 2017/4/14.
 */

public class FavouriteListFragment extends ListFragment {
    private WebsiteAdapter adapter;

    public FavouriteListFragment(){};
    public interface Callbacks
    {
        public void onItemSelected(int position);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new WebsiteAdapter(getActivity(),R.layout.website_item,Website.websites);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourite,container,false);
        final FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setRotation(360);
                Intent intent = new Intent(getActivity(),AddFavouriteDialog.class);
                startActivityForResult(intent,1);
                String name = intent.getStringExtra("Name");
                String add = intent.getStringExtra("Address");
                Toast.makeText(getActivity(),"Webside: "+name+"\n"+
                        "URL : "+add,Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        String address = adapter.getItem(position).getAddress();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+address));
        startActivity(intent);
    }



}
