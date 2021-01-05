package ir.mahmoudroid.core.util

sealed class UiAlert

data class Toast(val text: String): UiAlert()

data class Snack(
        val text: String,
        val callback:(()->Unit)? = null
        ): UiAlert()

data class Dialog(
        val bodyText: String,
        val callback:(()->Unit)?
): UiAlert()