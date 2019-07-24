package id.maskipli.hci.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.maskipli.hci.databinding.ItemArticleBinding
import id.maskipli.hci.databinding.ItemProductBinding
import id.maskipli.hci.model.Item
import id.maskipli.hci.utils.openUrl

/**
 * @author hidayat @on 23/07/19
 **/
class ChildAdapter(private val type: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_PRODUCT = 0
        const val TYPE_ARTICLE = 1
    }

    var listItem = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (type) {
            TYPE_ARTICLE -> {
                val binding = ItemArticleBinding.inflate(layoutInflater, parent, false)
                ArticleItemViewHolder(binding)
            }
            TYPE_PRODUCT -> {
                val binding = ItemProductBinding.inflate(layoutInflater, parent, false)
                ProductItemViewHolder(binding)
            }
            else -> throw IllegalStateException("type not found")
        }
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listItem[position]
        when (holder) {
            is ArticleItemViewHolder -> {
                holder.apply {
                    itemView.setOnClickListener { it.context.openUrl(item.url) }
                    bind(item)
                }
            }
            is ProductItemViewHolder -> {
                holder.apply {
                    itemView.setOnClickListener { it.context.openUrl(item.url) }
                    bind(item)
                }
            }
        }
    }


    class ProductItemViewHolder(private val viewBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: Item) {
            viewBinding.apply {
                this.item = item
                executePendingBindings()
            }
        }
    }

    class ArticleItemViewHolder(private val viewBinding: ItemArticleBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: Item) {
            viewBinding.apply {
                this.item = item
                executePendingBindings()
            }
        }
    }
}