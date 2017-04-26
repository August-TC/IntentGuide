package technetium.intentappactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddFavouriteDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favourite_dialog);
    }

    public void save(View view)
    {
        EditText name = (EditText)findViewById(R.id.new_name);
        EditText address = (EditText)findViewById(R.id.new_address);
        Intent intent = new Intent();
        intent.putExtra("Name",name.getText().toString());
        intent.putExtra("Address",address.getText().toString());
        intent.putExtra("position",Website.websites.size());
        setResult(RESULT_OK,intent);
        Website.addWebsite(new Website(name.getText().toString(),address.getText().toString()));
        finish();
    }
}
