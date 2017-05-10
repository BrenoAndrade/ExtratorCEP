package extratorcep;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Extrator {    
    public void Extrair(Document doc, int pg){
        
        Elements tudo = doc.getAllElements();
        
        Elements elementosDaTag = tudo.get(0).getElementsByTag("tr");
                
            elementosDaTag.forEach((elemento) -> {
                if(!elemento.hasClass("s_title")){
                    Rua rua = new Rua();
                    
                    String str1 = elemento.children().get(0).text();
                    String[] tipoNome = str1.split(" ");
                    rua.setTipo(tipoNome[0]);
                    str1 = "";
                    
                    for(int i = 1; i < tipoNome.length; i++)
                    {
                        if(i == 1)
                            str1 = tipoNome[i];
                        else
                            str1 += " " + tipoNome[i];
                    }
                    
                    rua.setNome(str1);
                    
                    rua.setBairro(elemento.children().get(1).text());
                    
                    String str = elemento.children().get(2).text();
                    String[] cidadeEstado = str.split(",");
                    rua.setCidade(cidadeEstado[0]);
                    rua.setEstado(cidadeEstado[1].trim());
                    
                    rua.setCep(elemento.children().get(4).text().replace("-", ""));
                    
                    System.out.println("---------------------");
                    System.out.println(rua.getTipo());
                    System.out.println(rua.getNome());
                    System.out.println(rua.getBairro());
                    System.out.println(rua.getCidade());
                    System.out.println(rua.getEstado());
                    System.out.println(rua.getCep());
                }
            });
        }  
    }

