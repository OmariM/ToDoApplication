package me.omarim.todoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    // text field containing updated item description
    EditText etItemText;
    // we need to track the item's position in the list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // resolve the text field from the layout
        etItemText = (EditText) findViewById(R.id.etItemText);
        // set the text field's content from the internet
        etItemText.setText(getIntent().getStringExtra(MainActivity.ITEM_TEXT));
        // track the position of the item in the list
        position = getIntent().getIntExtra(MainActivity.ITEM_POSITION, 0);
        // set the title bar to reflect the purpose of the view
        getSupportActionBar().setTitle("Edit Item");
    }

    public void onSaveItem(View v) {
        // prepare intent to pass back to MainActivity
        Intent data = new Intent();
        // pass updated item text and original position
        data.putExtra(MainActivity.ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(MainActivity.ITEM_POSITION, position);
        setResult(RESULT_OK, data);
        finish();
    }
}
