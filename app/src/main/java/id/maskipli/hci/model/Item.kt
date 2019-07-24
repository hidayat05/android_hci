package id.maskipli.hci.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * @author hidayat @on 21/07/19
 **/
@Parcelize
data class Item(

    @SerializedName("product_name", alternate = ["article_title"])
    val name: String,

    @SerializedName("product_image", alternate = ["article_image"])
    val image: String,

    @SerializedName("link")
    val url: String

) : Parcelable {

    fun nameSplitter(): String {
        return name.removePrefix("Pembiayaan").trim()
    }
}