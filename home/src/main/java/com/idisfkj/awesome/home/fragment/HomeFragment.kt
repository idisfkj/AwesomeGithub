package com.idisfkj.awesome.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.idisfkj.awesome.basic.fragment.BaseDaggerFragment
import com.idisfkj.awesome.componentbridge.app.AppBridgeInterface
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.home.BR
import com.idisfkj.awesome.home.R
import com.idisfkj.awesome.home.databinding.HomeFragmentHomeBinding
import com.idisfkj.awesome.home.fragment.di.HomeFragmentComponent
import com.idisfkj.awesome.home.fragment.di.HomeFragmentProviderModule
import com.idisfkj.awesome.home.fragment.vm.HomeVM
import timber.log.Timber

/**
 * Created by idisfkj on 2019-09-02.
 * Email : idisfkj@gmail.com.
 */
class HomeFragment : BaseDaggerFragment<HomeFragmentHomeBinding, HomeVM>() {

    override fun getVariableId(): Int = BR.vm

    override fun getLayoutId(): Int = R.layout.home_fragment_home

    override fun getViewModelClass(): Class<HomeVM> = HomeVM::class.java

    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (BridgeProviders.instance.getBridge(AppBridgeInterface::class.java)
            .getHomeFragmentComponent() as? HomeFragmentComponent.Factory)?.create(HomeFragmentProviderModule(viewModel))?.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.userData.observe(this, Observer {
            Timber.d("addObserver %s", it.followers)
        })
    }
}