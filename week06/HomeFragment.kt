package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding
import com.google.gson.Gson

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        binding.homeAlbumImgIv1.setOnClickListener {
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm , AlbumFragment())
//                .commitAllowingStateLoss()
//        }

        //데이터 리스트 생성 더미 데이터
        albumDatas.apply {
            add(Album("Black Mamba","에스파 (AESPA)",R.drawable.img_album_exp3))
            add(Album("Sticker","NCT 127",R.drawable.img_album_exp4))
            add(Album("beside you","Keshi",R.drawable.img_album_exp5))
            add(Album("Dangerously","Charile Puth",R.drawable.img_album_exp6))
            add(Album("Butter","방탄소년단 (BTS)",R.drawable.img_album_exp))
            add(Album("Lilac","아이유 (IU)",R.drawable.img_album_exp2))
        }

        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        albumRVAdapter.setMyItemClickListener(object: AlbumRVAdapter.MyItemClickListener{
            override fun onItemClick(album: Album) {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm , AlbumFragment().apply { 
                    arguments = Bundle().apply { 
                        val gson = Gson()
                        val albumJson = gson.toJson(album)
                        putString("album",albumJson)
                    }
                })
                .commitAllowingStateLoss()
            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }
        })
        
        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        return binding.root
    }
}
