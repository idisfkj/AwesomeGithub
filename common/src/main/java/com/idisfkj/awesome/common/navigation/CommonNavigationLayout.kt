package com.idisfkj.awesome.common.navigation

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.idisfkj.awesome.common.R

/**
 * Created by idisfkj on 2019-08-29.
 * Email : idisfkj@gmail.com.
 */
class CommonNavigationLayout @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(mContext, attrs, defStyleAttr), View.OnClickListener {
    private var mView: View? = null
    private var mTitleView: TextView? = null
    private var mBackView: ImageView? = null
    private var mRightView: ImageView? = null
    private var mLineView: View? = null
    private var mTitle: String? = null
    private var mShowLine: Boolean = true
    private var mShowRightIcon: Boolean = false
    private var mBackgroundColor: Drawable? = null
    private var mRightDrawable: Drawable? = null
    private var mBackDrawable: Drawable? = null
    private var mTitleColor: ColorStateList? = null
    private var mNavigationListener: OnNavigationListener? = null

    init {
        if (attrs != null) {
            obtainStyledAttributes(attrs, defStyleAttr)
        }
        initView()
        setupListener()
    }

    private fun obtainStyledAttributes(attrs: AttributeSet, defStyleAttr: Int) {
        val ta = mContext.obtainStyledAttributes(attrs, R.styleable.CommonNavigationLayout, defStyleAttr, 0)
        if (ta != null) {
            mTitle = ta.getString(R.styleable.CommonNavigationLayout_nb_title)
            mShowLine = ta.getBoolean(R.styleable.CommonNavigationLayout_nb_show_line, true)
            mShowRightIcon = ta.getBoolean(R.styleable.CommonNavigationLayout_nb_show_right_icon, false)
            mBackgroundColor = ta.getDrawable(R.styleable.CommonNavigationLayout_nb_background)
            mBackDrawable = ta.getDrawable(R.styleable.CommonNavigationLayout_nb_back_icon)
            mRightDrawable = ta.getDrawable(R.styleable.CommonNavigationLayout_nb_right_icon)
            mTitleColor = ColorStateList.valueOf(
                ta.getColor(
                    R.styleable.CommonNavigationLayout_nb_title_color,
                    ContextCompat.getColor(mContext, R.color.primaryLightColor)
                )
            )
            ta.recycle()
        }
    }

    private fun initView() {
        mView = LayoutInflater.from(mContext).inflate(R.layout.common_navigation_layout, this, false)
        mBackView = mView?.findViewById(R.id.back_image)
        mTitleView = mView?.findViewById(R.id.title)
        mRightView = mView?.findViewById(R.id.right_image)
        mLineView = mView?.findViewById(R.id.navigation_line)
        mTitleView?.text = mTitle
        if (mTitleColor != null) {
            mTitleView?.setTextColor(mTitleColor)
        }
        mLineView?.visibility = if (mShowLine) View.VISIBLE else View.GONE
        mRightView?.visibility = if (mShowRightIcon) View.VISIBLE else View.GONE
        if (mBackgroundColor != null) {
            mView?.background = mBackgroundColor
        }
        if (mBackDrawable != null) {
            mBackView?.setImageDrawable(mBackDrawable)
        }
        if (mRightDrawable != null) {
            mRightView?.setImageDrawable(mRightDrawable)
        }
        mNavigationListener = OnNavigationListenerImpl(context)
        addView(mView)
    }

    private fun setupListener() {
        mBackView?.setOnClickListener(this)
        mRightView?.setOnClickListener(this)
    }

    fun setTitle(titleContent: String) {
        mTitle = titleContent
        mTitleView?.text = titleContent
    }

    fun setBackgroundColor(drawable: Drawable) {
        mView?.background = drawable
    }

    fun setBackDrawable(drawable: Drawable) {
        mBackView?.setImageDrawable(drawable)
    }

    fun setTitleColor(@ColorInt color: Int) {
        mTitleView?.setTextColor(color)
    }

    fun setNavigationLineVisible(visible: Boolean) {
        mShowLine = visible
        mLineView?.visibility = if (visible) View.VISIBLE else View.GONE
    }

    /**
     * set right icon drawable
     *
     * @param drawable
     */
    fun setRightDrawable(drawable: Drawable) {
        mRightView?.setImageDrawable(drawable)
    }

    /**
     * set right icon visibility
     *
     * @param visible
     */
    fun setRightViewVisible(visible: Boolean) {
        mShowRightIcon = visible
        mRightView?.visibility = if (visible) View.VISIBLE else View.GONE
    }

    fun setNavigationListener(navigationListener: OnNavigationListener) {
        this.mNavigationListener = navigationListener
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.back_image -> mNavigationListener?.onBackClick()
            R.id.right_image -> mNavigationListener!!.onRightIconClick()
            else -> {
            }
        }
    }

}
