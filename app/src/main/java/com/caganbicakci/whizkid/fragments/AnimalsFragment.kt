package com.caganbicakci.whizkid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.whizkid.databinding.FragmentAnimalsBinding
import com.caganbicakci.whizkid.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimalsFragment : Fragment() {

    private lateinit var animalsFragmentBinding : FragmentAnimalsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        animalsFragmentBinding = FragmentAnimalsBinding.inflate(layoutInflater)
        return animalsFragmentBinding.root
    }

}