package Metodos;

public class Nodos {
    // Classe para representar os nós da árvore
    class No {
        int valor;
        No esquerda;
        No direita;

        public No(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }

        @Override
        public String toString() {
            return
                    "valor=" + valor
                    ;
        }
    }

    public void inserirNaArvore(No node, int valor) {
        if (node != null) {
            if (valor < node.valor) {
                if (node.esquerda != null) {
                    inserirNaArvore(node.esquerda, valor);
                } else {
                    System.out.println("Inserindo " + valor + " à esquerda de " + node.valor);
                    node.esquerda = new No(valor);
                }
            } else if (valor > node.valor) {
                if (node.direita != null) {
                    inserirNaArvore(node.direita, valor);
                } else {
                    System.out.println("Inserindo " + valor + " à direita de " + node.valor);
                    node.direita = new No(valor);
                }
            }
        }
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.println(no.valor + "");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public void emOrdem(No node) {
        if (node != null) {
            emOrdem(node.esquerda);
            System.out.println(node.valor + "");
            emOrdem(node.direita);

        }
    }

    public void posOrdem(No node) {
        if (node != null) {
            posOrdem(node.esquerda);
            posOrdem(node.direita);
            System.out.println(node.valor + "");
        }
    }

    public No removeMenorNoDaArvore(No nodo) {
        if (nodo == null) {
            System.out.println("ERRO");
        } else if (nodo.esquerda != null) {
            nodo.esquerda = removeMenorNoDaArvore(nodo.esquerda);
            return  nodo;
        } else{
            return nodo.direita;
        }
        return null;
    }



}
