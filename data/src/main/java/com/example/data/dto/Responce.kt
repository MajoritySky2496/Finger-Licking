package com.example.data.dto

import com.example.data.dto.models.CategoriesDto
import com.example.data.dto.models.ProductsDto
import com.example.data.dto.models.TagsDto

open class Responce {
    var resultCode = 0
    var resultProducts = listOf<ProductsDto>()
    var resultCategories = listOf<CategoriesDto>()
    var resultTags = listOf<TagsDto>()
}