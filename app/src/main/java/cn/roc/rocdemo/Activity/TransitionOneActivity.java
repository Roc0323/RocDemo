package cn.roc.rocdemo.Activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.roc.rocdemo.R;

/**
 * Created by Roc on 2017/8/11 0011.
 */

public class TransitionOneActivity extends Activity{
    private View firstSharedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_one);
        firstSharedView=(View)findViewById(R.id.firstSharedView);
        firstSharedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TransitionOneActivity.this,TransitionTwoActivity.class);
                //startActivity(intent);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(TransitionOneActivity.this, firstSharedView, "sharedView").toBundle());
            }
        });
    }
}
