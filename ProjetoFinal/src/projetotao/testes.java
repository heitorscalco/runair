package projetotao;

import java.sql.SQLException;

public class testes {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        //cria um array com 2 produtos e suas respectivas quantidades
        Produto[] produtos = new Produto[2];
        produtos[0] = new Produto(2);
        produtos[0].quantidade = 2;
        
        produtos[1] = new Produto(5);
        produtos[1].quantidade = 5;
        
        //essas 3 linhas chamam a thread
        ThreadTroco threadTroco = new ThreadTroco(produtos);
        Thread troco = new Thread(threadTroco);
        troco.start();
    }
}
