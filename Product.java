package AD4;

//utilizando o ssd para um exemplo mais interessante
public class Product {
    int code; //codigo do item que será usado no Hash
    String brand; //marca do ssd
    int storage; //capacidade do ssd (em int pois é medido em GB)

    //construtor de um Produto
    Product(int code,String brand,int storage){
        this.brand=brand;
        this.code=code;
        this.storage=storage;
    }

    //override do metodo toString() para retornar mensagem personalizada
    @Override
    public String toString() {
        return "Codigo do produto: "+this.code+" \n"
        +"Marca do produto: "+this.brand+"\n"
        +"Capacidade do produto: "+"\n";
    }
}