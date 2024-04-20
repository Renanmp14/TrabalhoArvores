package Metodos;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

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
    }

    // Método para adicionar um valor na Arvore
    public void inserirNaArvore(No node, int valor) {
        if (node != null) {
            if (valor < node.valor) {
                if (node.esquerda != null) {
                    inserirNaArvore(node.esquerda, valor);
                } else {
                    //System.out.println("Inserindo " + valor + " à esquerda de " + node.valor);
                    node.esquerda = new No(valor);
                }
            } else if (valor > node.valor) {
                if (node.direita != null) {
                    inserirNaArvore(node.direita, valor);
                } else {
                    //System.out.println("Inserindo " + valor + " à direita de " + node.valor);
                    node.direita = new No(valor);
                }
            }
        }
    }
    //Apresenta a Arvoré
    public void apresentaArvore(No raiz) {
        if (raiz == null)
            return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            int tamanho = fila.size();

            for (int i = 0; i < tamanho; i++) {
                No node = fila.poll();
                if (node != null) {
                    if (node.esquerda != null) {
                        System.out.print(node.valor + " -- " + node.esquerda.valor);
                        fila.add(node.esquerda);
                        if (node.direita != null) {
                            System.out.print("\n" + node.valor + " -- " + node.direita.valor);
                            fila.add(node.direita);
                        }
                        System.out.println();
                    } else if (node.direita != null) {
                        System.out.print(node.valor + " -- " + node.direita.valor);
                        fila.add(node.direita);
                        System.out.println();
                    }
                }
            }
        }
    }

    //Ordenação da Arvore
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

    //Remoção do valor no nó
    public void removeValor(No raiz,int valor){
        raiz = remover(raiz,valor);
    }
    private No remover (No node,int valor){
        if (node == null)
            return null;
        if (valor < node.valor) {
            node.esquerda = remover(node.esquerda, valor);
        } else if (valor > node.valor) {
            node.direita = remover(node.direita, valor);
        } else {
            if (node.esquerda == null)
                return node.direita;
            else if (node.direita == null)
                return node.esquerda;

            node.valor = menorValor(node.direita);
            node.direita = remover(node.direita, node.valor);
        }
        return node;
    }
    private int menorValor(No node){
        int menor = node.valor;
        while (node.esquerda != null){
            menor = node.esquerda.valor;
            node = node.esquerda;
        }
        return menor;
    }

    //Pesquisar a existencia
    public boolean buscarValor(No raiz,int valor) {
        if (raiz == null)
            return false;
        if (raiz.valor == valor)
            return true;
        if (valor < raiz.valor)
            return buscarValor(raiz.esquerda, valor);
        else
            return buscarValor(raiz.direita, valor);
    }

    //Geran número randomico
    public int numeroAleatorio (int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    //Método utilizado para gerar o arquivo de saída
    public void gerarArquivoGraph(No raiz) {
        if (raiz == null)
            return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        try {
            String caminhoArquivo = "src/OutArquivo/graph.dot";
            File file = new File(caminhoArquivo);

            // Exclui o arquivo se ele já existir
            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();
            FileWriter escritor = new FileWriter(file);

            // Escreve no arquivo
            escritor.write("graph {\n");

            while (!fila.isEmpty()) {
                int tamanho = fila.size();

                for (int i = 0; i < tamanho; i++) {
                    No node = fila.poll();
                    if (node != null) {
                        if (node.esquerda != null) {
                            escritor.write("\t" + node.valor + " -- " + node.esquerda.valor + ";\n");
                            fila.add(node.esquerda);
                            if (node.direita != null) {
                                escritor.write("\t" + node.valor + " -- " + node.direita.valor + ";\n");
                                fila.add(node.direita);
                            }
                        } else if (node.direita != null) {
                            escritor.write("\t" + node.valor + " -- " + node.direita.valor + ";\n");
                            fila.add(node.direita);
                        }
                    }
                }
            }
            escritor.write("}");
            escritor.close();
            System.out.println("Arquivo gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}


