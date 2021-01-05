package ir.mahmoudroid.core.ext

import ir.mahmoudroid.core.data.database.UserEntity
import ir.mahmoudroid.core.domain.User

fun UserEntity.toUser(): User{
    return User(
        this.id,
        this.name,
        this.age,
        this.isStaff
    )
}


fun List<UserEntity>.toUserList(): List<User>{
    val list = mutableListOf<User>()
    this.let {
        it.forEach {
            item ->
            list.add(item.toUser())
        }
    }
    return list
}


fun User.toUserEntity(): UserEntity{
    return UserEntity(
        this.id,
        this.name,
        this.age,
        this.isStaff
    )
}

