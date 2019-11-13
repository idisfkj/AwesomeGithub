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
import com.idisfkj.awesome.common.extensions.visibleOrGone

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
        mContext.obtainStyledAttributes(
            attrs,
            R.styleable.CommonNavigationLayout,
            defStyleAttr,
            0
        ).run {
            mTitle = getString(R.styleable.CommonNavigationLayout_nb_title)
            mShowLine = getBoolean(R.styleable.CommonNavigationLayout_nb_show_line, true)
            mShowRightIcon =
                getBoolean(R.styleable.CommonNavigationLayout_nb_show_right_icon, false)
            mBackgroundColor = getDrawable(R.styleable.CommonNavigationLayout_nb_background)
            mBackDrawable = getDrawable(R.styleable.CommonNavigationLayout_nb_back_icon)
            mRightDrawable = getDrawable(R.styleable.CommonNavigationLayout_nb_right_icon)
            mTitleColor = ColorStateList.valueOf(
                getColor(
                    R.styleable.CommonNavigationLayout_nb_title_color,
                    ContextCompat.getColor(mContext, R.color.primaryLightColor)
                )
            )
            recycle()
        }
    }

    private fun initView() {
        mView = LayoutInflater.from(mContext)
            .inflate(R.layout.common_navigation_layout, this, false).apply {
                mBackView = findViewById<ImageView>(R.id.back_image).apply {
                    mBackDrawable?.let { background = it }
                }
                mTitleView = findViewById<TextView>(R.id.title).apply {
                    text = mTitle
                    mTitleColor?.let { setTextColor(it) }
                }
                mRightView = (findViewById<ImageView>(R.id.right_image)).apply {
                    visibleOrGone(mShowRightIcon)
                    mRightDrawable?.let { setImageDrawable(it) }
                }
                mLineView = findViewById<View>(R.id.navigation_line).apply {
                    visibleOrGone(mShowLine)
                }
                mBackgroundColor?.let { background = it }
                mNavigationListener = OnNavigationListenerImpl(context)
                addView(this)
            }
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
        mLineView?.visibleOrGone(visible)
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
        mRightView?.visibleOrGone(visible)
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
