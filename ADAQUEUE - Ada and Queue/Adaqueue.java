/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaqueue;

import java.util.Scanner;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Samuel
 */
public class Adaqueue {
    
    static class LDE {
     
    class No {
        private No ant;
	private int conteudo;
	private No prox;
	public No(){
            setProx(null);
        }
	public int getConteudo() {
            return conteudo;
	}
	public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
	}
	public No getProx() {
            return prox;
	}
	public void setProx(No prox) {
            this.prox = prox;
	}
	public No getAnt() {
            return ant;
	}
	public void setAnt(No ant) {
            this.ant = ant;
	}
    }
    private No inicio;
    private No fim;
    private int tamanho;
    private boolean reverse;
    public LDE(){
        inicio = null;
	fim = null;		
	tamanho = 0;
        reverse = false;     
    }
    public boolean vazia() {
        if (tamanho == 0)
            return true;
        else
            return false;
    }
    public int tamanho() {
        return tamanho;
    }
    private void insereInicioLista(int dado){
        if(reverse == true){
            inverteLista();
            insereFimLista(dado);
            inverteLista();
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(dado);
            novoNo.setAnt(null);
            if (vazia()){
                inicio = novoNo;
                fim = novoNo;
            }
            else{
                inicio.setAnt(novoNo);    	    
                novoNo.setProx(inicio);
            }
            inicio = novoNo;
            tamanho++;
        }
    }
    private void insereFimLista(int dado){
        if(vazia()){
            insereInicioLista(dado);
        }
        else if(reverse == true){
            inverteLista();
            insereInicioLista(dado);
            inverteLista();
        }
        else{
            No novoNo = new No();
            novoNo.setConteudo(dado);
            novoNo.setProx(null);
            novoNo.setAnt(fim);
            fim.setProx(novoNo);
            fim = novoNo; 
            this.tamanho++;
        }
    }
    private int removeInicioLista(){
        int dado = 0;
        if(reverse == true){
            inverteLista();
            dado = removeFimLista();
            inverteLista();
            return dado;
        }
        else{
            No p = inicio;
            dado = p.getConteudo();
            if(inicio == fim){
                inicio = null;
                fim = null;
            }
            else{
                inicio = p.getProx();
                p.setProx(null);
                inicio.setAnt(null);
            }
            tamanho--;
            p = null;   
            return dado;
        }
    }
    private int removeFimLista(){          
        int dado = 0;
        if(reverse == true){
            inverteLista();
            dado = removeInicioLista();
            inverteLista();
            return dado;
        }
        else{
            No p = fim;
            dado = p.getConteudo();
            if(inicio == fim){
                inicio = null;
                fim = null;
            }
            else{
                fim = p.getAnt();
                fim.setProx(null);
            }
            tamanho--;
            p = null;
            return dado;
        }
    }
    private void inverteLista(){
        if(vazia()){
            return;
        }
        else{
            No aux = inicio;
            inicio = fim;
            fim = aux;
            reverse = !reverse;        
        }
    }

	
    }
    
     
        
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        
        int q=0,t=0,valor=0;          
        LDE lista1 = new LDE();      
        
        q = scanner.nextInt();        
        
        String s[] = new String[q];
                
        scanner.nextLine();
        while(t<q){
            s[t] = scanner.nextLine();
            t++;            
        }
        
        t=0;
        while (t<q){
            
            if(s[t].startsWith("toFront")){                
                valor = Integer.parseInt(s[t].substring(8));
                lista1.insereInicioLista(valor);  
            }
            
            else if(s[t].startsWith("push_back")){                
                    valor = Integer.parseInt(s[t].substring(10));
                    if(lista1.tamanho() == 0)
                        lista1.insereInicioLista(valor);

                    else
                        lista1.insereFimLista(valor); 
                
            }
            else{
                switch (s[t]){
                    case "front":                       
                        if(lista1.tamanho() == 0)
                            System.out.println("No job for Ada?");
                        else{
                            
                            System.out.println(lista1.removeInicioLista()); 
                            
                        }
                        
                        
                        break;
                    case "back":                        
                            if(lista1.tamanho() == 0)
                                System.out.println("No job for Ada?");
                            else{
                               
                                System.out.println(lista1.removeFimLista());                                 
                            }
                       
                        break;
                        
                    case "reverse":
                        lista1.inverteLista();
                        break;                   
                    default: 
                }
            }
            t++;
        }
       
    }
    
}
        
        
        
        
        /*
    
    static class LSE {
	private No cabeca;
	private int nElementos;
        private No fim;
        
	public LSE(){
		cabeca = null;
		nElementos = 0;
                fim = null;
	}
		
	
        
        
        
	public int tamanho() {
	    //return nElementos;
		No aux = cabeca;
		int cont = 0;
		while(aux != null){
			aux = aux.getProx();
			cont++;
		}
		return cont;
	}

	
	public int elemento (int pos) {
	    
	    if ((pos < 1) || (pos > tamanho())){
	        return -1; // Posicao invalida 
	    }
	    
	    No aux = cabeca;
	    // Percorre a lista do 1o elemento atÃ© pos 
	    for (int i =1; i < pos; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }

	    return aux.getConteudo();
	}

	
	
	private boolean insereInicioLista(int valor) {
	     
	    if(reverse == true){
                inverte_lista();
                insereFimLista(valor);
                inverte_lista();
                return true;
            }
            
            No novoNo = new No();    
	    novoNo.setConteudo(valor);
            
	    if(nElementos == 0){
                novoNo.setProx(cabeca);
                cabeca = novoNo;
                fim = novoNo;
                fim.setProx(null);
                nElementos++;
                return true;
            }
            else{
                novoNo.setProx(cabeca);
                cabeca = novoNo;
                nElementos++;
                return true; 
            }
	}

		
	private boolean insereFimLista(int dado){
	    
	    if(reverse == true){
                inverte_lista();
                insereInicioLista(dado);
                inverte_lista();
                return true;
            }
            
            No novoNo = new No();
	    novoNo.setConteudo(dado);
            
            novoNo.setProx(null);
            fim.setProx(novoNo);
            fim = novoNo;
            this.nElementos++;            
            return true;
	}

	
	private int removeInicioLista(){
            int dado = 0; 
            if(reverse == true){
                inverte_lista();
                dado = removeFimLista();
                inverte_lista();
                return dado;
            }
            
            No p = cabeca;	    
            dado = p.getConteudo();

            if(nElementos > 1){
                cabeca = p.getProx();            
                nElementos--;
            }
            else{
                cabeca = p.getProx();
                fim = null;
                nElementos--;
            }
            
            p = null;
	    return dado;
            
	}

	
	private int removeFimLista(){            
            int dado = 0;	 
            
            if(reverse == true){
                inverte_lista();
                dado = removeInicioLista();
                inverte_lista();
                return dado;
            }            
            
	    No p = fim;
	    No aux = cabeca;            
	    dado = p.getConteudo();	    
            
	    // Percorre a lista do 1o elemento atÃ© pos 
	    for (int i =1; i < nElementos-1; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }
            
            if(nElementos > 1){
                fim = aux; 
                fim.setProx(null);
                nElementos--;
            }
            else{
                cabeca = p.getProx();
                fim = null;
                nElementos--;
            }
	    
	    p = null;
	    return dado;
	}

	
   }

    
}*/
