package ir.mahmoudroid.core.ext

import ir.mahmoudroid.core.data.network.student.ResponseStudent
import ir.mahmoudroid.core.domain.Student


fun ResponseStudent.toStudent(): Student {
    return Student(
        this.id,
        this.email,
        this.first_name,
        this.last_name,
        this.avatar
    )
}


fun List<ResponseStudent>.toStudentList(): List<Student>{
    val list = mutableListOf<Student>()
    this.let {
        it.forEach {
                item ->
            list.add(item.toStudent())
        }
    }
    return list
}