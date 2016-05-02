package surf.ru.alex_tyutyarev.rainbowapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> list = new ArrayList<String>();
        for(int i = 0; i < 360; i++)
            list.add("");

        ListView colorsView = (ListView) findViewById(R.id.colorsView);
        if (colorsView != null) {
            colorsView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView textView = ((TextView) view.findViewById(android.R.id.text1));
                    textView.setMinHeight(0); // Min Height
                    textView.setHeight(dpToPx(100)); // Height
                    int myColor = Color.HSVToColor(new float[]{(float) position, 1f, 1f});
                    textView.setBackgroundColor(myColor);

                    return view;

                }
            } );

            colorsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), ColorActivity.class);
                    float[] HSVColor = new float[]{(float)position, 1f, 1f};
                    intent.putExtra("Color", HSVColor);
                    startActivity(intent);
                }
            });
        }
    }
}
