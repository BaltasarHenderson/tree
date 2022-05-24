public class Principal {
    public static void main(String[] args) {
        MyTreeImpl<Integer, String> miArbolFacherito = new MyTreeImpl();

        miArbolFacherito.insert(5,"Cinco",null);
        miArbolFacherito.insert(6,"Seis",5);
        miArbolFacherito.insert(7,"Siete",6);
        miArbolFacherito.insert(8,"Ocho",7);
        miArbolFacherito.insert(9,"Nueve",8);
        miArbolFacherito.insert(4,"Cuatro",5);
        miArbolFacherito.insert(2,"Dos",4);
        miArbolFacherito.insert(3,"Tres",2);
        miArbolFacherito.insert(12,"Doce",4);

        System.out.println("Size: " + miArbolFacherito.size(miArbolFacherito.root));
        System.out.println("Hojas: " + miArbolFacherito.countLeaf(miArbolFacherito.root));
        System.out.println("Elementos completos: " + miArbolFacherito.countCompleteElements(miArbolFacherito.root));
        System.out.print("InOrder: ");
        miArbolFacherito.inOrder(miArbolFacherito.root);
        System.out.println();
        System.out.print("PostOrder: ");
        miArbolFacherito.postOrder(miArbolFacherito.root);
        System.out.println();
        System.out.print("PreOrder: ");
        miArbolFacherito.preOrder(miArbolFacherito.root);
        System.out.println();
    }


    //prueba push
    //push2
}
