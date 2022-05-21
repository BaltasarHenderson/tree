package TADs;

public class NodeList {
    private Object value;   //valor que hay en el nodo
    private NodeList next;  //puntero al proximo nodo, es de tipo NodeList xq apunta a un nodo
    private NodeList previous;

    public NodeList(Object value) {
        this.value = value;
        this.next = null;
        this.previous=null;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public NodeList getnext() {
        return next;
    }

    public void setnext(NodeList next) {
        this.next = next;
    }

    public NodeList getPrevious() {
        return previous;
    }

    public void setPrevious(NodeList previous) {
        this.previous = previous;
    }
}