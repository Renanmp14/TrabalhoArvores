package Metodos;
public class Main {
    public static void main(String[] args) {

        Nodos arvore = new Nodos();
        Nodos.No raiz = arvore.new No(10);

        //Ajustar a apresentação para o modelo .dot (tirar os prints, só adicionar)
        arvore.inserirNaArvore(raiz,80);
        arvore.inserirNaArvore(raiz,5);
        arvore.inserirNaArvore(raiz,70);
        arvore.inserirNaArvore(raiz,6);
        arvore.inserirNaArvore(raiz, 2);
        arvore.inserirNaArvore(raiz, 95);
        arvore.inserirNaArvore(raiz, 98);
        arvore.inserirNaArvore(raiz, 1);
        arvore.inserirNaArvore(raiz, 100);
        arvore.inserirNaArvore(raiz, 101);

        arvore.apresentaArvore(raiz);

        //Remover Valor da árvore
        /*
        System.out.println();
        System.out.println("Remoção do do valor " + 2 );
        arvore.removeValor(raiz,2);
        System.out.println();
        arvore.apresentaArvore(raiz);
        */

        //Pre EM Pós - Ordem
        /*
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
         */

        //Busca número na árvore
        /*
        System.out.println();
        System.out.println("Existe o número 30: " + arvore.buscarValor(raiz,30));
        System.out.println();
        System.out.println("Existe o número 100: " +arvore.buscarValor(raiz,100));
        */
    }
}
