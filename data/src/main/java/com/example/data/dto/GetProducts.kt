package com.example.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.example.data.dto.models.ProductsDto
@Parcelize
data class GetProducts(val categoryid:Int):Parcelable

@Parcelize
object GetCategories:Parcelable

@Parcelize
object GetTags:Parcelable