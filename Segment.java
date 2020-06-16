package AD4_2;

public class Segment {
    //sentido dos ponteiros: (anterior) inicio-> proximo-> proximo...etc.
    //Segmento anterior.
    Segment previous;
    //segmento seguinte.
    Segment next;
    //produto chamado de SSD para ilustrar utilização.
    Product ssd;

    //construtor para facilidade em atribuição.
    public Segment(Product prod){
        this.ssd=prod;
    }
    
    //construtor vazio para praticidade em buscas.
    public Segment(){

    }
    //Reutiliza o metodo toString() da classe Product. 
    @Override
    public String toString() {
        return this.ssd.toString();
    }
}