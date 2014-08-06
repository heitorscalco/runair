package projetotao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ThreadImprimirTickets implements Runnable {
    
    Produto[] produtos_selecionados;
    int[] quantidades;
    
    
    
        
    
    
    public ThreadImprimirTickets(Produto[] produtos_selecionados, int[] quantidades) {
        this.produtos_selecionados = produtos_selecionados;
        this.quantidades = quantidades;
    }
    
    public String formataCodigo(String codigo, int tam) {

        int cb = 8 - tam;
        String zeros = "";

        for (int j = 0; j < cb; j++) {

            zeros += "0";

        }
        zeros += codigo;
        System.out.println("ZEROS: " + zeros);
        return zeros;
    }
    
    public void run () {
        
        String data = "dd/MM/yyyy";
        String hora = "HH:mm:ss";
        String data1, hora1;
        Impressora imp = new Impressora();
        int papel = imp.verificaPapel();
        DecimalFormat d = new DecimalFormat("####,##0.00");
        Evento e = new Evento();
    
        System.out.println("iniciando a therad de imrpessaso");
        
        boolean criou = false;
        
            for (int j = 0; j < produtos_selecionados.length; j++) {
                
                    System.out.println("passou aqui 1");
                    int quantidade = quantidades[j];

                    Ticket t = new Ticket();
                    try {
                        //papel = imp.verificaPapel();
                        
                        System.out.println("passou aqui 2");

                        for (int i = 0; i < quantidade; i++) {

                            System.out.println("quantidades: " + quantidade);

                            if (papel == 1) {
                                java.util.Date agora = new java.util.Date();
                                SimpleDateFormat formata = new SimpleDateFormat(data);

                                data1 = formata.format(agora);
                                formata = new SimpleDateFormat(hora);
                                hora1 = formata.format(agora);

                                System.out.println("produtooo: " + produtos_selecionados[j].descricao);

                                criou = t.criar(produtos_selecionados[j]);

//                            } else {
//
//                                JOptionPane.showMessageDialog(null, "A impressora está sem papel!");
//
//                            }
                                if (criou) {

//                                papel = imp.verificaPapel();
//                                if (papel == 1) {
                                    imp.imprimePersonalizado(" Gerenciador de Ticket", 1, 0, 0, 1, 1);
                                    imp.novaLinha();
                                    //imp.imprimePersonalizado((char) 9+produtos_selecionados[cont].descricao, 2, 0, 0,0,0 );
                                    imp.imprimePersonalizado(" " + produtos_selecionados[j].descricao, 2, 0, 0, 1, 1);
                                    imp.novaLinha();
                                    System.out.println("  R$: " + d.format(produtos_selecionados[j].valor_venda));
                                    imp.imprimePersonalizado("  R$: " + d.format(produtos_selecionados[j].valor_venda), 1, 0, 0, 1, 0);
                                    imp.novaLinha();
                                    imp.imprimePersonalizado("  " + data1 + " " + hora1, 1, 0, 0, 1, 0);
                                    imp.novaLinha();
                                    imp.imprimePersonalizado("  " + e.getNomeEventoAberto(), 1, 0, 0, 1, 0);
                                    imp.novaLinha();
                                    imp.imprimePersonalizado("  " + e.getLugarEventoAberto(), 1, 0, 0, 1, 0);
                                    imp.novaLinha();
                                    String cod = t.getCodigo(produtos_selecionados[j]);
                                    int tam = cod.length();
                                    String codigo = formataCodigo(cod, tam);
                                    //imprimirCodigoBarras(cod);
                                    imp.imprimirCodBarras(codigo);

//                                
                                }

                                imp.imprimePersonalizado("   Ingresso Garantido", 1, 0, 0, 1, 0);
                                imp.novaLinha();
                                imp.imprimePersonalizado("   (55)9907-7900", 1, 0, 0, 1, 0);
                                imp.novaLinha();
                                imp.acionarGuilhotina();
                            } else {
//
                                JOptionPane.showMessageDialog(null, "A impressora está sem papel!");

                            }

                        }

                    } catch (Exception ert) {
                        JOptionPane.showMessageDialog(null, ert.toString());
                        ert.printStackTrace();

                    }
                }
        
    }
}