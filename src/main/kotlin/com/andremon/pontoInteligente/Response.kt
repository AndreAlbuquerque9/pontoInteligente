package com.andremon.pontoInteligente

data class Response<T> (
        val erros: ArrayList<String> = arrayListOf(),
        var data: T? = null
)