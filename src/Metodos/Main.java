package Metodos;
public class Main {
    public static void main(String[] args) {

        Nodos arvore = new Nodos();
        Nodos.No raiz = arvore.new No(10);

        //Ajustar a apresentação para o modelo .dot (tirar os prints, só adicionar)
        arvore.inserirNaArvore(raiz,80);
        arvore.inserirNaArvore(raiz,3);
        arvore.inserirNaArvore(raiz,70);
        arvore.inserirNaArvore(raiz,1);
        arvore.inserirNaArvore(raiz, 2);

        System.out.println();
        System.out.println("Árvore binaria Pre-Ordem");
        arvore.preOrdem(raiz);
        System.out.println();
        System.out.println("Árvore binaria Em-Ordem");
        arvore.emOrdem(raiz);
        System.out.println();
        System.out.println("Árvore binaria Pos-Ordem");
        arvore.posOrdem(raiz);
        System.out.println();


        //ajustar a apresentação
        System.out.println("Removendo menor nodo: " + arvore.removeMenorNoDaArvore(raiz));


        /*BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.insert(5, "five");
        tree.insert(3, "three");
        tree.insert(8, "eight");
        tree.insert(1, "one");
        tree.insert(2, "two");
        tree.insert(7, "seven");
        tree.insert(9, "nine");

        tree.printTree();*/
    }
}
