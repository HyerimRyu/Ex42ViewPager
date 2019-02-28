package kr.co.teada.ex42viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyAdapter extends PagerAdapter {

    //3. int형 배열 참조변수 만들어 : getCount() 의 return에 알려주기 위해서
    int[] datas;

    //7. inflater 참조하고, 4번 파라미터에 추가해줘
    LayoutInflater inflater;

    //4. 생성자
    public MyAdapter(LayoutInflater inflater, int[] datas){
        this.inflater=inflater;
        this.datas=datas;
    }

    //1. ViewPager 에 보여줄 View 만드는 작업 메소드
    //ViewPager 에 의해서 자동으로 호출되는 메소드
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //6. 첫 번째 파라미터 : ViewGroup container 누구야? --> View Pager 참조변수
        //   두 번째 파라미터 : position : 페이지번호(0번 부터)

        //layout 폴더에 있는 page.xml 설계도면으로 View 객체 생성
        //xml 문서를 View 객체로 만들어주는 (inflater: 부풀리는) 객체에게 요청

        //8. inflater 불러서 추가
        View view=inflater.inflate(R.layout.page,null);

        //12. xml 도면대로 만들어진 페이지(view)의 Contents 연결하기
        ImageView iv=view.findViewById(R.id.iv);
        iv.setImageResource(datas[position]);      //position!!! 주의

        //9. 만들어진 페이지(view)를 ViewPager 에 추가!!!
        container.addView(view);

        //10. 만들어진 뷰가 ViewPager의 뷰에 맞는지 검증하도록 리턴시켜
        return view;
    }

    //11. 뷰페이저가 보여줄 View 와 instantiateItem() 메소드의 리턴된 뷰가 같은지 검증하는 메소드
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view==obj;
    }

    //2. ViewPager 가 필요없다고 생각하는 뷰를 없애는 메소드
    //ViewPager 에 의해서 자동으로 호출되는 메소드
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       //13.  제거될 대상:object(3번째 파라미터)
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return datas.length;   //5. 리턴에 배열 길이 알려줘
    }


}
