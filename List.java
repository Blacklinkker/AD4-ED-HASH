package AD4_2;

public class List {
    //Nós para auxiliar na navegação, por meio de uma lista duplamente encadeada. 
    //Ordem: (anterior (nulo)) inicio -> proximo 
    Segment first;
    Segment last;
    int size=0;

    //logica de adicionar segmento, parte do principio de adicionar pelo primeiro
    public void add(Product prod){
        //segmento que será adicionado
        Segment seg=new Segment(prod);
        //por ser adicionado como primeiro, ele não tem um anterior,apenas o proximo
        seg.previous=null;
        //caso ele for o unico elemento na lista ele sera o primeiro
        if(first==null){
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

    //remove no inicio, utilizado para o metodo de remover com base em codigo
    public String removeBeggining(){
        String aux=first.toString();
        first=first.next;
        first.previous=null;
        return "Removido com sucesso: \n"+aux;
    }
    //remove no fim, utilizado para o metodo de remover com base em codigo
    public String removeEnd(){
        last=last.previous;
        last.next=null;
        return null;
    }
    //metodo para remover Segmento com base no codigo do mesmo.
    public String removeIndex(int code){
        if(code==first.ssd.code){
            removeBeggining();

        }
        if(code==last.ssd.code){
            removeEnd();
        }
        return null;
    }


    //pesquisa na lista encadeada o produto,se encontrado retorna seu metodo toString modificado.
    public String searchProduct(int code){
        //começa a busca do primeiro da lista
        Segment aux=first;
        String exists="";
        //enquanto nao cair em nulo, compara e vai para o proximo
        while(aux!=null){
            //se encontrar, retorna positivo e com o conteudo pelo metodo toString
            if(aux.ssd.code==code){
                exists="Produto encontrado: \n"+aux.ssd.toString();
                return exists;
            }
            //navega para o proximo segmento
            aux=aux.next;
        }
        //caso não encontrar, retorna negativa
        return null;
    }
    @Override
    public String toString() {
        String a="";
        Segment seg=last;
        while(seg!=null){
            a+=seg.ssd.toString();
            seg=seg.previous;
        }
        return a;
    }
    
}