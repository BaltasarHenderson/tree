public class Node<K extends Comparable, T> {
    private K key;
    private T data;
    private Node<K, T> leftChild;
    private Node<K, T> rightChild;

    public Node(K key, T data, Node<K, T> leftChild, Node<K, T> rightChild) {
        this.key = key;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean esHoja(){
        return !tieneHijos();
    }

    public boolean tieneHijos(){
        return tieneHijoIzquierdo() || tieneHijoDerecho();
    }
    public boolean tieneHijoIzquierdo(){
        return getLeftChild()!=null;
    }
    public boolean tieneHijoDerecho(){
        return getRightChild()!=null;
    }

    public void cambiarPorHijoIzquierdo(){
        Node hijo=leftChild;
        this.setLeftChild(this);
        this.key=hijo.getKey();
        this.data=hijo.getData();
    }

    public void cambiarPorHijoDerecho(){
        Node hijo=rightChild;
        this.setRightChild(this);
        this.key=hijo.getKey();
        this.data=hijo.getData();
    }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}
