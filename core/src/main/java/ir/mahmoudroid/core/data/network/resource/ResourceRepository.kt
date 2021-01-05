package ir.mahmoudroid.core.data.network.resource

import ir.mahmoudroid.core.domain.Resource

interface ResourceRepository {

    fun getResourceList(pageNumber: Int): List<Resource>

}