package projetotao;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface BematechNFiscal extends Library {

    
    public BematechNFiscal Instance = (BematechNFiscal) Native.loadLibrary("mp2064", BematechNFiscal.class);
    
      int ConfiguraModeloImpressora(int modelo);
      int IniciaPorta(String porta);
      int FechaPorta();
      int BematechTX(String texto);
      int ImprimeCodigoBarrasCODABAR(String code);
      int ImprimeCodigoBarrasITF(String code);
      int HabilitaEsperaImpressao(int i);
      int ComandoTX(String comando, int tam);
      int VerificaPapelPresenter();
      //int AcionaGuilhotina(int i);
      int FormataTX(String BufTras, int tipoletra, int italic, int sublin, int expand, int enfat);
      int ImprimeBitmap(String bitmap, int orientacao);
      int Le_Status();
}
