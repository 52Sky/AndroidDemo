package com.example.mywechat;
import android.app.Fragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

@SuppressLint("RestrictedApi")
public class MainActivity extends Activity implements View.OnClickListener {
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    private Fragment mTab01 = new weixinFragment();
    private Fragment mTab02 = new frgFragment();
    private Fragment mTab03 = new contactFragment();
    private Fragment mTab04 = new settingFragment();

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initFragment();
        SetSelect(0);

    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    private void initView(){
        mTabWeixin =findViewById(R.id.id_tab_weixin);
        mTabFrd = findViewById(R.id.id_tab_frd);
        mTabAddress = findViewById(R.id.id_tab_contact);
        mTabSettings = findViewById(R.id.id_tab_settings);

        mImgWeixin = findViewById(R.id.id_tab_weixin_img);
        mImgFrd = findViewById(R.id.id_tab_frd_img);
        mImgAddress = findViewById(R.id.id_tab_contact_img);
        mImgSettings = findViewById(R.id.id_tab_settings_img);

    }

    private void SetSelect(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                Log.d("setSelect","1");
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                Log.d("setSelect","2");
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                Log.d("setSelect: ","3" );
                transaction.show(mTab03);
                mImgAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                Log.d("setSelect: ", "4 ");
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;

            }
            transaction.commit();
    }

    private void hideFragment (FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    @Override
    public void onClick(View v) {
        Log.d("onClick", "1");
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_weixin:

                SetSelect(0);
                break;
            case R.id.id_tab_frd:

                SetSelect(1);
                break;
            case R.id.id_tab_contact:

                SetSelect(2);
                break;
            case R.id.id_tab_settings:

                SetSelect(3);
                break;
            default:
                break;
        }
    }
    //切换图片至暗色
    public void resetImgs(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAddress.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);

    }
}

