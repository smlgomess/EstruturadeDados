/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsequences;

/**
 *
 * @author Samuel
 */
import java.util.Scanner;

 class Lista { 
    
    int dados[];
    int tamAtual;
    int tamMax;
        
    public Lista (int valor){
        tamMax = valor;
        tamAtual = 0;
        dados = new int [tamMax];
    }
         
    public int elemento(int pos){
        int dado;         
        dado = dados[pos-1];
        return dado;
    }
    
    public int tamanho(){
        return tamAtual;
    }
    
    public boolean insere (int pos, int dado){       
        for (int i = tamAtual; i >= pos; i--){
            dados[i] = dados[i-1];
        }
        
        dados[pos - 1] = dado;
        tamAtual++;
        return true;
    }
    
    
        
    public static void main(String[] args) {
   
        
        Scanner scanner = new Scanner(System.in); 
        
        Lista list1, list2;
        int tamanho,i;     
        int array[];
        
               
        tamanho = scanner.nextInt(); 
        list1 = new Lista(tamanho);
        
        i=0;
        while (i < tamanho){
            list1.insere(i+1, scanner.nextInt());
            i++;           
        }
        
        tamanho = scanner.nextInt();        
        list2 = new Lista(tamanho);
        
        i=0;
        while (i < tamanho){
            list2.insere(i+1, scanner.nextInt());
            i++;           
        }
                
        array = new int[list1.tamanho()];
        int a=0;
        
        for (int j = 0; j<list1.tamanho(); j++){
            for (int k = 0; k<list2.tamanho(); k++){
                if (list1.elemento(j+1) == list2.elemento(k+1)){
                    break;
                }
                
                else if (k == list2.tamanho() - 1){
                    array[a] = list1.elemento(j+1);        
                    if(a > 0){                        
                        for(int t = a-1; t >= 0; t--){
                            if(array[t] > list1.elemento(j+1)){                                
                                array[t+1] = array[t];
                                array[t] = list1.elemento(j+1);                                 
                            }
                            else
                                break;
                             
                        }
                     } 
                    a++;   
                }   
                                    
            }
        }
                      
        i = 0;
        while (i < a){
            if(i+1 == a)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + " ");  
            
            i++;
        }                
    }
    
}
