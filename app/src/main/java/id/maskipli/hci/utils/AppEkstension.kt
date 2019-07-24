package id.maskipli.hci.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


/**
 * @author hidayat @on 21/07/19
 **/


@BindingAdapter("setImageResource")
fun setImageResource(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView)
        .load(imageUrl)
        .apply(RequestOptions().apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)))
        .into(imageView)
}

fun Context.openUrl(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW)
        .apply { data = Uri.parse(url) }
    )
}