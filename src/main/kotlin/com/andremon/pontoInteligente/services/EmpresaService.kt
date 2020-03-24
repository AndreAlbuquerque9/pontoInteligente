package com.andremon.pontoInteligente.services

import com.andremon.pontoInteligente.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa
}