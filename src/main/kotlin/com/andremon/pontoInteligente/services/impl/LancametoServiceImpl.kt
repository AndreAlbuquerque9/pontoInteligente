package com.andremon.pontoInteligente.services.impl

import com.andremon.pontoInteligente.documents.Lancamento
import com.andremon.pontoInteligente.repositories.LancamentoRepository
import com.andremon.pontoInteligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class LancametoServiceImpl(val lancamentoRespository: LancamentoRepository) : LancamentoService {
    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> =
            lancamentoRespository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String): Optional<Lancamento>? =
            lancamentoRespository.findById(id)

    override fun persistir(lancamento: Lancamento): Lancamento =
            lancamentoRespository.save(lancamento)

    override fun remover(id: String) =
            lancamentoRespository.deleteById(id)
}