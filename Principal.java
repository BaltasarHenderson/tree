public class Principal {
    public static void main(String[] args) {
        MyTreeImpl<Integer, String> miArbolFacherito = new MyTreeImpl();

        miArbolFacherito.insert(5,"Mesi",null);
        miArbolFacherito.insert(6,"Luis",5);
        miArbolFacherito.insert(7,"Cacha",6);
        miArbolFacherito.insert(8,"Cebolla",7);
        miArbolFacherito.insert(9,"Boka",8);
        miArbolFacherito.insert(4,"River",5);
        miArbolFacherito.insert(2,"Barsita",4);
        miArbolFacherito.insert(3,"Oriente Petrolero",2);
        miArbolFacherito.insert(12,"Guardiola",4);

        System.out.println("Size: " + miArbolFacherito.size(miArbolFacherito.root));
        System.out.println("Hojas: " + miArbolFacherito.countLeaf(miArbolFacherito.root));
        System.out.println("Hojas'nt: " + miArbolFacherito.countCompleteElements(miArbolFacherito.root));
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
