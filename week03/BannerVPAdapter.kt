package com.example.flo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    private val fragmentlist : ArrayList<Fragment> = ArrayList() //이 클래스 내에서만 사용할 변수이기 때문에 private로 선언해준다.

    override fun getItemCount(): Int {
        return fragmentlist.size
    }

    /*위에처럼 써줘도 되고 아래와 같이 함수 자체를 처음부터 초기화 시킬 수도 있다.
    override fun getItemCount(): Int = fragmentlist.size
     */

    override fun createFragment(position: Int): Fragment = fragmentlist[position] //4라면 0,1,2,3이 출력될 것이다.

    fun addFragment(fragment: Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1) //새로운 값이 리스트에 추가되는 것을 말한다.
    }
}
