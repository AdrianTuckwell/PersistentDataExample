package com.codeclan.example.persistentdataexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sandy on 10/08/2016.
 */
public class MainActivity extends AppCompatActivity
{
    EditText mTextToSave;
    Button mSaveButton;
    TextView mSavedText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_hello) {
            Log.d("Menu", "Menu item 'hello' clicked");

            Toast.makeText(MainActivity.this,R.string.menu_toast_hello,Toast.LENGTH_SHORT).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextToSave = (EditText)findViewById(R.id.text_to_save);
        mSaveButton = (Button)findViewById(R.id.save_button);
        mSavedText = (TextView)findViewById(R.id.saved_text);
        mSavedText.setVisibility(View.INVISIBLE);

        String savedText = SavedTextPreferences.getStoredText(MainActivity.this);

        // if string is not Null and Not empty...
        if (savedText != null && !savedText.isEmpty())
        {
                mSaveButton.setVisibility(View.INVISIBLE);
                mTextToSave.setVisibility(View.INVISIBLE);
                mSavedText.setVisibility(View.VISIBLE);
                mSavedText.setText(savedText);
        }

        mSaveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String textToSave = mTextToSave.getText().toString();
                Log.d("PersistenceExample:", "Save Button Clicked!");
                Log.d("PersistenceExample:", "The text to save is: '" + textToSave + "'");
                mSaveButton.setVisibility(View.INVISIBLE);
                mTextToSave.setVisibility(View.INVISIBLE);
                mSavedText.setVisibility(View.VISIBLE);
                mSavedText.setText(textToSave);
                Context context = v.getContext();
                SavedTextPreferences.setStoredText(context, textToSave);
            }
        });

    }
}
