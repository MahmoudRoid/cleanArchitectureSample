package ir.mahmoudroid.core.ext

import ir.mahmoudroid.core.data.network.resource.ResponseResource
import ir.mahmoudroid.core.domain.Resource


fun ResponseResource.toResource(): Resource {
    return Resource(
        this.id,
        this.name,
        this.year,
        this.color,
        this.pantone_value
    )
}


fun List<ResponseResource>.toResourceList(): List<Resource>{
    val list = mutableListOf<Resource>()
    this.let {
        it.forEach {
                item ->
            list.add(item.toResource())
        }
    }
    return list
}