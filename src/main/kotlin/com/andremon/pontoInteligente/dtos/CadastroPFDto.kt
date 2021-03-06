package com.andremon.pontoInteligente.dtos

import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class CadastroPFDto(

        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Size(min = 3, max = 200, message = "Nome deve conter de 3 a 200 caracteres")
        val nome: String = "",

        @get:NotEmpty(message = "Email não pode ser vazio.")
        @get:Size(min = 5, max = 200, message = "Email deve conter de 5 a 200 caracteres")
        @get:Email(message = "Email inválido")
        val email: String = "",

        @get:NotEmpty(message = "Senha não pode ser vazio.")
        val senha: String = "",

        @get:NotEmpty(message = "CPF não pode ser vazio.")
        @get:CPF(message = "CPF inválido")
        val cpf: String = "",

        @get:NotEmpty(message = "CNPJ não pode ser vazio.")
        @get:CNPJ(message = "CNPJ inválido")
        val cnpj: String = "",

        val empresaId: String = "",

        val valorHora: String? = null,
        val qtdHorasTrabalhoDia: String? = null,
        val qtdHorasAlmoco: String? = null,
        val id: String? = null
)