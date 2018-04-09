/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onp;

import java.util.Scanner;


public class ONP {
    
    static class No {
	private char conteudo;
	private No prox;
	
	public No(){
		setProx(null);
	}

	public char getConteudo() {
		return conteudo;
	}

	public void setConteudo(char conteudo) {
		this.conteudo = conteudo;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
    }
    
    static class PilhaEnc {
	No topo;
	int nElementos;
	
	public PilhaEnc(){
            topo = null;
            nElementos = 0;
        }	
	
	public int tamanho() {
	    return nElementos;	//quantidade de elementos
	}

	
	public char top (){	    
	    return topo.getConteudo();
	}

	
	public boolean push(char valor) {	    
	 
	    No novoNo = new No();
	    novoNo.setConteudo(valor);
	    
	    novoNo.setProx(topo);	    
	    
	    topo = novoNo;
	    
	    nElementos++;
	    return true;
	}

	/** Retira o elemento do topo da pilha. */
	public int pop () {
	    
	    No p = topo;	    
	    
	    topo = p.getProx();
	    
	    nElementos--;
	    
	    p= null;

	    return 0;
	}

    }
    
    
    public static void main(String[] args) {    
        Scanner scanner = new Scanner(System.in);
        int t=0;
        String str[];
        
        t = scanner.nextInt();
        str = new String[t];
        int i = 0;
        
        scanner.nextLine();
        while(i<t){            
            str[i] = scanner.nextLine();            
            i++;
        }
        
        PilhaEnc pilha1 = new PilhaEnc();
        PilhaEnc pilha2 = new PilhaEnc();
        
        int j=0, k=0,index_1[], index_2=0, get_Out=0;    
        String s = "", s2="", s1="";
        index_1 = new int[400];        
       
        
        for (i=0; i < t; i++){
            for(j=0; j < str[i].length(); j++){
                
                if(str[i].charAt(j)>= 97 && str[i].charAt(j) <= 122){
                    pilha1.push(str[i].charAt(j));                    
                }  
                                                
                if(str[i].charAt(j) == 40){ 
                   k++; 
                   index_1[k] = j;                                     
                }
                
                if (str[i].charAt(j) == 41){                     
                   index_2 = j;   
                   j = index_1[k]+1;
                 
                   
                   while(j < index_2){
                      if(str[i].charAt(j) == 40){  
                         get_Out = 1;
                         while(get_Out > 0){ 
                             j++;
                             if(str[i].charAt(j) == 40){  
                                 get_Out++;
                             }
                             if(str[i].charAt(j) == 41){  
                                 get_Out--;
                             }
                            
                         }  
                      } 
                      
                      
                       
                      if(str[i].charAt(j)== 42 || str[i].charAt(j)== 43 || str[i].charAt(j)== 45 || str[i].charAt(j)== 47 || str[i].charAt(j)== 94){
                        pilha2.push(str[i].charAt(j));                        
                      } 
                      j++;
                   }
                   k--;   
                   pilha1.push(pilha2.top());                      
                   pilha2.pop();
                   // 
                  
                }
                            
            }
            
            
            while(true){
                if(pilha1.tamanho() > 0 ){
                    if(s1 == ""){
                        s1 = "" + pilha1.top();                   
                    }
                    else{
                        s1 = pilha1.top() + s1;                   
                    }                
                    pilha1.pop();
                    
                }
                
                if(pilha2.tamanho() > 0 ){
                    if(s2 == ""){
                        s2 = "" + pilha2.top();                   
                    }
                    else{
                        s2 = pilha2.top() + s2;                   
                    }   
                    
                    pilha2.pop();  
                }
                
                s = s1 + s2;
                
                if(pilha1.tamanho() == 0 && pilha2.tamanho() == 0){
                    System.out.print(s);
                    s = "";
                    s1 = "";
                    s2 = "";
                    System.out.println("");
                    break;                    
                }
            }
                
        }
        
    }
    
}
