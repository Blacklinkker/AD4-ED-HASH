package AD4;

public class Hash {
    //tamanho fixo de 25 chaves.
    int keys=25;
    //o hashset é um vetor de listas
    List hashSet[];

    //construtor de objetos Hash
    public Hash(){
        hashSet=new List[keys];
        for(int i=0;i<25;i++){
            hashSet[i]=new List();
        }
    }

    //gera a chave Hash para o produto
    public int generateKey(int code){
        return code % keys;
    }

    //adiciona produto em uma lista de acordo com sua chave
    public void addProduct(Product prod){
        int key=generateKey(prod.code);
        hashSet[key].add(prod);
    }

    //chama a logica de pesquisa
    public String findProduct(Product prod){
        int key=generateKey(prod.code);
        return hashSet[key].searchProduct(prod.code);
    }

    public static void main(String[] args) {
        Hash mainHash=new Hash();
        Product prod1=new Product(3, "seagate", 443);
        mainHash.addProduct(prod1);
        System.out.println(mainHash.findProduct(prod1));
    }
}