/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetotao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class Impressora {
    
    private static PrintService impressora;
    private static final char LINE_FEED = 10; //line feed/new line 
    private static final char CR = 13; //carriage return
    BematechNFiscal cupom = BematechNFiscal.Instance;
    
    public void iniciar(String porta){
        
        cupom.IniciaPorta(porta);
        
    }
    
    public void executaComando(String comando, int tam){
        
        cupom.ComandoTX(comando, tam);
        
    }
    
    public int verificaPapel(){
        
        return cupom.VerificaPapelPresenter();
        
    }
//            cupom.ImprimeBitmap(f.getAbsolutePath(), tam);

//    public static List<String> retornaImressoras() {
//        try {
//            List<String> listaImpressoras = new ArrayList<>();
//            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
//            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
//            for (PrintService p : ps) {
//                listaImpressoras.add(p.getName());
//            }
//            return listaImpressoras;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void detectaImpressoras(String impressoraSelecionada) {  //Passa por parâmetro o nome salvo da impressora  
//        try {
//            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
//            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
//            for (PrintService p : ps) {
//                if (p.getName() != null && p.getName().contains(impressoraSelecionada)) {
//                    impressora = p;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    public void imprime(String texto) {

        cupom.BematechTX(texto);
        
    }
//        if (impressora == null) {
//            JOptionPane.showMessageDialog(null, "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
//        } else {
//            try {
//                DocPrintJob dpj = impressora.createPrintJob();
//                InputStream stream = new ByteArrayInputStream((texto + "\n").getBytes());
//                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//                Doc doc = new SimpleDoc(stream, flavor, null);
//                dpj.print(doc, null);
//                return true;
//            } catch (PrintException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
    
    public void configurarModelo(int modelo){
        
        cupom.ConfiguraModeloImpressora(modelo);
        
    }
    
    public void acionarGuilhotina() {
        imprime("" + (char) 27 + (char) 109);
    }

    public void novaLinha(){
        
        imprime("" + LINE_FEED + CR);
        
    }
    
    public void imprimirCodBarras(String codigo){
        
        cupom.ImprimeCodigoBarrasCODABAR(codigo);
        
    }
    
    public void imprimePersonalizado(String texto, int tipoLetra, int italico, int sublinhado, int exp, int negrito){
        
        cupom.FormataTX(texto, tipoLetra, italico, sublinhado, exp, negrito);
        
    }
    
    public void esperarImpressao(){
        
        cupom.HabilitaEsperaImpressao(1);
        
    }
    
    public int status(){
        
       int status = cupom.Le_Status();
        System.out.println("STATUS: "+status);
       return status;
       
    }
    
    public void encerrar(){
        
        cupom.FechaPorta();
        
    }
    
//    public void imprimirBitMap(String caminho, int orientacao){
        
        
        //cupom.ConfiguraModeloImpressora(7);
        
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX("DE");
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX("Impressao");
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX(""+ LINE_FEED + CR);
//        cupom.BematechTX("" + (char) 27 + (char) 109);
        
        //cupom.AcionaGuilhotina(1);
//        cupom.ImprimeBitmap(caminho, 5);
        
        
//    }
    
}
