package projetotao;

public class Evento {
    
    int codigo;
    String data_ini;
    String data_fin;
    String nome_evento = "", lugar_evento = "";
    double valor_compra;
    double valor_venda;
    double troco_por_caixa;
    public Boolean aberto = false;
    private Usuario u = new Usuario();
    String[][] resul = u.getUsuarioLogado();

    public Evento() {
    }
    
    public Evento(int evento_id) {
        this.codigo= evento_id;
    }
    

    public void setPeriodo(String data_ini, String data_fin) {
        this.data_ini = data_ini;
        this.data_fin = data_fin;
    }

    public double[] getValorVendaPorUsuario() {
        CoreSql c = new CoreSql();

        String sql = "SELECT SUM(valor_venda) FROM b_ticket, b_usuarios WHERE b_ticket.usuario_id = b_usuarios.id and data_contabilizacao >= '" + this.data_ini + "' AND data_contabilizacao <= '" + this.data_fin + "' AND excluido = 0;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"SUM(valor_venda)"});

        return new double[]{Double.parseDouble(retorno[0][0])};

    }
    
    public double getTrocoPorCaixa() {
        CoreSql c = new CoreSql();

        String sql = "SELECT troco_por_caixa FROM b_eventos WHERE " + this.codigo + ";";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"troco_por_caixa"});

        return Double.parseDouble(retorno[0][0]);

    }

    public double[] getValorCompraPorUsuario() {

        CoreSql c = new CoreSql();

        //String sql = "SELECT SUM(vlr_compra) FROM `b_produto_estoques` WHERE quantidade > 0;";
        String sql = "SELECT SUM(vlr_compra) FROM b_produto_estoques, b_ticket, b_usuarios WHERE b_produto_estoques.produto_id = b_ticket.produto_id and b_ticket.usuario_id = b_usuarios.id;";//'" + this.data_ini + "' AND data_contabilizacao <= '" + this.data_fin + "' AND excluido = 0;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"SUM(vlr_compra)"});

        return new double[]{Double.parseDouble(retorno[0][0])};

    }
    
    public void setTrocoPorCaixa(double troco_por_caixa) {
        this.troco_por_caixa = troco_por_caixa;
    }

    public String[] getUsuariosQueVenderam() {

        CoreSql c = new CoreSql();

        //String sql = "SELECT DISTINCT(usuario_id) FROM `b_ticket` WHERE data_contabilizacao >= '" + this.data_ini + "' and data_contabilizacao <= '" + this.data_fin + "' and excluido = 0;";
        String sql = "SELECT login FROM b_usuarios, b_ticket WHERE b_usuarios.id = b_ticket.usuario_id and data_contabilizacao >= '" + this.data_ini + "' and data_contabilizacao <= '" + this.data_fin + "' and excluido = 0;";
        String[][] result = c.executarQuery(sql, true, new String[]{"login"});

        String[] retorno = new String[result.length];
//        String teste = result[0][0], teste2 = result[1][0];
//        int i = 0, j = 1;
        for (int cont = 0; cont < result.length; cont++) {

//            if (j > result.length) {
//                i -= 1;
//                j -= 1;
//            }
//            if (teste.equals(teste2)) {
//                System.out.println("igual");
//            } else {
                retorno[cont] = result[cont][0];
                System.out.println("retorno: " + retorno[cont]);

//            }
//            i += 2;
//            j += 2;
//            if (j < result.length) {
//                teste = result[i][0];
//                teste2 = result[j][0];
//            }

        }

        return retorno;
    }

    public Produto[] getProdutosVendidosPorUsuario() {

        CoreSql c = new CoreSql();

        //String sql = "select b_ticket.produto_id, count(b_ticket.produto_id) from b_ticket, b_usuarios, b_produto_estoques where b_ticket.usuario_id = b_usuarios.id and b_ticket.produto_id = b_produto_estoques.produto_id and data_contabilizacao is not null group by produto_id;";
        String sql = "select produto_id, count(produto_id) from b_ticket where usuario_id = " + u.getCodigo() + " and data_contabilizacao is not null group by produto_id;";
        String[][] result = c.executarQuery(sql, true, new String[]{"produto_id", "count(produto_id)"});

        Produto[] retorno = new Produto[result.length];

        for (int cont = 0; cont < result.length; cont++) {
            //System.out.println("irá devolver: " + result[cont][0]);

            retorno[cont] = new Produto(Integer.parseInt(result[cont][0]));
            retorno[cont].setQuantidade(Integer.parseInt(result[cont][1]));

        }

        return retorno;
    }

    public int quantidadeProdutoEmEstoque() throws ProjetoException {

        CoreSql c = new CoreSql();
//        System.out.println("codigo: " + codigo);
        String sql = "SELECT quantidade FROM b_produto_estoques, b_produtos WHERE b_produto_estoques.produto_id = b_produtos.id;";

        String[][] retorno = c.executarQuery(sql, true, new String[]{"quantidade"});

        if (retorno == null) {
            throw new ProjetoException("não existem produtos");
        }

        return Integer.parseInt(retorno[0][0]);

    }

    public boolean situacaoEvento() {

        CoreSql c = new CoreSql();
        String sql = "SELECT * FROM b_eventos WHERE aberto = 1;";
        String retorno[][] = c.executarQuery(sql, true, new String[]{"aberto"});

        if (retorno == null) {

            aberto = false;

        } else {

            aberto = true;

        }

        return aberto;

    }

    public void novoEvento() {

        CoreSql c = new CoreSql();
//        prepararData();
        String sql = "INSERT INTO b_eventos (data_inicio, data_fim, aberto, troco_por_caixa, nome_evento, lugar_evento) VALUES ('" + data_ini + "', '" + data_fin + "', 1, " + this.troco_por_caixa + ", '"+this.nome_evento+"', '"+this.lugar_evento+"');";
        c.executarQuery(sql, false, null);

    }

