package AD4_2;

//biblioteca utilizada para exibir as mensagens.
import javax.swing.JOptionPane;

public class Hash {
    //tamanho fixo de 25 chaves.
    int keys=25;
    //o hashset é um vetor de listas com o tamanho de 25 (numero total de chaves)
    List hashSet[]=new List[keys];

    //construtor de objetos Hash
    public Hash(){
        //cria as listas dentro de cada espaço no vetor.
        for(int i=0;i<25;i++){
            hashSet[i]=new List();
        }
    }

    //Metodo para gerar as chaves como solicitado no requisito (K(valor)=valor%25)
    public int generateKey(int code){
        return code % keys;
    }

    //adiciona produto em uma lista de acordo com sua chave
    public void addProduct(Product prod){
        int key=generateKey(prod.code);
        this.hashSet[key].add(prod);
    }

    //chama a logica de pesquisa
    public String findProduct(int code){
        int key=generateKey(code);
        if(hashSet[key].searchProduct(code)!=null){
            return hashSet[key].searchProduct(code);
        }
        return "Não foi possivel encontrar produto.";
    }

    public static void main(String[] args) {
        Hash hashPrincipal=new Hash();
        Product a=new Product(25, "Seagate", 256);
        Product b=new Product(100, "Kingston", 500);
        hashPrincipal.addProduct(a);
        hashPrincipal.addProduct(b);
        System.out.println(hashPrincipal.findProduct(25));
        System.out.println(hashPrincipal.findProduct(100));
        
    }
}