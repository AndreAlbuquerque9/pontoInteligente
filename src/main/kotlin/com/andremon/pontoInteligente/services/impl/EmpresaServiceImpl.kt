package com.andremon.pontoInteligente.services.impl

import com.andremon.pontoInteligente.documents.Empresa
import com.andremon.pontoInteligente.repositories.EmpresaRepository
import com.andremon.pontoInteligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {
    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}