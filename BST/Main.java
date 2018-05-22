package bst;

/**
 *
 * @author Samuel
 */

import java.io.IOException;
import java.util.Scanner;

class Main {

    static class No {

        int conteudo;
        No esquerda; 
        No direita; 

        public No(int valor) {
            this.conteudo = valor;
            esquerda = null;
            direita = null;
        }
    }

    static class Arvore {
        
        protected No raiz;
        protected int contador;

        
        public Arvore() {
            raiz = null;
            contador = 0;
        }
       
        public void inserir_Raiz(int valor) {

            No aux = new No(valor);
            raiz = aux;

        }

        public void Inserir(int valor, No no) {

            contador++;

            if (valor < no.conteudo) {
                if (no.esquerda == null) {
                    No no_Esquerda = new No(valor);
                    no.esquerda = no_Esquerda;
                } else {
                    Inserir(valor, no.esquerda);

                }
            } else if (valor > no.conteudo) {
                if (no.direita == null) {
                    No no_Direita = new No(valor);
                    no.direita = no_Direita;
                } else {
                    Inserir(valor, no.direita);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        
        try {   
            Scanner scanner = new Scanner(System.in);
            
            Arvore tree = new Arvore();
            
            int comprimento = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < comprimento; i++) {

                String entrada = scanner.nextLine();
                int valor = Integer.parseInt(entrada);

                if (i == 0) {
                    tree.inserir_Raiz(valor);
                } else {
                    //No no;
                    tree.Inserir(valor, tree.raiz);
                }
                System.out.println(tree.contador);
            }
        }catch(Exception e){
        
        }

    }

}
