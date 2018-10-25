package com.example.guruvenkatesh.rmk_gps;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Mapactivity extends AppCompatActivity {
     private  static final String TAG = "MapActivity";
    public  static final int ERROR_DIALOG_REQUEST = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapactivity);
        TextView latitude = (TextView) findViewById(R.id.latitude);
        TextView longtitude = (TextView) findViewById(R.id.longtitude);
        TextView address = (TextView) findViewById(R.id.address);
        Bundle bundle = getIntent().getExtras();
        latitude.setText(bundle.getString("latitude"));
        longtitude.setText(bundle.getString("longtitude"));
        address.setText(bundle.getString("address"));
        if(isServicesOK())
        {
            init();
        }
    }
    private void init()
    {
        Button BtnMap =(Button) findViewById(R.id.btnMap);
        BtnMap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {  Bundle bundle = getIntent().getExtras();

                Intent intent = new Intent(Mapactivity.this,Display_map.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    public boolean isServicesOK()
    {
        Log.d(TAG,"google play services checking" );
        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Mapactivity.this);
        if(available== ConnectionResult.SUCCESS)
        {
            Log.d(TAG,"Goolge play services working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            Log.d(TAG,"error ocured in Goolge play services but we can fix it");
            Dialog dialog=GoogleApiAvailability.getInstance().getErrorDialog(Mapactivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else
        {
            Log.d(TAG,"Goolge play services not working");

        }
        return false;
    }
}
