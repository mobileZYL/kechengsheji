package com.example.kechengsheji;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends Activity {
    //声明变量
    EditText medtTXTAccount,medtTXTPSW,medtTXTRPSW,medtTXTName,medtTXTGrade,medtTXTSNum,medtTXTPhoneNum;
    Button mbtnRegiset,mbtnReset,mbtnOpenCamera;
    ImageView mivPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
        mbtnRegiset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、读取用户输入的内容
                String account=medtTXTAccount.getText().toString().trim();
                String password=medtTXTPSW.getText().toString().trim();
                String rePassword=medtTXTRPSW.getText().toString().trim();
            }
        });
        mbtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将输入框内容置为空(null)
                medtTXTAccount.setText(null);
                medtTXTPSW.setText(null);
                medtTXTRPSW.setText(null);
                medtTXTName.setText(null);
                medtTXTGrade.setText(null);
                medtTXTSNum.setText(null);
                medtTXTPhoneNum.setText(null);
            }
        });
        mbtnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
               // startActivity(intent);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if(resultCode==RESULT_OK){
                Bitmap image=(Bitmap)data.getParcelableExtra("data");
                mivPhoto.setImageBitmap(image);
            }
        }
    }

    public void initUI(){
        medtTXTAccount=findViewById(R.id.edtTxt_register_account);
        medtTXTPSW=findViewById(R.id.edtTXT_register_password);
        medtTXTRPSW=findViewById(R.id.edtTXT_register_rePassword);
        medtTXTName=findViewById(R.id.edtTXT_register_name);
        medtTXTGrade=findViewById(R.id.edtTXT_register_grade);
        medtTXTSNum=findViewById(R.id.edtTXT_register_sNum);
        medtTXTPhoneNum=findViewById(R.id.edtTXT_register_phoneNum);
        mbtnRegiset=findViewById(R.id.btn_register_register);
        mbtnReset=findViewById(R.id.btn_register_reset);
        mbtnOpenCamera=findViewById(R.id.btn_register_opencamera);
        mivPhoto=findViewById(R.id.iv_register_photo);

    }

}
