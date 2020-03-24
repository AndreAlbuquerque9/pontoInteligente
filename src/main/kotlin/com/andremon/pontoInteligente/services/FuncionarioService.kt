package com.andremon.pontoInteligente.services

import com.andremon.pontoInteligente.documents.Funcionario
import java.util.*

interface FuncionarioService {
    fun persistir(funcionario: Funcionario): Funcionario

    fun buscarPorCpf(cpf: String): Funcionario?

    fun buscarPorEmail(email: String): Funcionario?

    fun buscarPorId(id: String): Optional<Funcionario>
}