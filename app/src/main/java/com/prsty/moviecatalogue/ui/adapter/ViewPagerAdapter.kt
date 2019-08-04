package com.prsty.moviecatalogue.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(
    private val fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager) {

    val mFragmentList : MutableList<Fragment> = mutableListOf()
    val mFragmentTitleList : MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return  mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }

}