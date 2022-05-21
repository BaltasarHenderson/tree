import TADs.MyLinkedListImpl;

import java.util.List;

public interface MyTree<K, T> {
    T find(K key);
    void insert (K key, T data, K parentKey);
    void delete (K key);
    int size(Node nodo);
    int countLeaf(Node nodo);
    int countCompleteElements(Node nodo);

    void inOrder(Node nodo);
    void preOrder(Node nodo);
    void postOrder(Node nodo);
}
