import TADs.MyLinkedListImpl;

public class MyTreeImpl<K extends Comparable, T> implements MyTree<K, T> {

    Node<K, T> root = new Node(null, null, null, null);
    MyLinkedListImpl inOrder = new MyLinkedListImpl();

    private Node<K, T> findNode(K key, Node<K, T> root) {
        Node<K, T> resultado = this.root;
        /*if (this.root.getKey() == null) {
            return null;
        }
        if (this.root == null) {
            return null;
        } else {
            if (this.root.getKey() == key) {
                resultado = this.root;
            }
            resultado = findNode(key, this.root.getLeftChild());
            if (resultado == null) {
                resultado = findNode(key, this.root.getRightChild());
            }
            return resultado;
        }*/


        // Traverse until root reaches to dead end
        while (resultado != null) {
            // pass right subtree as new tree
            if (key.compareTo(resultado.getKey()) > 0)
                resultado = resultado.getRightChild();

                // pass left subtree as new tree
            else if (key.compareTo(resultado.getKey()) < 0)
                resultado = resultado.getLeftChild();
            else
                return resultado; // if the key is found return 1
        }
        return null;
    }

    @Override
    public T find(K key) {
        return findNode(key, root).getData();
    }

    @Override
    public void insert(K key, T data, K parentKey) {
        if (parentKey == null) {
            Node<K, T> nodoNuevo = new Node(key, data, null, null);
            this.root = nodoNuevo;
            System.out.println("Insertado");
        } else {
            Node<K, T> nodoPadre = findNode(parentKey, root);
            if (nodoPadre != null) {
                if (nodoPadre.getKey().compareTo(key) < 0 && nodoPadre.getRightChild() == null) {
                    Node<K, T> nodoNuevo = new Node(key, data, null, null);
                    nodoPadre.setRightChild(nodoNuevo);
                    System.out.println("Insertado");
                } else if (nodoPadre.getKey().compareTo(key) > 0 && nodoPadre.getLeftChild() == null) {
                    Node<K, T> nodoNuevo = new Node(key, data, null, null);
                    nodoPadre.setLeftChild(nodoNuevo);
                    System.out.println("Insertado");
                } else {
                    System.out.println("Error");
                }
            }
            if (nodoPadre == null) {
                System.out.println("Error");
            }
        }
    }

    private Node<K,T> getMax(Node<K,T> root){
        Node<K,T> result=null;
        if (root!=null){
            if (root.getRightChild()==null){
                result=root;
            } else {
                result= getMax(root.getRightChild());
            }
        }
        return result;
    }

    public void delete(K key) {
        root=delete(key,root);
    }

    private Node<K,T> delete(K key, Node<K,T> root) {
        Node<K,T> returnTree= root;
        if(root!=null) {
            if (root.getKey().compareTo(key) == 0) {
                if (root.getLeftChild() == null && root.getRightChild() == null) {
                    returnTree = null;
                } else if (root.getLeftChild() == null) {
                    returnTree = root.getRightChild();
                } else if (root.getRightChild() == null) {
                    returnTree = root.getLeftChild();
                } else {
                    Node<K, T> max = getMax(root.getLeftChild());
                    root.setKey(max.getKey());
                    root.setData(max.getData());
                    root.setLeftChild(delete(max.getKey(), root.getLeftChild()));
                }

            } else if (root.getKey().compareTo(key) > 0) {
                root.setRightChild(delete(key, root.getRightChild()));
            } else if (root.getKey().compareTo(key) < 0) {
                root.setLeftChild(delete(key, root.getLeftChild()));
            }
            return returnTree;
        }
        else{
            return null;
        }
    }

    public Node<K,T> encontrarPadre(Node nodo) {
        Node<K, T> nodoTemporal = root;
        if (nodoTemporal.getKey() == nodo.getKey()) {
            return null;
        } else {
            if (nodoTemporal.tieneHijoIzquierdo()) {
                if (nodoTemporal.getLeftChild() == nodo) {
                    return nodoTemporal;
                }
                nodoTemporal = encontrarPadre(nodoTemporal.getLeftChild());
            } else if (nodoTemporal != null && nodoTemporal.tieneHijoDerecho()) {
                if (nodoTemporal.getRightChild() == nodo) {
                    return nodoTemporal;
                }
                nodoTemporal = encontrarPadre(nodoTemporal.getRightChild());
            } else {
                encontrarPadre(nodo);
            }
        }
        return encontrarPadre(nodoTemporal);
    }

    @Override
    public int size(Node nodo) {
        if (nodo.esHoja()) {
            return 1;
        } else {
            if (nodo.tieneHijoIzquierdo() && !nodo.tieneHijoDerecho()) {
                return 1 + size(nodo.getLeftChild());
            }
            if (!nodo.tieneHijoIzquierdo() && nodo.tieneHijoDerecho()) {
                return 1 + size(nodo.getRightChild());
            }
            if (nodo.tieneHijoIzquierdo() && nodo.tieneHijoDerecho()) {
                return 1 + size(nodo.getRightChild()) + size(nodo.getLeftChild());
            }

        }
        return 0;
    }

    @Override
    public int countLeaf(Node nodo) {
        if (nodo.tieneHijoIzquierdo() && !nodo.tieneHijoDerecho()) {
            return countLeaf(nodo.getLeftChild());
        }
        if (!nodo.tieneHijoIzquierdo() && nodo.tieneHijoDerecho()) {
            return countLeaf(nodo.getRightChild());
        }
        if (nodo.tieneHijoIzquierdo() && nodo.tieneHijoDerecho()) {
            return countLeaf(nodo.getRightChild()) + countLeaf(nodo.getLeftChild());
        }
        if (nodo.esHoja()) {
            return 1;
        }
        return 0;
    }

    @Override
    public int countCompleteElements(Node nodo) {

        return size(nodo) - countLeaf(nodo);
    }

    @Override
    public void inOrder(Node nodo) {
        if (nodo == null) {
            return;
        }
        inOrder(nodo.getLeftChild());
        System.out.printf("%s ", nodo.getData());
        inOrder(nodo.getRightChild());
    }

    @Override
    public void preOrder(Node nodo) {
        if (nodo == null) {
            return;
        }
        System.out.printf("%s ", nodo.getData());
        inOrder(nodo.getLeftChild());
        inOrder(nodo.getRightChild());
    }

    @Override
    public void postOrder(Node nodo) {
        if (nodo == null) {
            return;
        }
        inOrder(nodo.getLeftChild());
        inOrder(nodo.getRightChild());
        System.out.printf("%s ", nodo.getData());
    }

}
