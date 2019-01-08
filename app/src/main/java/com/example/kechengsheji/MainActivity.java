
package com.example.kechengsheji;
//导入类库
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//回调函数
public class MainActivity extends Activity {
     // @Override 重写--对父类中onCreate()方法重新定义
    //控件变量声明
    EditText medtTXTAccount,medtTXTPassword;
    Button mbtnLogin,mbtnExit;
    @Override       //方法名
    protected void onCreate(Bundle savedInstanceState) {//初始化
        super.onCreate(savedInstanceState);//调用父类的onCreate()
        setContentView(R.layout.activity_main);//给Activity设定界面文件
        Log.i("LiftCycle","onCreate()");//日志信息
        iniUI();
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//处理单元
                //获取账号和密码
                String account= medtTXTAccount.getText().toString().trim();
                String password=medtTXTPassword.getText().toString().trim();
                //判断
                if(account.equals("admin")&&password.equals("123456")){
                    Intent intent=new Intent(getApplicationContext(),ListViewActivity.class);//显式启动
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"登录失败！",Toast.LENGTH_LONG).show();
                }
            }
        });
        mbtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //选项菜单初始化回调方法
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.mu_mainactivity, menu);
       return true;//true：显示菜单；false:不显示
   }
    public static class FireMissilesDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("message")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            return builder.create();
        }
    }
    //对话框内部类
    public  static  class ExitDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle saveedInstanceState){
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setTitle("退出");

            builder.setMessage("确定要退出？");

            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    getActivity().finish();
                }
            });
            return builder.create();
        }
    }

    public  static  class SettingDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle saveedInstanceState){
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setTitle("系统设置");

            String[] item={"保存账号","保存密码"};
            boolean[] state={false,false};
            builder.setMultiChoiceItems(item, state, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                }
            });

            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {                    //
                }
            });
            return builder.create();
        }
    }

    public  static  class HelpDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle saveedInstanceState){
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setTitle("帮助");
            LayoutInflater inflater = getActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.help_layout,null));

            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {                    //
                }
            });
            return builder.create();
        }
    }

   @Override
   public  boolean onOptionsItemSelected(MenuItem item){
       switch (item.getItemId()){
           case R.id.item_menu_mainactivity_register:
               Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
               startActivity(intent);
               return true;
           case R.id.item_menu_mainacitvity_setting:
               SettingDialog settingDialog=new SettingDialog();
               settingDialog.show(getFragmentManager(),"setting");
               return true;
           case  R.id.item_menu_mainactivity_help:
               HelpDialog helpDialog=new HelpDialog();
               helpDialog.show(getFragmentManager(),"help");
               return true;
           case R.id.item_menu_mainactivity_exit:
               ExitDialog exitDialog=new ExitDialog();
               exitDialog.show(getFragmentManager(),"exit");
               return true;
           default:
               return false;
       }
   }



    @Override
    public void onStart(){//界面可视
        super.onStart();
        Log.i("LiftCycle","onStart()");//日志信息
    }
    @Override
    public void onResume(){//界面可操作
        super.onResume();
        Log.i("LiftCycle","onResume()");//日志信息
    }
    @Override
    public void onPause(){//界面不可操作，但部分可视
        super.onPause();
        Log.i("LiftCycle","onPause()");//日志信息
    }

    @Override
    public void onStop(){//程序停止，界面不可见
        super.onStop();
        Log.i("LiftCycle","onStop()");//日志信息
    }
    @Override
    public void onDestroy(){//程序销毁，没缓存信息
        super.onDestroy();
        Log.i("LiftCycle","onDestroy()");//日志信息
    }

    @Override
    public void onRestart(){//未销毁前，重新启动程序
        super.onRestart();
        Log.i("LiftCycle","onRestart()");//日志信息
    }

    //初始化界面，获取界面中的控件
    public void iniUI(){
        //获取控件
        medtTXTAccount=findViewById(R.id.edtTXT_main_inputAccount);
        medtTXTPassword=findViewById(R.id.edtTXT_main_inputpassword);
        mbtnLogin=findViewById(R.id.btn_main_login);
        mbtnExit=findViewById(R.id.btn_main_exit);
    }
}
