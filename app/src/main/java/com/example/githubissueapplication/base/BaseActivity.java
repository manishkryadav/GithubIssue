package com.example.githubissueapplication.base;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.githubissueapplication.R;


public abstract class BaseActivity extends AppCompatActivity {
    AlertDialog alertDialogProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


}

    public void showLoadingProgressBar(String message, boolean cancalable) {

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.alert_dialog_progressbar_layout,null);
        TextView tv = (TextView) view.findViewById(R.id.idTextViewMessage);
        tv.setText(message);
        adb.setView(view);
        alertDialogProgressBar = adb.create();
        alertDialogProgressBar.setCancelable(cancalable);
        alertDialogProgressBar.show();
    }

    public void closeProgressBar() {
        if (alertDialogProgressBar == null) {
            return;
        }
        alertDialogProgressBar.hide();
    }
}