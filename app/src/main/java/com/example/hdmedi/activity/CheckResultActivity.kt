package com.example.hdmedi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hdmedi.R
import com.example.hdmedi.SurveyAllAdapter
import com.example.hdmedi.SurveyAllViewModel
import com.example.hdmedi.databinding.ActivityCheckResultBinding

class CheckResultActivity : BaseActivity<ActivityCheckResultBinding>(R.layout.activity_check_result) {

    private lateinit var surveyAllAdapter: SurveyAllAdapter
    private lateinit var viewModel : SurveyAllViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        viewModel = ViewModelProvider(this).get(SurveyAllViewModel::class.java)

        surveyAllAdapter = SurveyAllAdapter(ArrayList())
        binding.rvSurveyAll.adapter = surveyAllAdapter
        binding.rvSurveyAll.layoutManager = LinearLayoutManager(this)

        viewModel.surveyAllList.observe(this, {
            result->
            surveyAllAdapter = SurveyAllAdapter(result)
            binding.rvSurveyAll.adapter = surveyAllAdapter

        }

        )
    }
}