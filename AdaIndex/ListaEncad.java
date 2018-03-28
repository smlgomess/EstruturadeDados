/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaencad;

import java.util.Scanner;


public class ListaEncad {
    
    public static class No {
	String conteudo;
	No prox;
	
	public No(){
		setProx(null);
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
	
	
    }
    
        No cabeca;
        int nElementos;

	public ListaEncad(){
		cabeca = null;
		nElementos = 0;
	}
	
		
	public String elemento (int pos) {
	
	    No aux = cabeca;
	    // Percorre a lista do 1o elemento atÃ© pos 
	    for (int i =1; i < pos; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }

	    return aux.getConteudo();
	}
        

	/** Insere nÃ³ em lista vazia */
	public boolean insereInicioLista(String valor) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setConteudo(valor);
	    
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    nElementos++;
	    return true;
	}

	

	/** Insere nÃ³ no fim da lista */
	public boolean insereFimLista(String dado){
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Procura o final da lista 
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

	    this.nElementos++;
	    return true;
       }
    
    public static void main(String[] args)  throws java.lang.Exception{
       Scanner scanner = new Scanner(System.in);
        
        int N=0, Q=0, Contador=0;
        
        N = scanner.nextInt();
        Q = scanner.nextInt();        
                
        ListaEncad lista1 = new ListaEncad();
        ListaEncad lista2 = new ListaEncad();
       
                
        for(int i=0; i<N; i++){
            if (i==0){
                scanner.nextLine();
                lista1.insereInicioLista(scanner.nextLine());               
            }
            else
               lista1.insereFimLista(scanner.nextLine());                
        }
                
        for(int i=0; i<Q; i++){
            if (i==0)
               lista2.insereInicioLista(scanner.nextLine());             
            else
               lista2.insereFimLista(scanner.nextLine());
                
        }
        
        for (int i = 1;i<=Q; i++){
            for(int j=1;j<=N;j++){                
                if(lista1.elemento(j).startsWith(lista2.elemento(i))){
                    Contador++;
                }                    
            }
            System.out.println(Contador);
            Contador =0;
        }
        
        
    }
    
}
