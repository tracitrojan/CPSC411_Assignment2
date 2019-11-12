package com.example.cpsc411assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cpsc411assignment2.Adapter.SummaryListAdapter;

public class SummaryScreen extends AppCompatActivity {
    protected ListView mSummaryView;
    protected final String TAG = "Summary Screen";
    protected SummaryListAdapter ad;
    protected Menu summaryMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.student_list_lv);
        mSummaryView = findViewById(R.id.summary_list_id);
        ad = new SummaryListAdapter();
        mSummaryView.setAdapter((ListAdapter) ad);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        ad.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Custom Menu inflation
        getMenuInflater().inflate(R.menu.summary_screen_menu, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        summaryMenu = menu;

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Intent intent = new Intent(this, BlankDetailScreen.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}
