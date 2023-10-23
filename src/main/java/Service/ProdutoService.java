package Service;

import Model.Produto;
import Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Optional<Produto> findById(String id){
        return produtoRepository.findById(id);
    }

    public List<Produto> consultarPorNome(String nome){
        return produtoRepository.findByNome(nome);
    }
}
