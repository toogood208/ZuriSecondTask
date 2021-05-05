package hfad.com.zurisecondtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hfad.com.zurisecondtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // setup view bindibg
    var binding : ActivityMainBinding? = null
    var adapter: FactAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpFact()
    }

    // connect the data to the view via adapter
    private fun setUpFact(){
        adapter = FactAdapter(this, DummyData.funFact)
        binding?.factListview?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}