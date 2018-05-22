package nicebtree;

/**
 *
 * @author Samuel
 */

import java.io.*;
import java.util.Scanner;


class Main {
    
	static class No {
		private char Caracter;
		private No esquerda;
		private No direita;
		
		public No(char Caractere){
			this.Caracter = Caractere;
			esquerda = null;
			direita = null;
		}
	}
	
	static class Arvore{
		private No raiz;		
		private int index = 0;
		
		public Arvore() {
			raiz = null;
		}
		
                		
		public void Inserir(char Array[]) {
			No novo_No = new No(Array[index]);
			raiz = novo_No;
			
			if(Array[index] == 'n') {
				novo_No.esquerda = add_Leaf(raiz, Array[++index], Array);
				novo_No.direita = add_Leaf(raiz, Array[++index], Array);
			}
			
		}		
                
                public No add_Leaf(No parent, char Caracter, char c[]) {
			No aux = new No(Caracter);
			
			if(Caracter == 'n') {
				aux.esquerda = add_Leaf(aux,c[++index], c);
				aux.direita = add_Leaf(aux, c[++index], c);

			}
			return aux;
		}
		
		public int getProfundidade(No no) {
			if(no.Caracter == 'l') {
				return 0;
			}
			
			int profundidade_esquerda = getProfundidade(no.esquerda);
			int profundidade_direita = getProfundidade(no.direita);
			
			if(profundidade_esquerda> profundidade_direita) {
				return ++profundidade_esquerda;
			}else {
				return ++profundidade_direita;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		try{
			Scanner scanner = new Scanner (System.in);
			
			int comprimento = Integer.parseInt(scanner.nextLine());
			int saida[] = new int[comprimento];
			
			for(int i = 0; i < comprimento; i++) {
				
				String aux = scanner.nextLine();
				char letra[] = aux.toCharArray();
				Arvore tree = new Arvore();
				tree.Inserir(letra);
				saida[i] = tree.getProfundidade(tree.raiz);
			}
			
			for(int i = 0; i< comprimento; i++) {
				System.out.println(saida[i]);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}