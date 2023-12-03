package com.caganbicakci.whizkid.domain.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.whizkid.R
import com.caganbicakci.whizkid.databinding.LearningItemViewBinding
import com.caganbicakci.whizkid.domain.model.LearningItem

class LearningItemAdapter(
    private val learningItemList: List<LearningItem>,
    private val learningItemClickHandler: LearningItemClickHandler) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val learningItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.learning_item_view, parent, false
        )
        return LearningItemViewHolder(learningItemBinding)
    }

    override fun getItemCount(): Int {
        Log.i("TEST",learningItemList.toString())
        return learningItemList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LearningItemViewHolder).onBind(learningItemList[position])
    }

    inner class LearningItemViewHolder(
        private val learningItemViewBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(learningItemViewBinding.root), View.OnClickListener{

        fun onBind(learningItem: LearningItem){
            val binding = learningItemViewBinding as LearningItemViewBinding
            binding.apply {
                learningItemImageView.setBackgroundResource(R.drawable.learning_item_background)
                learningItemImageView.setImageResource(learningItem.image)
                learningItemTextView.text = learningItem.title
            }
        }

        override fun onClick(p0: View?) {
            val position = bindingAdapterPosition
            learningItemClickHandler.learningItemClicked(learningItem = learningItemList[position])
        }
    }
}