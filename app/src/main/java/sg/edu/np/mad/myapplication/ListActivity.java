package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void onImageViewClick (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the attributes in an Alert Dialog
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);  //determines if the Alert Dialog disappear when pressed on anywhere of the screen
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
		        //<action>
            }
        });
        builder.setNegativeButton("View", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
		        //<action> Random int generated, MainActivity launched, Random int sent over
                Random random = new Random();
                int randomNumber = random.nextInt(100-1) + 1; //random.nextInt(max–min) + min;

                //intent created to sent Random int over
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                myIntent.putExtra("randomNum", randomNumber);
                startActivity(myIntent);

            }
        });

        //Displaying the Alert Dialog
        AlertDialog alert = builder.create();
        alert.show();

    }
}