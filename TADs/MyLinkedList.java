package TADs;

public interface MyLinkedList {

    void add (Object value);
    void remove (int value);
    Object get (int pos);
    Object getNodeValue(NodeList Node);
    int size();
    boolean contains(Object value);
    public void addFirst(Object value);
    //public void addLast(Object value);

}
