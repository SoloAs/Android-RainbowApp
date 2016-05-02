package surf.ru.alex_tyutyarev.rainbowapp;

import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import surf.ru.alex_tyutyarev.rainbowapp.Utils.ColorRecognizer;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        ColorRecognizer colorRecognizer = new ColorRecognizer();
        float[] itemColor = (float[])getIntent().getExtras().get("Color");
        int activityColor = Color.HSVToColor(itemColor);
        // background color set to item's
        this.getWindow().getDecorView().setBackgroundColor(activityColor);
        TextView attributesView = (TextView) findViewById(R.id.attributesView);
        TextView nameView = (TextView) findViewById(R.id.nameView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        attributesView.setText("R: " + Color.red(activityColor) + "; G: "
                + Color.green(activityColor) + "; B: " + Color.blue(activityColor));
        nameView.setText(colorRecognizer.reсognizeColor(Math.round(itemColor[0])));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
