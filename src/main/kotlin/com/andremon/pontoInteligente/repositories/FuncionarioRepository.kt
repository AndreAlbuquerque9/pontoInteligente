package com.andremon.pontoInteligente.repositories

import com.andremon.pontoInteligente.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

interface FuncionarioRepository : MongoRepository<Funcionario, String>{
    fun findByEmail(email: String): Funcionario
    fun findByCpf(cpf: String): Funcionario
}