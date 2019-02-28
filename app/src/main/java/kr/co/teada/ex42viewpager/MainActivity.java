package kr.co.teada.ex42viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //1. 대량의 Data 준비
    int[] datas=new int[]{R.drawable.gametitle_01,
            R.drawable.gametitle_02,
            R.drawable.gametitle_03,
            R.drawable.gametitle_04,
            R.drawable.gametitle_05,
            R.drawable.gametitle_06,
            R.drawable.gametitle_07,
            R.drawable.gametitle_08,
            R.drawable.gametitle_09,
            R.drawable.gametitle_10,};

    //ViewPager 참조변수(AdapterView)
    ViewPager pager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.
        pager=findViewById(R.id.pager);
        adapter=new MyAdapter(getLayoutInflater(), datas);
        pager.setAdapter(adapter);

        //<보너스 효과> 페이지 전환시 효과 (필수는 아니야)
        //페이지가 조금이라도 움직일 때마다 자동으로 발동하는 메소드를 보유한 리스너 추가
        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View view, float position) {

                view.setRotationY(position*90); //비틀어서 보여주는거---> ******************************[주사위] 랜덤
                view.setScaleX((1-Math.abs(position))/2+0.5f);
                view.setScaleY((1-Math.abs(position))/2+0.5f);

                view.setAlpha(1-Math.abs(position)); // 1.0f는 완전 잘보여 0.0f는 아예 안보여 //위치 1.0-->0.0  Alpah 0.0-->1.0 : 위치랑 알파값 반대여야 넘길때 점점 옅어지며 사라져

            }
        });
    }

    public void clickNext(View view) {
        //4. 현재 페이지 번호 알아오기
        int index=pager.getCurrentItem();

        //3. 특정 페이지 이동
        pager.setCurrentItem(index+1,true);
    }

    public void clickPrev(View view) {

        int index=pager.getCurrentItem();
        pager.setCurrentItem(index-1,true);
    }
}
