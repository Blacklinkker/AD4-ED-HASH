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

    //criar logica 
    public void addProduct(Product prod){
        int key=generateKey(prod.code);
        hashSet[key].add(prod);
    }
    
    public String find(Product prod){
        int key=generateKey(prod.code);
        return hashSet[key].searchProduct(prod.code);
    }

    public static void main(String[] args) {
        
    }
}