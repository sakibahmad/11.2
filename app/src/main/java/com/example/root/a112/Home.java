package com.example.root.a112;

/**
 * Created by root on 1/9/17.
 */


        import android.widget.AutoCompleteTextView;

        import android.app.Activity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;

public class Home extends Activity {
    private SQLiteItemSearch sqllitebb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        final AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autocompleteitem);
        sqllitebb = new SQLiteItemSearch(Home.this);
        sqllitebb.openDB();
        // Insert a few Products that begin with "C" and "H"

        final String[] deal = sqllitebb.getAllItemFilter();

        // Print out the values to the log
        for (int i = 0; i < deal.length; i++) {
            Log.i(this.toString(), deal[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, deal);
        actv.setAdapter(adapter);
        actv.setThreshold(1);
        actv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                arg0.getItemAtPosition(arg2);
                Log.i("SELECTED TEXT WAS------->", deal[arg2]);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        sqllitebb.close();
    }
}