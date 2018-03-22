package com.basics.svb.goldenhourhelp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sosbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonhospital,medical1,police1,fire1,women1,whistle1,blood1,torch1;
        Button hospitalbutton =(Button)findViewById(R.id.hospitalbutton);
        Button bloodbankbutton =(Button)findViewById(R.id.bloodbankbutton);
        Button policebutton = (Button)findViewById(R.id.policebutton);
        Button ngobutton = (Button)findViewById(R.id.ngobutton);
        Button ambulancebutton = (Button)findViewById(R.id.ambulancebutton);
        Button firstaid = (Button)findViewById(R.id.firstaid);
        medical1=(Button)findViewById(R.id.medical1);
        police1=(Button)findViewById(R.id.police1);
        women1=(Button)findViewById(R.id.women1);
        fire1=(Button)findViewById(R.id.fire1);
        hospitalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?z=10&q=hospitals");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        bloodbankbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=blood bank");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        ngobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=ngo nearby");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        policebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=police station");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        ambulancebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=ambulance");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,FirstAidActivity.class);
                startActivity(it);
            }
        });


        final MediaPlayer whistle2= MediaPlayer.create(this,R.raw.whistle);
        whistle1 =(Button) this.findViewById(R.id.whistle1);

        whistle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whistle2.start();
            }
        });

        medical1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:102"));
                startActivity(intent);
            }
        });

        police1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:100"));
                startActivity(intent);
            }
        });

        fire1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:101"));
                startActivity(intent);
            }
        });

        women1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:103"));
                startActivity(intent);
            }
        });

        sosbutton=(Button)findViewById(R.id.sosbutton);
        sosbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SOSActivity.class);
                startActivity(i);
            }
        });

        Button torchbutton;
        torchbutton=(Button)findViewById(R.id.torchbutton);
        torchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ip = new Intent(MainActivity.this, TorchActivity.class);
                startActivity(ip);
            }
        });

    }


}
