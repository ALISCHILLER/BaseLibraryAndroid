package com.msa.base_msa_library.weights.toast

enum class BaseToastStyle {
    SUCCESS, ERROR, WARNING, INFO, DELETE, NO_INTERNET;

    fun getName(): String {
        if (this.name.contains("_")) {
            return this.name.replaceFirst("_", " ")
        }
        return this.name
    }

}