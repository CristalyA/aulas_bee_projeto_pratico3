package Service;

import Model.TipoProduto;
import Repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TipoProdutoService {

    private final TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    public TipoProdutoService(TipoProdutoRepository tipoProdutoRepository) {
        this.tipoProdutoRepository = tipoProdutoRepository;
    }


    public TipoProduto salvarProduto(TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    public Optional<TipoProduto> findById(String id) {
        return tipoProdutoRepository.findById(id);
    }

    public TipoProduto consultarPorNome(String nome) {
        return tipoProdutoRepository.findByDescricao(nome);
    }
}
