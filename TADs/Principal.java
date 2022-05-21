package TADs;

public class Principal {
    public static void main(String[] args) {
        //yLinkedListImpl miLista = new MyLinkedListImpl();
        //MyLinkedListCircular miLista = new MyLinkedListCircular();
        //Queue miLista = new Queue();
        Stack miLista = new Stack();

        miLista.add(1);
        miLista.add(2);
        miLista.add(3);
        miLista.add(4);
        miLista.add(5);
        miLista.add(6);
        //System.out.println(miLista.size());
        //miLista.remove(5);
//        System.out.println("Sale el: " + miLista.dequeue());
        System.out.println("Sale el: " + miLista.pop());
        miLista.push(33);
        miLista.print();
    }
}
