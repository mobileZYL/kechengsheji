package com.example.kechengsheji;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class yyActivity extends AppCompatActivity {
    private Button bt_main_lk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_yy );
        bt_main_lk=(Button)findViewById( R.id.bt_main_lk );
        bt_main_lk.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passdate();
            }
        } );
    }
    public void passdate(){
        AlertDialog dialog;
        dialog=new AlertDialog.Builder( this ).setTitle( "hello" )
                .setMessage( "你确定要离开吗？" )
                .setIcon( R.mipmap.ic_launcher )
                .setPositiveButton( "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent( yyActivity.this,kcxxActivity.class );
                        startActivity( intent );
                    }
                } )
                .setNegativeButton( "取消",null )
                .create();
        dialog.show();

    }
}
