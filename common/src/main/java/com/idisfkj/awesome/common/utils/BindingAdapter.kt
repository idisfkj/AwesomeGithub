package com.idisfkj.awesome.common.utils

import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("app:addTextChangedListener")
    fun addTextChangedListener(view: EditText, textWatcher: TextWatcher) {
        view.addTextChangedListener(textWatcher)
    }

    @JvmStatic
    @BindingAdapter("app:actionListener")
    fun addActionListener(view: EditText, actionListener: TextView.OnEditorActionListener) {
        view.setOnEditorActionListener(actionListener)
    }

    // -------- ViewPager start --------
    @JvmStatic
    @BindingAdapter("app:adapter")
    fun setAdapter(viewPager: ViewPager, adapter: PagerAdapter) {
        viewPager.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:addOnPageChangedListener")
    fun addOnPageChangedListener(viewPager: ViewPager, listener: ViewPager.OnPageChangeListener) {
        viewPager.addOnPageChangeListener(listener)
    }

    @JvmStatic
    @BindingAdapter("app:setCurrentItem")
    fun setCurrentItem(viewPager: ViewPager, pos: Int) {
        viewPager.setCurrentItem(pos, false)
    }

    @JvmStatic
    @BindingAdapter("app:setOffscreenPageLimit")
    fun setOffscreenPageLimit(viewPager: ViewPager, offscreenPageLimit: Int) {
        viewPager.offscreenPageLimit = offscreenPageLimit
    }
    // -------- ViewPager end --------

    @JvmStatic
    @BindingAdapter("app:adapter")
    fun setAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:setOnNavigationItemSelectedListener")
    fun setOnNavigationItemSelectedListener(
        bottomNavigationView: BottomNavigationView,
        listener: BottomNavigationView.OnNavigationItemSelectedListener
    ) {
        bottomNavigationView.setOnNavigationItemSelectedListener(listener)
    }

}

