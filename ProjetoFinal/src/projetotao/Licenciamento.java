package projetotao;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;

public class Licenciamento {
    
    public boolean validarLicenca(String licenca) {
//        
//        String mac_address = getSystemInformation();
//        String codigo = encodeBase64(mac_address);
//        codigo = getSha256(codigo);
//        
        return true;
       /* if(codigo.equals(licenca)) {
            return true;
        } else {
            return false;
        }*/
    }
    
    private String getSystemInformation() {
 
	InetAddress ip;
	try {
 
		ip = InetAddress.getLocalHost();
		//System.out.println("Current IP address : " + ip.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}

		return sb.toString();
 
	} catch (UnknownHostException e) {
		e.printStackTrace();
 
	} catch (SocketException e){
		e.printStackTrace();
 
	}
        return "";
   }
    
//    private String encodeBase64(String texto) {
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encodeBuffer(texto.getBytes());
//    }
    /*
//    private String decodeBase64(String texto) {
//        BASE64Decoder decoder = new BASE64Decoder();
//        try{
//            byte[] decoded = decoder.decodeBuffer(texto);
//            return new String(decoded);
//        } catch(IOException ex) {
//        }
//        return "";
//    }
    */
//    private String getSha256(String texto) {
//        try {
//            
//            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
//            byte[] result = mDigest.digest(texto.getBytes());
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < result.length; i++) {
//                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
//            }
//
//            return sb.toString();
//        } catch (Exception ert) {
//            System.out.println("Ocorreu um erro ao converter para SHA256");
//        }
//        return "";
//    }
//    
    
}
