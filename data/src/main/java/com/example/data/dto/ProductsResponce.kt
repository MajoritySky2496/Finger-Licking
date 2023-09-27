package com.example.data.dto

import com.example.data.dto.models.ProductsDto

data class ProductsResponce(
    val items:List<ProductsDto>
) :Responce()