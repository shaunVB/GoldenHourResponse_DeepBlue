package com.basics.svb.goldenhourhelp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.util.Locale.getDefault;


public class SOSActivity extends AppCompatActivity implements LocationListener{

    LocationManager locationManager;
    Button getLocationBtn;
    LocationListener locationListener;

    private static final String FILE_NAME = "example.txt";
    Button whatsapp;
    EditText name1, name2, name3;
    EditText phone1, phone2, phone3;
    TextView locationText, call2, call3;
    Button okbutton;
    String xlatitude= "";
    String xlongitude= "";
    String sendmsg="";
    String link;
    String address;

    public SOSActivity() {
        link = "";
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        phone1 = (EditText) findViewById(R.id.phoneno1);
        phone2 = (EditText) findViewById(R.id.phoneno2);
        phone3 = (EditText) findViewById(R.id.phoneno3);

        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        name3 = (EditText) findViewById(R.id.name3);
        locationText = (TextView) findViewById(R.id.locationText);
        String n1, n2, n3, m1, m2, m3;
        n1 = phone1.getText().toString();
        n2 = phone2.getText().toString();
        n3 = phone3.getText().toString();
        whatsapp=(Button)findViewById(R.id.whatsappbutton);
        okbutton = (Button) findViewById(R.id.okbutton);
        getLocationBtn = (Button)findViewById(R.id.getLocationBtn);


        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
        Location location = new Location("mylocation");
        location.setLatitude(location.getLatitude());
        location.setLongitude(location.getLongitude());
        //LatLng latLng = new LatLng(20.5937, 78.9629);
        xlatitude= String.valueOf(location.getLatitude());
        xlongitude= String.valueOf(location.getLongitude());
        locationText.setText("Latitude : " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        Log.i("Location", String.valueOf(location.getLatitude())+" and "+String.valueOf(location.getLongitude()));
        try {
            Geocoder geocoder = new Geocoder(this, getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
            String link=" http://www.google.com/maps?q="+location.getLatitude()+","+location.getLongitude();
            xlatitude= String.valueOf(location.getLatitude());
            xlongitude= String.valueOf(location.getLongitude());
            Log.i("Location", String.valueOf(location.getLatitude())+" and "+String.valueOf(location.getLongitude()));
            sendmsg=String.valueOf(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));

        }catch(Exception e)
        {

        }

        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                String link=" http://www.google.com/maps?q="+xlatitude+","+xlongitude;
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","",null));
                intent.putExtra("sms_body","\nHelp Required Urgent"+link+" \nGet my location on this link coordinates please");
                startActivity(intent);

            }



        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String link=" http://www.google.com/maps?q="+xlatitude+","+xlongitude;
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Help Required Urgent\n"+link+" Address: "+address);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                locationText.setText("Latitude : " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
                String link=" http://www.google.com/maps?q="+location.getLatitude()+","+location.getLongitude();
                xlatitude= String.valueOf(location.getLatitude());
                xlongitude= String.valueOf(location.getLongitude());
                call2.setText(link);
                Log.i("Location", String.valueOf(location.getLatitude())+" and "+String.valueOf(location.getLongitude()));
                try {
//                    Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//                    locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
//                            addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
                }catch(Exception e)
                {

                }
                Log.i("Location", location.toString());
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","",null));
                intent.putExtra("sms_body","\nUrgent Help Required "+link+" \nGet my location on this link coordinates okokok");
                startActivity(intent);


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Toast.makeText(SOSActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
            }

        };

        // If device is running SDK < 23`

        if (Build.VERSION.SDK_INT < 23) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        } else {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                // ask for permission

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);


            } else {

                // we have permission!

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }

        }
        /*
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        context.startActivity(intent);
        String geoUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + mTitle + ")";
        */


    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);


        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }



    public void onLocationChanged(Location location) {
        locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        Log.i("Location", String.valueOf(location.getLatitude())+" and "+String.valueOf(location.getLongitude()));
        xlatitude= String.valueOf(location.getLatitude());
        xlongitude= String.valueOf(location.getLongitude());
        try {
            Geocoder geocoder = new Geocoder(this, getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
            address=locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2);

        }catch(Exception e)
        {

        }


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

//    public void load(View v) {
//        FileInputStream fis = null;
//
//        try {
//            fis = openFileInput(FILE_NAME);
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader br = new BufferedReader(isr);
//            StringBuilder sb = new StringBuilder();
//            String text;
//
//            while ((text = br.readLine()) != null) {
//                sb.append(text).append("\n");
//            }
//
//            call2.setText(sb.toString());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
