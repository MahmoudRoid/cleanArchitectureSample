package ir.mahmoudroid.core.ext

import ir.mahmoudroid.core.data.database.CountryEntity
import ir.mahmoudroid.core.domain.Country

fun CountryEntity.toCountry(): Country {
    return Country(
        this.id,
        this.name
    )
}


fun List<CountryEntity>.toCountryList(): List<Country>{
    val list = mutableListOf<Country>()
    this.let {
        it.forEach {
                item ->
            list.add(item.toCountry())
        }
    }
    return list
}