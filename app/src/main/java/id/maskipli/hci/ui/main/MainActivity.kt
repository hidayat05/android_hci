package id.maskipli.hci.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.maskipli.hci.R
import id.maskipli.hci.adapter.GroupSectionAdapter
import id.maskipli.hci.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val sectionAdapter by lazy {
        GroupSectionAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
            .setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )
        lifecycle.addObserver(viewModel)
        initView()
        observeData()
    }

    private fun initView() {
        loading?.show()

        recycler?.apply {
            adapter = sectionAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeData() {
        viewModel.apply {
            isLoading.observe(this@MainActivity, Observer { isLoading ->
                if (isLoading) loading?.show() else loading?.hide()
            })

            errorMessage.observe(this@MainActivity, Observer { message ->
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
            })

            listSection.observe(this@MainActivity, Observer {
                sectionAdapter.apply {
                    listSection = it.toMutableList()
                    notifyDataSetChanged()
                }
            })
        }
    }
}
