package com.andremon.pontoInteligente.controllers

import com.andremon.pontoInteligente.Response
import com.andremon.pontoInteligente.documents.Funcionario
import com.andremon.pontoInteligente.documents.Lancamento
import com.andremon.pontoInteligente.dtos.LancamentoDto
import com.andremon.pontoInteligente.enums.TipoEnum
import com.andremon.pontoInteligente.services.FuncionarioService
import com.andremon.pontoInteligente.services.LancamentoService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/lancamentos")
class LancamentoController(val lancamentoService: LancamentoService,
                           val funcionarioService: FuncionarioService) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @Value("\${paginacao.qtd_por_pagina}")
    val qtdPorPagina: Int = 15

    @PostMapping
    fun adicionar(@Valid @RequestBody lancamentoDto: LancamentoDto, result: BindingResult): ResponseEntity<Response<LancamentoDto>> {
        val response: Response<LancamentoDto> = Response<LancamentoDto>()
        println("Entrou aqui")
        validaFuncionario(lancamentoDto, result)

        if (result.hasErrors()) {
            for (erro in result.allErrors) erro.defaultMessage?.let { mensagemErro -> response.erros.add(mensagemErro) }
            return ResponseEntity.badRequest().body(response)
        }

        val lancamento: Lancamento = converterDtoParaLancamento(lancamentoDto, result)
        lancamentoService.persistir(lancamento)
        response.data = converterLancamentoDto(lancamento)
        return ResponseEntity.ok(response)
    }

    private fun validaFuncionario(lancamentoDto: LancamentoDto, result: BindingResult) {
        if (lancamentoDto.funcionarioId == null) {
            result.addError(ObjectError("funcionario", "Funcionário não informado."))
            return
        }

        val funcionario: Optional<Funcionario>? = funcionarioService.buscarPorId(lancamentoDto.funcionarioId)
        if (funcionario == null) {
            result.addError(ObjectError("funcionario", "Funcionário não encontrado. ID inexistente."))
        }
    }

    private fun converterDtoParaLancamento(lancamentoDto: LancamentoDto, result: BindingResult): Lancamento {
        if (lancamentoDto.id != null) {
            val lanc: Optional<Lancamento>? = lancamentoService.buscarPorId(lancamentoDto.id)
            if (lanc == null) result.addError(ObjectError("lancamento", "Lancamento não encontrado"))

        }
        return Lancamento(dateFormat.parse(lancamentoDto.data), TipoEnum.valueOf(lancamentoDto.tipo!!),
                lancamentoDto.funcionarioId!!, lancamentoDto.descricao,
                lancamentoDto.localizacao, lancamentoDto.id)
    }

    private fun converterLancamentoDto(lancamento: Lancamento): LancamentoDto =
            LancamentoDto(dateFormat.format(lancamento.data), lancamento.tipo.toString(), lancamento.descricao,
                    lancamento.localizacao, lancamento.funcionarioId, lancamento.id)
}