package ir.mahmoudroid.core.util

data class CustomToolbar(
        val title: String,
        val rightBtn:ToolbarButtonType = ToolbarButtonType.menu,
        val leftBtn: ToolbarButtonType = ToolbarButtonType.back,
        val callback: (()->Unit)? = null
)

enum class ToolbarButtonType{
    empty,
    done,
    menu,
    back
}