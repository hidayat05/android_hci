package id.maskipli.hci.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.maskipli.hci.databinding.ItemHeaderSectionBinding
import id.maskipli.hci.model.Item
import id.maskipli.hci.model.Section

/**
 * @author hidayat @on 21/07/19
 **/
class GroupSectionAdapter : RecyclerView.Adapter<GroupSectionAdapter.HeaderTitleViewHolder>() {

    var listSection = mutableListOf<Section>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderTitleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHeaderSectionBinding.inflate(layoutInflater, parent, false)
        return HeaderTitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderTitleViewHolder, position: Int) {
        val section = listSection[position]
        val childAdapter = ChildAdapter(position)
        childAdapter.listItem = section.listItems as MutableList<Item>

        holder.apply {
            val layoutManager = if (position == ChildAdapter.TYPE_PRODUCT) {
                GridLayoutManager(this.itemView.context, 3)
            } else {
                LinearLayoutManager(this.itemView.context)
            }
            viewBinding.childRecyclerView.apply {
                adapter = childAdapter
                this.layoutManager = layoutManager
            }
            bind(section.sectionTitle, position)
        }
    }

    override fun getItemCount() = listSection.size


    class HeaderTitleViewHolder(val viewBinding: ItemHeaderSectionBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(title: String?, position: Int) {
            viewBinding.apply {
                this.title = title
                isElevation = position == 0
                executePendingBindings()
            }
        }
    }
}