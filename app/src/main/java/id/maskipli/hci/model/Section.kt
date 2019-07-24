package id.maskipli.hci.model

import com.google.gson.annotations.SerializedName

/**
 * @author hidayat @on 21/07/19
 **/
data class Section(

    val section: String,

    @SerializedName("section_title")
    val sectionTitle: String?,

    @SerializedName("items")
    val listItems: List<Item> = emptyList()
)