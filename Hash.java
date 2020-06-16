package AD4_2;

//biblioteca utilizada para exibir as mensagens.
import javax.swing.JOptionPane;

public class Hash {
    //tamanho fixo de 25 chaves.
    int keys=25;
    //o hashset é um vetor de listas com o tamanho de 25 (numero total de chaves).
    List hashSet[]=new List[keys];

    //construtor de objetos Hash.
    public Hash(){
        //cria as listas dentro de cada espaço no vetor.
        for(int i=0;i<25;i++){
            hashSet[i]=new List();
        }
    }

    //Metodo para gerar as chaves como solicitado no requisito (K(valor)=valor%25).
    public int generateKey(int code){
        return code % keys;
    }

    //adiciona produto em uma lista de acordo com sua chave.
    public void addProduct(Product prod){
        int key=generateKey(prod.code);
        this.hashSet[key].add(prod);
    }

    //chama a logica de pesquisa.
    public String findProduct(int code){
        int key=generateKey(code);
        //se o resultado não for nulo, é retornado o resultado.
        if(hashSet[key].searchProduct(code)!=null){
            return hashSet[key].searchProduct(code);
        }
        return "Não foi possivel encontrar produto.";
    }
    
    //metodo main para a execução do programa.
    public static void main(String[] args) {
        
        //Instanciação de um Hash.
        Hash hashPrincipal=new Hash();
        
        /*
        Criação de 3 produtos (SSD'S).
        possuem codigos multiplos de 25 para dmeonstrar suporte a colisões.
        ordem: codigo,marca,capacidade.
        */
        Product a=new Product(25, "Seagator", 256);
        Product b=new Product(100, "Kongston", 512);
        Product c=new Product(125, "WoooshDigital", 960);
        
        //produtos são adicionados ao hash.
        hashPrincipal.addProduct(a);
        hashPrincipal.addProduct(b);
        hashPrincipal.addProduct(c);
        
        //Utilizado metodo de busca para confirmar existencia dos produtos.
        JOptionPane.showMessageDialog(null, hashPrincipal.findProduct(25));
        JOptionPane.showMessageDialog(null, hashPrincipal.findProduct(100));
        JOptionPane.showMessageDialog(null, hashPrincipal.findProduct(125));
        
        //Metodo de geração de chave é utilizado para procurar em qual chave o produto se encontra
        //ao chegar na chave o metodo vasculha em busca de um segmento com codigo igual, ao encontrar utiliza o metodo necessario para remoção.
        JOptionPane.showMessageDialog(null, hashPrincipal.hashSet[hashPrincipal.generateKey(25)].removeIndex(25));
        JOptionPane.showMessageDialog(null, hashPrincipal.hashSet[hashPrincipal.generateKey(100)].removeIndex(100));
        
        //Consulta para confirmar que a remoção do segmento foi executada.
        JOptionPane.showMessageDialog(null, hashPrincipal.findProduct(100));

        //consulta para confirmar que a lista ainda mantem sua ordem após remoção de segmento.
        JOptionPane.showMessageDialog(null, hashPrincipal.findProduct(125));

    }
}