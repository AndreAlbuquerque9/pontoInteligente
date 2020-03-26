package com.andremon.pontoInteligente.dtos

import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class CadastroPJDto(

        @get:NotEmpty(message = "Nome não pode ser vazio")
        @get:Size(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
        val nome: String = "",

        @get:NotEmpty(message = "Email não pode ser vazio")
        @get:Size(min = 3, max = 200, message = "Email deve conter entre 3 e 200 caracteres")
        @get:Email(message = "Email inválido")
        val email: String = "",

        @get:NotEmpty(message = "Senha não pode ser vazio")
        val senha: String = "",

        @get:NotEmpty(message = "CPF não pode ser vazio")
        @get:CPF(message = "CPF inválido")
        val cpf: String = "",

        @get:NotEmpty(message = "CNPJ não pode ser vazio")
        @get:CNPJ(message = "CNPJ invalido")
        val cnpj: String = "",

        @get:NotEmpty(message = "Razão Social não pode ser vazio.")
        @get:Size(min = 5, max = 200, message = "Razão Social deve conter entre 5 e 200 caracteres.")
        val razaoSocial: String = "",

        val id: String? = null
)