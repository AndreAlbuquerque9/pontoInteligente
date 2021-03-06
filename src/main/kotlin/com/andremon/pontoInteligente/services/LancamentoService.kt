package com.andremon.pontoInteligente.services

import com.andremon.pontoInteligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.util.*

interface LancamentoService {
    fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento>

    fun buscarPorId(id: String): Optional<Lancamento>

    fun persistir(lancamento: Lancamento): Lancamento

    fun remover(id: String)
}