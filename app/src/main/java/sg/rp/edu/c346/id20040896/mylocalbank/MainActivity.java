package sg.rp.edu.c346.id20040896.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView uob, dbs , ocbc;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uob = findViewById(R.id.UOB);
        dbs = findViewById(R.id.DBS);
        ocbc = findViewById(R.id.OCBC);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == dbs){
            wordClicked = "DBS";
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call");
            menu.add(0,2,2,"Favourite");
        }
        else if(v == uob){
            wordClicked = "UOB";
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call");
            menu.add(0,2,2,"Favourite");

        }
        else if(v == ocbc){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call");
            menu.add(0,2,2,"Favourite");

        }


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }
    public boolean onContextItemSelected(MenuItem item){
        if(wordClicked == "DBS"){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(browserIntent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:18001111111"));

                return true;  //menu item successfully handled
            }
            else if(item.getItemId() == 2){
                dbs.setTextColor(Color.RED);
            }

        }
        else if(wordClicked == "UOB"){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
                startActivity(browserIntent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:18002222121"));

                return true;  //menu item successfully handled
            }
            else if(item.getItemId() == 2){
                dbs.setTextColor(Color.RED);
            }

        }
        else if(wordClicked == "OCBC"){
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(browserIntent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:18003633333"));

                return true;  //menu item successfully handled
            }
            else if(item.getItemId() == 2){
                dbs.setTextColor(Color.RED);
            }

        }
        return super.onContextItemSelected(item);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.chineseSelection) {
            dbs.setText("星展银行 ");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        } else if (id == R.id.EnglishSelection) {
            uob.setText("UOB");
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}