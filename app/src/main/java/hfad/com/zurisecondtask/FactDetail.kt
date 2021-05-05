package hfad.com.zurisecondtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hfad.com.zurisecondtask.databinding.ActivityFactDetailBinding

class FactDetail : AppCompatActivity() {

    // setup binding
    private var binding: ActivityFactDetailBinding? = null

    // recieve the extra details
    private var logo = 0
    private var name:String? = null
    private var detail:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFactDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRA, 0)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRA)
        detail = intent.getStringExtra(FactAdapter.FACT_EXTRA)

        setUpFactDetails()

    }

    private fun  setUpFactDetails(){

        binding?.detailTv?.text = detail
        binding?.logoTv?.setImageResource(logo)
        title = name

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}