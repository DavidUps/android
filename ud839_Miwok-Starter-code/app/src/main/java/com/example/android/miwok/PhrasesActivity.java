package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Hi ma fren ","Sasini yo mini"));
        words.add(new Word("Hi ma woman", "Sasini ya mana"));
        words.add(new Word("I lou yu", "Yo ta mo"));
        words.add(new Word("me to", "Yo ta mas"));
        words.add(new Word("me tree" , "Yo ta mas tre"));
        words.add(new Word("oh my gas", "Lamada Repsol"));
        words.add(new Word("i broke my feet", "me hueso pie roto"));

        WordAdapter adapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
