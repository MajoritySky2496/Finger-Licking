package com.example.data.util

import com.example.data.dto.models.CategoriesDto
import com.example.data.dto.models.ProductsDto
import com.example.data.dto.models.TagsDto
import com.example.domain.models.Categories
import com.example.domain.models.Product
import com.example.domain.models.Tags

fun mapProductFromDto(productDto: ProductsDto): Product {
    return Product(
        productDto.carbohydrates_per_100_grams,
        productDto.id,
        productDto.description,
        productDto.energy_per_100_grams,
        productDto.fats_per_100_grams,
        productDto.category_id,
        productDto.image,
        productDto.measure,
        productDto.measure_unit,
        productDto.name,
        productDto.price_current,
        productDto.price_old,
        productDto.proteins_per_100_grams,
        productDto.tag_ids
    )
}

fun mapCategoryFromDto(categoriesDto: CategoriesDto): Categories {
    return Categories(
        categoriesDto.id,
        categoriesDto.name
    )
}

fun mapTagFromDto(tagsDto: TagsDto): Tags{
    return Tags(
        tagsDto.id,
        tagsDto.name
    )
}

