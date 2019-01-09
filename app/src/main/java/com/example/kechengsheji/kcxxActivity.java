package com.example.kechengsheji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kcxxActivity extends AppCompatActivity {
    private Button bt_main_yy;
    private Button bt_main_jv;
    private Button bt_main_fh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_kcxx );
        bt_main_fh=(Button)findViewById( R.id.bt_main_fh );
        bt_main_fh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passdate();
            }
        } );
       bt_main_yy=(Button)findViewById( R.id.bt_main_yy );
       bt_main_yy.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               passdate2();
           }
       } );
       bt_main_jv=(Button)findViewById( R.id.bt_main_jv );
       bt_main_jv.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               passdate3();
           }
       } );
    }
    public void passdate(){
        Intent intent=new Intent( this,MainActivity.class );
        startActivity( intent );
    }
    private void passdate2(){
        Intent intent=new Intent( this,yyActivity.class );
        startActivity( intent );
    }
    private void passdate3(){
        Intent intent=new Intent( this,jvActivity.class );
        startActivity( intent );
    }

}
