package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("Eric","student",12248,true); //create an instance of user obj

        loadUserObj(user); //loading user obj to access the attributes and perform some functions

        //receiving Intent
        Intent receivingEnd = getIntent();
        int message = receivingEnd.getIntExtra("randomNum", -1); //the behind is a default value, if no value has been passed in through intent
        setRandomNum(message);
    }




    //Reacts to the user "followed" attribute
    public void loadUserObj(User user){
        //can store Button as TextView, as button is a child of TextView
        TextView followButton = findViewById(R.id.followButton); //retrieving the element, to be used to set txt later

        if(user.isFollowed() == true){                          //determining the attribute Follow is set to what
            followButton.setText("UNFOLLOW");
        }
        else{
            followButton.setText("FOLLOW");
        }
    }

    //Reacts to when the button is clicked
    public void onFollowBtnClick (View view){
        Button followButton = findViewById(R.id.followButton);

        if (followButton.getText() == "Follow"){
            followButton.setText("Unfollow"); //Thus, in the cases its a follow button, if clicked it will display "Followed" & "Unfollow" opt will be provided for the user.
            Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
        }else{
            followButton.setText("Follow");                 //the capitalization does not matter android is smart enough
            Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();   //displays toast msg, if user clicks Unfollow button, Unfollowed tst msg appears
        }

    }

    //Sets Random Number from ListActivity class
    public void setRandomNum(int randomNum){
        TextView madTxt = findViewById(R.id.helloTxt);

        madTxt.setText("MAD " + String.valueOf(randomNum));
    }


    public void onMessageBtnClick(View view){
        //intent created to traverse to the other page
        Intent myIntent = new Intent(MainActivity.this, MessageGroup.class);
        startActivity(myIntent);
    }


}