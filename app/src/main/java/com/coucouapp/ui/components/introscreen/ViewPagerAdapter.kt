package com.coucouapp.ui.components.introscreen

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewPagerAdapter(private var activity: Context, private var layoutarray: Array<Int>) : PagerAdapter() {
     var layoutInflater: LayoutInflater? = null

    override fun instantiateItem(myContainer: ViewGroup, mPosition: Int): Any {
        layoutInflater = LayoutInflater.from(activity).context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = layoutInflater!!.inflate(layoutarray.get(mPosition), myContainer, false)
        myContainer.addView(v)
        return v
    }

    override fun getCount(): Int {
        return layoutarray.size
    }

    override fun isViewFromObject(mView: View, mObject: Any): Boolean {
        return mView === mObject
    }

    override fun destroyItem(mContainer: ViewGroup, mPosition: Int, mObject: Any) {
        val v = mObject as View
        mContainer.removeView(v)
    }
}