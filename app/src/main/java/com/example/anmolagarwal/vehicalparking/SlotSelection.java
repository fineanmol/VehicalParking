package com.example.anmolagarwal.vehicalparking;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SlotSelection extends AppCompatActivity {
    private LinearLayout slot_inflate_ll;
    List<RadioGroup> radioGroups = new ArrayList<RadioGroup>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_selection);

        slot_inflate_ll = (LinearLayout) findViewById(R.id.slot_inflate_ll);  // ll is the layout where your inflated layout will be added
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i = 0; i < 6; i++) {
            View slotview = inflater.inflate(R.layout.slot_selection, slot_inflate_ll, false);
            TextView slot_floor_txt_view = (TextView) slotview.findViewById(R.id.slot_floor_txt_view);
            RadioGroup toggleGroup = (RadioGroup) slotview.findViewById(R.id.toggleGroup100);
            toggleGroup.setId(i + 1);
            slot_floor_txt_view.setText("Floor " + (i + 1));
            toggleGroup.setTag("Floor " + (i + 1));
            for (int j = 0; j < toggleGroup.getChildCount(); j++) {
                final Button view = (Button) toggleGroup.getChildAt(j);
                view.setId((i * 10) + j);
            }
            slot_inflate_ll.addView(slotview);
            radioGroups.add(toggleGroup);
        }
    }

    public void onToggle(View view) {
        resetButtonsBg();
        RadioGroup group = ((RadioGroup) view.getParent());
        Button togglebtn = (Button) view;
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            togglebtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_corners_blue));
        } else {
            togglebtn.setBackground(getResources().getDrawable(R.drawable.round_corners_blue));
        }

        togglebtn.setTag(1);
        Log.d("sree", "Selected slot:" + togglebtn.getText() + "  Floor:" + group.getTag() + "*");

    }

    public void resetButtonsBg() {
        for (int z = 0; z < radioGroups.size(); z++) {
            for (int j = 0; j < radioGroups.get(z).getChildCount(); j++) {
                final Button view = (Button) radioGroups.get(z).getChildAt(j);
                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    //noinspection deprecation
                    view.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_corners));
                } else {
                    view.setBackground(getResources().getDrawable(R.drawable.round_corners));
                }
                view.setTag(0);
            }
        }
    }

}
