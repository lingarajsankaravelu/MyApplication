package lingaraj.hourglass.in.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    BubblePicker picker;
    private final String TAG = "BUBBLE CLICK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picker = (BubblePicker) findViewById(R.id.bubble_picker);
        final String[] titles = getResources().getStringArray(R.array.student_report_options);
        final Drawable transparentDrawable = new ColorDrawable(Color.TRANSPARENT);
        final Typeface font = Typeface.DEFAULT;

        picker.setItems(new ArrayList<PickerItem>(){{
            for (int i=0;i<titles.length;i++)
            {
             /*   add(new PickerItem(titles[i], transparentDrawable,false,
                        ContextCompat.getColor(MainActivity.this, android.R.color.white),
                        new BubbleGradient(getClassColor(i+1),getClassColor(i+1))));
               */
             add(new PickerItem(titles[i],transparentDrawable,false,getClassColor(i+1),new BubbleGradient(getClassColor(i+1),getClassColor(i+1)),10,font,ContextCompat.getColor(getApplicationContext(),android.R.color.white),24,null,false));


            }
        }});
        picker.setBubbleSize(20);
        picker.setCenterImmediately(true);
        picker.setSelected(true);
        picker.setMaxSelectedCount(2);
        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                Log.d(TAG,"Bubble Selected");
                if (!pickerItem.isSelected())
                {
                    picker.getSelectedItems().clear();
                }


                Log.d(TAG,"Bubble:"+pickerItem.getTitle());
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {
                Log.d(TAG,"Bubble Deselected");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        picker.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        picker.onPause();
    }
    public int getClassColor(int i) {
        switch (i) {
            case 1:
                return ContextCompat.getColor(getApplicationContext(),R.color.classColor1);
            case 2:
                return ContextCompat.getColor(getApplicationContext(),R.color.classColor2);
            case 3:
                return ContextCompat.getColor(getApplicationContext(),R.color.classColor3);
            case 4:
                return ContextCompat.getColor(getApplicationContext(),R.color.classColor4);
            default:
                return ContextCompat.getColor(getApplicationContext(),R.color.classColor16);
        }
    }


}
