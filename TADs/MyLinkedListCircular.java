package TADs;

public class MyLinkedListCircular implements MyLinkedList{

    private NodeList first=null;

    @Override
    public void add(Object value) {
        NodeList elementToAdd=new NodeList(value);
        if(first==null){
            first=elementToAdd;
        }
        else{
            NodeList tempUltimo=first;
            while(tempUltimo.getnext()!=null){
                tempUltimo=tempUltimo.getnext();
            }
            tempUltimo.setnext(elementToAdd);
            elementToAdd.setPrevious(tempUltimo);
            //elementToAdd.setnext(first);
            first.setPrevious(elementToAdd);
        }

        //this.list[this.size()] = value;
    }

    @Override
    public int size() {
        int largo=0;
        NodeList nodoactual = first;
        while (nodoactual.getnext()!=first){
            System.out.println("entro al while");
            nodoactual=nodoactual.getnext();
            largo++;
        }
        return largo;
    }

    @Override
    public NodeList get(int pos) {
        if(pos<=this.size()) {
            if (pos == 0) {
                return first;
            }
            NodeList nodoActual = first;
            for (int i = 0; i < pos; i++) {
                nodoActual = nodoActual.getnext();
                //first = first.getnext();
            }
            return nodoActual;
        }
        else{
            System.out.println("No existe esa posicion");
            return null;
        }
    }
    @Override
    public Object getNodeValue(NodeList Node){
        return  Node.getValue();

    }

    @Override
    public void remove(int pos) {
        /*if(pos-1>=0) {
            this.get(pos).setnext(this.get(pos + 1));
        }

        this.get(pos).setValue(null);
        */
        NodeList nodotemp = first;
        for (int i=0; i<this.size(); i++){
            if (i+1==pos && nodotemp.getnext().getnext()!=null){
                nodotemp.setnext(nodotemp.getnext().getnext());
                nodotemp.getnext().getnext().setPrevious(nodotemp);
            }
            else {
                nodotemp=nodotemp.getnext();
            }
        }
        if (pos==0){
            nodotemp.setValue(null);
        }

        if (pos==this.size()-1){
            NodeList nodoant = this.get(this.size()-2);
            nodotemp=get(this.size()-1);
            nodotemp.setPrevious(null);
            nodoant.setnext(null);

        }
    }

    public void remove_value(Object value){

        NodeList nodotemp = first;
        for (int i=0; i<this.size(); i++){
            if (get(i+1).getValue()==value && nodotemp.getnext().getnext()!=null){
                nodotemp.setnext(nodotemp.getnext().getnext());
                nodotemp.getnext().getnext().setPrevious(nodotemp);
            }
            else {
                nodotemp=nodotemp.getnext();
            }
        }
        if (nodotemp==first){
            first=first.getnext();
            nodotemp.getnext().setPrevious(nodotemp);
        }
        if (nodotemp==this.get(this.size())){
            nodotemp.setPrevious(nodotemp.getPrevious().getPrevious());
        }
    }






    @Override
    public boolean contains(Object value) {
        boolean encontrado=false;
        for(int i=0; i<this.size(); i++){
            if(this.getNodeValue(this.get(i))==value){
                encontrado=true;
            }
        }
        return encontrado;
    }

    public void print() {
        for(int i=0;i<this.size();i++){
            System.out.println(this.get(i).getValue());
        }
    }

    @Override
    public void addFirst(Object value){
        NodeList newNode= new NodeList(value);
        newNode.setnext(this.get(0));

    }
}
