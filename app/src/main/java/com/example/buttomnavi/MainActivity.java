package com.example.buttomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;                                  //바텀 네비계이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
                                                                                        //해당 밀출코드가 deprecated된다는 내용이 안드로이드 developer에 없는 어케된건지..? 궁금
                                                                                        //구글에 찾아보니깐 developer에는 나와있지 않은데 블로그글을 찾아보니 gihub에서 deprecated 되었다고 한다.
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {            //각각의 바텀 뷰의 메뉴 종류에 해당하는 frag를 연결
                switch (item.getItemId()){
                    case R.id.action_airplane:
                        setFrag(0);
                        break;
                    case R.id.action_airport:
                        setFrag(1);
                        break;
                    case R.id.action_bt:
                        setFrag(2);
                        break;
                    case R.id.action_call:
                        setFrag(3);
                        break;
                    case R.id.action_run:
                        setFrag(4);
                        break;
                }
            }
        });


        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0);                                                                         //프래그먼트이 첫화면을 지정 해주는 것
    }


    //프래그먼트 교체가 일어나는 실행문
    private void setFrag(int n){
        fm =getSupportFragmentManager();                                                    //fm은 플래그를 관리하기 위한 플래그 메너저 생성
        ft = fm.beginTransaction();                                                         // beginTransction() 변경을 시작하는 메소드
        switch(n){
            case 0:
                ft.replace(R.id.main_frame,frag1);                                          //기존 플래그먼트(화면)을 다른 플래그먼트로 바꾸는 첫번재 인자는 기존 플래그먼트 두번째 인자는 바뀔 플래그먼트
                ft.commit();                                                                //commit을 해줘야 갱신이 됩니다.
                break;
            case 1:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,frag5);
                ft.commit();
                break;
        }
    }
}