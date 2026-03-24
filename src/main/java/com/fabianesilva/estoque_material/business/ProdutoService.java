package com.fabianesilva.estoque_material.business;

import com.fabianesilva.estoque_material.infrastructure.entities.Produto;
import com.fabianesilva.estoque_material.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public void salvarProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public List<Produto> buscarProduto(){
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(UUID id){
        return produtoRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado! " + id));
    }
    public void deletarProdutopPorId(UUID id){
        produtoRepository.deleteById(id);
    }

    public void atualizarProdutoPorId(UUID id, Produto produto){
        Produto produtoEntity = produtoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado " + id));
        Produto produtoAtualizado = Produto.builder()
                .nomeProduto(produto.getNomeProduto() != null ? produto.getNomeProduto() : produtoEntity.getNomeProduto())
                .descricao(produto.getDescricao() != null ? produto.getDescricao() : produtoEntity.getDescricao())
                .unidadeMedida(produto.getUnidadeMedida() != null ? produto.getUnidadeMedida() : produtoEntity.getUnidadeMedida())
                .qtdeAtual(produto.getQtdeAtual() != null ? produto.getQtdeAtual() : produtoEntity.getQtdeAtual())
                .qtdeMin(produto.getQtdeMin() != null ? produto.getQtdeMin() : produtoEntity.getQtdeMin())
                .valorCompra(produto.getValorCompra() != null ? produto.getValorCompra() : produtoEntity.getValorCompra())
                .valorVenda(produto.getValorVenda() != null ? produto.getValorVenda() : produtoEntity.getValorVenda())
                .build();

        produtoRepository.save(produtoAtualizado);

    }


}
