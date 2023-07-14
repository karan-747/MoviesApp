package com.example.moviesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.presentation.fragments.MoviesFragment
import com.example.moviesapp.presentation.fragments.PeopleFragment
import com.example.moviesapp.presentation.fragments.TvShowsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        binding.tabLayout.apply {
//
//            tabGravity = TabLayout.GRAVITY_FILL
//        }
        val myAdapter = CategoryTabAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter = myAdapter

//       binding.tabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
//           override fun onTabSelected(tab: TabLayout.Tab?) {
//               binding.viewPager.currentItem = tab?.position!!
//           }
//
//           override fun onTabUnselected(tab: TabLayout.Tab?) {
//               //TODO("Not yet implemented")
//           }
//
//           override fun onTabReselected(tab: TabLayout.Tab?) {
//               //TODO("Not yet implemented")
//           }
//
//       })

        binding.viewPager.registerOnPageChangeCallback( object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
             // binding.tabLayout.setScrollPosition(position,0F,false)
            }
        })

    }




    inner class CategoryTabAdapter(private val myFragmentManager: FragmentManager,
            private val myLifecycle: androidx.lifecycle.Lifecycle) : FragmentStateAdapter(myFragmentManager , myLifecycle){
        override fun getItemCount(): Int {
            return  3
        }

        override fun createFragment(position: Int): Fragment {
           return  when(position){

                0->{
                    MoviesFragment()
                }
                1->{
                    TvShowsFragment()
                }
                2->{
                    PeopleFragment()
                }

               else->{
                   MoviesFragment()
               }
            }
        }

    }
}