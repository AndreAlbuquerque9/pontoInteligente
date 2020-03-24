package com.andremon.pontoInteligente.services

import com.andremon.pontoInteligente.documents.Funcionario
import com.andremon.pontoInteligente.enums.PerfilEnum
import com.andremon.pontoInteligente.repositories.FuncionarioRepository
import com.andremon.pontoInteligente.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*

@SpringBootTest
class FuncionarioServiceTest {
    @Autowired
    private val funcionarioService: FuncionarioService? = null

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    private val email: String = "email@email.com.br"
    private val cpf: String = "12345678909"
    private val id: String = "1"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = funcionarioService?.persistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscaFuncionarioPorCpf() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorCpf(cpf)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscaFuncionarioPorEmail() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorEmail(email)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorId() {
        val funcionario: Optional<Funcionario>? = funcionarioService?.buscarPorId(id)
        Assertions.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario = Funcionario("André Monteiro", email, SenhaUtils().gerarBCrypt("123456"), cpf, PerfilEnum.ROLE_USUARIO, "1")
}