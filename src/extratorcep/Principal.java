/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extratorcep;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        try{
            int id = 1;
            Extrator extrator = new Extrator();
            while(id <= 105){
                Document doc = Jsoup.connect("https://cep.guiamais.com.br/busca/marilia-sp?page=" + id).get();          
                extrator.Extrair(doc, id);
                id++;
            }
        }
        finally{
            
        }
    }
    
}
