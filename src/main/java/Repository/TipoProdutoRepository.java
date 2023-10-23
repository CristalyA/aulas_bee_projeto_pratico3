package Repository;

import Model.TipoProduto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoProdutoRepository extends MongoRepository <TipoProduto, String>{
    TipoProduto findByDescricao (String descricao);
}
