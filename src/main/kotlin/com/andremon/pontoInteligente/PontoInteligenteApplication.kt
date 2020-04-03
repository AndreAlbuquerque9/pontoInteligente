package com.andremon.pontoInteligente

import com.andremon.pontoInteligente.documents.Empresa
import com.andremon.pontoInteligente.documents.Funcionario
import com.andremon.pontoInteligente.enums.PerfilEnum
import com.andremon.pontoInteligente.repositories.EmpresaRepository
import com.andremon.pontoInteligente.repositories.FuncionarioRepository
import com.andremon.pontoInteligente.repositories.LancamentoRepository
import com.andremon.pontoInteligente.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class PontoInteligenteApplication(val empresaRepository: EmpresaRepository,
								  val funcionarioRepository: FuncionarioRepository,
								  val lancamentoRepository: LancamentoRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
//		empresaRepository.deleteAll()
//		funcionarioRepository.deleteAll()
//		lancamentoRepository.deleteAll()

//		var empresa: Empresa = Empresa("Empresa", "10443887000146")
//		empresa = empresaRepository.save(empresa)
//
//		var admin: Funcionario = Funcionario("Admin", "admin@empresa.com",
//				SenhaUtils().gerarBCrypt("123456"), "12345678909", PerfilEnum.ROLE_ADMIN, empresa.id!!)
//		admin = funcionarioRepository.save(admin)
//
//		var funcionario: Funcionario = Funcionario("Funcionario", "funcionario@funcionario.com",
//				SenhaUtils().gerarBCrypt("123456"), "09876543212", PerfilEnum.ROLE_USUARIO, empresa.id!!)
//		funcionario = funcionarioRepository.save(funcionario)
//
//		println("Empresa id: ${empresa.id}")
//		println("Admin id: ${admin.id}")
//		println("Funcionario id: ${funcionario.id}")

	}
}

fun main(args: Array<String>) {
	runApplication<PontoInteligenteApplication>(*args)
}
