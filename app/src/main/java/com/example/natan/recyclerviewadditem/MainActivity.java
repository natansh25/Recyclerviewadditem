package com.example.natan.recyclerviewadditem;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.natan.recyclerviewadditem.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Context mContext = this;

    TextView display;
    private List<Movies> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //recyclerVIewAdaption
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerViewAdapter=new RecyclerViewAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mRecyclerViewAdapter);









        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(mContext);
                final View dialogView = li.inflate(R.layout.custom_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mContext);
                // set title
                                        alertDialogBuilder.setTitle("Custom Dialog");
                                        // set custom dialog icon
                                        alertDialogBuilder.setIcon(R.drawable.steve);
                                        // set custom_dialog.xml to alertdialog builder
                                        alertDialogBuilder.setView(dialogView);

                                        // set dialog message
                                        alertDialogBuilder
                                                .setCancelable(false)
                                                .setPositiveButton("OK",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog,
                                                                                int id) {
                                                                // get user input and set it to etOutput
                                                                // edit text
                                                                final EditText Name =(EditText)dialogView.findViewById(R.id.name);

                                                                Movies movie= new Movies(Name.getText().toString());
                                                                movieList.add(movie);
                                                                mRecyclerViewAdapter.notifyDataSetChanged();
                                                            }
                                                        })
                                                .setNegativeButton("Cancel",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog,
                                                                                int id) {
                                                                dialog.cancel();
                                    }
                                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();








            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