//    public void prepararData(){
//        
//        String[] data_i = data_ini.split("/");
//        String[] data_f = data_fin.split("/");
//        System.out.println("DIA: "+data_i[0]+" MES: "+data_i[1]+" ANO: "+data_i[2]);
//        System.out.println("DIA: "+data_f[0]+" MES: "+data_f[1]+" ANO: "+data_f[2]);
//        data_ini = data_i[2]+"-"+data_i[1]+"-"+data_i[0];
//        data_fin = data_f[2]+"-"+data_f[1]+"-"+data_f[0];
//        
//    }
    public void fecharEvento() {

        CoreSql c = new CoreSql();
        String sql = "UPDATE b_eventos SET aberto = 0 WHERE aberto = 1;";
        c.executarQuery(sql, false, null);

    }
    
    public int getEventoID(){
        
        CoreSql c = new CoreSql();
        String sql = "SELECT id FROM b_eventos WHERE aberto = 1";
        String retorno[][] = c.executarQuery(sql, true, new String[]{"id"});
        this.codigo = Integer.parseInt(retorno[0][0]);
        return Integer.parseInt(retorno[0][0]);
        
    }
    
    public void setNome(String nome){
        
        this.nome_evento = nome;
        
    }
    
    public String getNomeEventoAberto(){
        
        CoreSql c = new CoreSql();

        String sql = "SELECT nome_evento FROM b_eventos WHERE aberto = 1 ;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"nome_evento"});

        return retorno[0][0];
        
    }
    
    public String getNomeEventoFechado(){
        
        CoreSql c = new CoreSql();

        String sql = "SELECT nome_evento FROM b_eventos WHERE aberto = 0 AND id = "+this.codigo+" ;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"nome_evento"});

        return retorno[0][0];
        
    }
    
    public void setLugar(String lugar){
        
        this.lugar_evento = lugar;
        
    }
    
    public String getLugarEventoAberto(){
        
        CoreSql c = new CoreSql();

        String sql = "SELECT lugar_evento FROM b_eventos WHERE aberto = 1 ;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"lugar_evento"});

        return retorno[0][0];
        
    }
    
    public String getLugarEventoFechado(){
        
        CoreSql c = new CoreSql();

        String sql = "SELECT lugar_evento FROM b_eventos WHERE aberto = 0 AND id = "+this.codigo+" ;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"lugar_evento"});

        return retorno[0][0];
        
    }
    
    public Boolean getAberto(){
        
        CoreSql c = new CoreSql();

        String sql = "SELECT aberto FROM b_eventos WHERE id = "+this.codigo+" ;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"aberto"});
        if (Integer.parseInt(retorno[0][0]) == 0) {

            aberto = false;

        } else {

            aberto = true;

        }
        return aberto;
        
    }
    

}
