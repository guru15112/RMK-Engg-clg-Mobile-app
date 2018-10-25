package com.example.guru.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

/**
* Created by Guru on 5/31/2017.
 **/

public class Menuhandling extends Activity{



    public static Intent processmenu(MenuItem item,Context context) {
        Intent intent=new Intent();
try {


   switch (item.getItemId()) {

       case R.id.home:
           intent=new Intent(context,Homescreen.class);
           break;
        case R.id.news:
            intent=new Intent(context,News.class);
            break;
       case R.id.gallery:
           intent=new Intent(context,Gallery.class);
           break;
       case R.id.chairman:
           intent = new Intent(context, Chairman_menu.class);
           break;
       case R.id.vice_chairman:
           intent = new Intent(context, ViceChairman.class);
           break;
       case R.id.management:
           intent = new Intent(context, Management.class);
           break;
       case R.id.chairman_message:
           intent = new Intent(context, Chairman_message.class);
           break;
       case R.id.vision_mission:
           intent = new Intent(context, Vision_and_mission.class);
           break;
       case R.id.governance_board:
           intent = new Intent(context, Governance_board.class);
           break;
       case R.id.principal:
           intent = new Intent(context, Principal.class);
           break;
       case R.id.dean:
           intent = new Intent(context, Dean.class);
           break;
       case R.id.academic_co_ordinator:
           intent = new Intent(context, Academic_co_ordinator.class);
           break;
       case R.id.hod:
           intent = new Intent(context, Hod.class);
           break;
       case R.id.admission_procedcure:
           intent = new Intent(context, Administration_procedure.class);
           break;
        case R.id.academics:
            intent=new Intent(context,Contactus.class);
            break;
        case R.id.general_facilities:
           intent=new Intent(context,General_facilities.class);
           break;
       case R.id.green_campus:
           intent=new Intent(context,Green_campus.class);
           break;
       case R.id.central_library:
           intent=new Intent(context,Contactus.class);
           break;
       case R.id.hostel:
           intent=new Intent(context,Hostel.class);
           break;
       case R.id.transport:
           intent=new Intent(context,Contactus.class);
           break;
       case R.id.hospital:
           intent=new Intent(context,Hospital.class);
           break;
       case R.id.gymnasium:
           intent=new Intent(context,Gymnasium.class);
           break;
        case R.id.contact_us:
            intent=new Intent(context,Contactus.class);
            break;
        case R.id.log_out:
            intent=new Intent(context,login.class);

           break;



}

}
catch(Exception e){
        }
        return intent;
    }
}



