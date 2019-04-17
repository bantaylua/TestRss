package com.example.testrss;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;

    String[][] myUrlCaptionMenu = {
            {"http://www.npr.org/rss/rss.php?id=1001", "Top Stories"},
            {"http://www.npr.org/rss/rss.php?id=1003", "U.S. News"},
            {"http://www.npr.org/rss/rss.php?id=1004", "World News"},
            {"http://www.npr.org/rss/rss.php?id=1006", "Business"},
            {"http://www.npr.org/rss/rss.php?id=1007", "Health & Science"},
            {"http://www.npr.org/rss/rss.php?id=1008", "Arts & Entertainment"},
            {"http://www.npr.org/rss/rss.php?id=1012", "Politics & Society"},
            {"http://www.npr.org/rss/rss.php?id=1021", "People & Places"},
            {"http://www.npr.org/rss/rss.php?id=1057", "Opinion"},
    };

    String[] myUrlCaption = new String[myUrlCaptionMenu.length];
    String[] myUrlAddress = new String[myUrlCaptionMenu.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < myUrlCaptionMenu.length; i++){
            myUrlAddress[i] = myUrlCaptionMenu[i][0];
            myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }

        context = getApplicationContext();
        this.setTitle("NPR Headline News\n" + niceDate());

        myMainListView = (ListView) this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String urlAddress = myUrlAddress[i];
                String urlCaption = myUrlCaption[i];

                Intent callShowHeadlines = new Intent(MainActivity.this, ShowHeadlines.class);
                Bundle myData = new Bundle ();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                callShowHeadlines.putExtras(myData);

                startActivity(callShowHeadlines);

            }
        });
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }

    public static String niceDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy", Locale.US);
        return sdf.format(new Date());
    }
}
