package com.example.lifecycledemoapp.design

object DialogFactory {

    fun createDialog(dialogType: DialogType): Dialog {
        return when (dialogType) {
            DialogType.DIALOG_CREATE -> Dialog.CreateDialog
            DialogType.DIALOG_MESSAGE -> Dialog.MessageDialog
            DialogType.DIALOG_DELETE -> Dialog.DeleteDialog
        }
    }

}

sealed class Dialog {
    object CreateDialog : Dialog()
    object MessageDialog : Dialog()
    object DeleteDialog : Dialog()
}


enum class DialogType {
    DIALOG_CREATE, DIALOG_MESSAGE, DIALOG_DELETE
}
