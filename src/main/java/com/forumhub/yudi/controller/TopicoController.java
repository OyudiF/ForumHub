package com.forumhub.yudi.controller;

import com.forumhub.yudi.respository.TopicoRepository;
import com.forumhub.yudi.topico.DadosAtualizacaoTopico;
import com.forumhub.yudi.topico.DadosCadastroTopico;
import com.forumhub.yudi.topico.DadosListagemTopico;
import com.forumhub.yudi.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {

        var topico = new Topico(dados);

        repository.save(topico);

        System.out.println("Topico cadastrado com sucesso: " + dados.titulo());

    }

    @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")
    public DadosListagemTopico detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return new DadosListagemTopico(topico);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
