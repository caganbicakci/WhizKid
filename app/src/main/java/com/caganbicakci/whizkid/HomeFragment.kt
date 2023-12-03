package com.caganbicakci.whizkid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.caganbicakci.whizkid.databinding.FragmentHomeBinding
import com.caganbicakci.whizkid.domain.model.LearningItem
import com.caganbicakci.whizkid.domain.recyclerview.LearningItemAdapter
import com.caganbicakci.whizkid.domain.recyclerview.LearningItemClickHandler
import com.caganbicakci.whizkid.domain.recyclerview.LearningItemDecoration
import com.caganbicakci.whizkid.domain.viewmodel.LearningItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), LearningItemClickHandler {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private val learningItemViewModel : LearningItemViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeFragmentBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val learningItemAdapter = LearningItemAdapter(learningItemViewModel.learningItems,this)
        val gridLayoutManager = GridLayoutManager(context,2)
        homeFragmentBinding.learningItemRecyclerView.apply {
            addItemDecoration(LearningItemDecoration(20))
            layoutManager = gridLayoutManager
            adapter = learningItemAdapter
        }
    }

    override fun learningItemClicked(learningItem: LearningItem) {

    }
}