package AD4;

//utilizando o ssd para um exemplo mais interessante
public class Produto {
    int code; //codigo do item
    String brand; //marca do ssd
    int size; //capacidade

    //override do metodo toString() para retornar mensagem personalizada
    @Override
    public String toString() {
        return "Codigo do produto: "+this.code+" \n"
        +"Marca do produto: "+this.brand+"\n"
        +"Capacidade do produto: "+"\n";
    }
}