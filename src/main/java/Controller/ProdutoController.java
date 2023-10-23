package Controller;

import Model.Produto;
import Repository.ProdutoRepository;
import Service.ProdutoService;
import message.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final MessageProducer messageProducer;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository, MessageProducer messageProducer, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.messageProducer = messageProducer;
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto){
        messageProducer.sendMessage(String.format("Produto %s cadastrado !", produto.toString()));
        return produtoRepository.save(produto);
    }

    @GetMapping("/consultar/{nome}")
    public ResponseEntity<List<Produto>> consultarProdutos(@PathVariable String nome){
        List<Produto> produtos = produtoService.consultarPorNome(nome);
        if (produtos != null) {
            return ResponseEntity.ok(produtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/error")
    public ResponseEntity erroNoProduto() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
