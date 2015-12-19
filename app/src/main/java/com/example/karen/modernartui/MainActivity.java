package com.example.karen.modernartui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar colorChange = null;
    private final ImageView[] reds = new ImageView[4];
    private final ImageView[] blues = new ImageView[4];
    private final ImageView[] blacks = new ImageView[4];
    private final ImageView[] whites = new ImageView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reds[0] = (ImageView) findViewById(R.id.R1);
        reds[1] = (ImageView) findViewById(R.id.R2);
        reds[2] = (ImageView) findViewById(R.id.R3);
        reds[3] = (ImageView) findViewById(R.id.R4);

        blues[0] = (ImageView) findViewById(R.id.B1);
        blues[1] = (ImageView) findViewById(R.id.B2);
        blues[2] = (ImageView) findViewById(R.id.B3);
        blues[3] = (ImageView) findViewById(R.id.B4);

        blacks[0] = (ImageView) findViewById(R.id.Bl1);
        blacks[1] = (ImageView) findViewById(R.id.Bl2);
        blacks[2] = (ImageView) findViewById(R.id.Bl3);
        blacks[3] = (ImageView) findViewById(R.id.Bl4);

        whites[0] = (ImageView) findViewById(R.id.W1);
        whites[1] = (ImageView) findViewById(R.id.W2);
        whites[2] = (ImageView) findViewById(R.id.W3);
        whites[3] = (ImageView) findViewById(R.id.W4);

        colorChange = (SeekBar) findViewById(R.id.seekBar);

        colorChange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int alpha = 255;
                int dom = 125 + (130*progress/100);
                int sub = 50 + (90*progress/100);
                int black = 175 - 150*progress/100;
                int white = 250 - 55*progress/100;

                for(int r=0; r<4; r++)
                {
                    reds[r].setBackgroundColor(Color.argb(alpha, dom, sub, sub));
                }

                for(int b=0; b<4; b++)
                {
                    blues[b].setBackgroundColor(Color.argb(alpha, sub, sub, dom));
                }

                for(int bl=0; bl<4; bl++)
                {
                    blacks[bl].setBackgroundColor(Color.argb(alpha, black, black, black));
                }

                for(int w=0; w<4; w++)
                {
                    whites[w].setBackgroundColor(Color.argb(alpha, white, white, white));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
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
        if(id == R.id.info)
        {
            DialogFragment frag = new selectionDialogFragment();
            frag.show(getSupportFragmentManager(), "selection");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
