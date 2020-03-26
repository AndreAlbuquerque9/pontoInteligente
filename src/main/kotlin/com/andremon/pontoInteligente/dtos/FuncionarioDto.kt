package com.andremon.pontoInteligente.dtos

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class FuncionarioDto(
        @get:NotEmpty(message = "Não pode ser vazio.")
        @get:Size(message = "Deve conter entre 3 e 200 caracteres.", min = 3, max = 200) //Caso tenha algum problema, usar o @Length do hibernate
        val nome: String = "",

        @get:NotEmpty(message = "Email não pode ser vazio")
        @get:Size(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
        @get:Email(message = "Email inválido.")
        val email: String = "",

        val senha: String? = null,
        val valorHora: String? = null,
        val qtdHorasTrabalhoDia: String? = null,
        val qtdHorasAlmoco: String? = null,
        val id: String? = null

)