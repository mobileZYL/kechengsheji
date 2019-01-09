package com.example.kechengsheji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

import static android.R.layout.simple_list_item_1;

public class ListViewActivity extends Activity {
    ListView lvList;
    List<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initUI();
        registerForContextMenu(lvList);

        list=new ArrayList<String>();
        list.add("注册界面");
        list.add("课程信息系统");

        adapter=new ArrayAdapter<String>(this,simple_list_item_1,list);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                switch (i){
                    case 0:
                        intent.setClass(getApplicationContext(),activity_zc.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(getApplicationContext(),kcxxActivity.class);
                        startActivity(intent);
                        break;
                    /*case 2:
                        intent.setClass(getApplicationContext(),activity_cg.class);
                        startActivity(intent);
                        break;*/

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                                      //请求码               结果码       intent
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
               String msg= data.getStringExtra("msg");
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public  void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo){

        contextMenu.add(0, Menu.FIRST,0,"修改");  //代码实现
        contextMenu.add(0, Menu.FIRST+1,1,"删除");

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int i=menuInfo.position;
      //  Toast.makeText(getApplicationContext(),list.get(i),Toast.LENGTH_LONG).show();

        int itemId=item.getItemId();
        switch (itemId){
            case Menu.FIRST://修改
                break;
            case  Menu.FIRST+1://删除
                list.remove(i);
                lvList.setAdapter(adapter);
                break;
        }


        return true;
    }


    protected  void initUI(){
        lvList=findViewById(R.id.lv_listview_list);
    }
}
