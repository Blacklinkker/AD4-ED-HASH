package AD4;

public class List {
    //Nós para auxiliar na navegação, por meio de uma lista duplamente encadeada. 
    //Primeiro
    Segment first;
    //ultimo                Ordem: (anterior (nulo)) inicio -> proximo 
    Segment last;
    //informa o tamanho atual da lista
    int size=0;

    //logica de adicionar segmento, parte do principio de adicionar pelo primeiro
    public void add(Product prod){
        //segmento que será adicionado
        Segment seg=new Segment(prod);
        //por ser adicionado como primeiro, ele não tem um anterior,apenas o proximo
        seg.previous=null;
        //caso ele for o unico elemento na lista ele sera o primeiro
        if(first==null){
            seg.next=null;
            first=seg;
        }
        //caso tiver mais elementos na lista, o proximo elemento sera o antigo inicio
        seg.next=first;
        //pelo first nao ser mais o primeiro, agora é atribuido um anterior a ele
        first.previous=seg;
        //agora o novo segmento se torna o primeiro 
        first=seg;
        //caso lista seja vazia, o primeiro será o ultimo, caso não, o ultimo continuará sendo o primeiro elemento que foi adicionado
        if(size==0){
            last=first;
        }
        size++;
    }

    //pesquisa na lista encadeada o produto,se encontrado retorna seu metodo toString modificado.
    public String  searchProduct(int code){
        //começa a busca do primeiro da lista
        Segment aux=first;
        //enquanto nao cair em nulo, compara e vai para o proximo
        while(aux!=null){
            //se encontrar, retorna positivo e com o conteudo pelo metodo toString
            if(aux.ssd.code==code){
                return aux.ssd.toString();
            }
            //navega para o proximo segmento
            aux=aux.next;
        }
        //caso não encontrar, retorna negativa
        return "Não encontrado.";
    }
}