/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8p1_antoniocastillo;

import java.util.ArrayList;

/**
 *
 * @author ac
 */
public class Paginacion {
    int cache_miss=0;
    int cache_hit=0;
    int frames=0;
    ArrayList<Character> paginas = new ArrayList();
    ArrayList<Character> RAM = new ArrayList();
    ArrayList<Character> disco = new ArrayList();

    public Paginacion(int frames,ArrayList<Character>array) {
       this.frames = frames;
       this.paginas=array; 
       
    }
    
    public void FIFO(){
        int validar=0;
        char holder1=paginas.get(0);
        RAM.add(holder1);
        cache_miss=cache_miss+1;
        for (int x=1;x<paginas.size();x++){
            char holder=paginas.get(x);
            for (int y=0;y<RAM.size();y++){
                if (holder==RAM.get(y)){
                    validar=1;
                }
            }
            if (validar==1){
                System.out.println("Acceso a página tal");
                
                cache_hit++;
            }
            else{
                if (cache_miss>frames){
                    char holder3=RAM.get(0);
                    disco.add(holder3);
                    RAM.set(0,holder);
                    cache_miss++;
                }
                else{
                    RAM.add(holder);
                    cache_miss++;
                }
            }
            validar=0;
        }
    }
    public void OPT(){
        int validar=0;
        char holder1=paginas.get(0);
        RAM.add(holder1);
        cache_miss=cache_miss+1;
        for (int x=1;x<paginas.size();x++){
            char holder=paginas.get(x);
            for (int y=0;y<RAM.size();y++){
                if (holder==RAM.get(y)){
                    validar=1;
                }
            }
            if (validar==1){
                System.out.println("Acceso a página tal");
                
                cache_hit++;
            }
            else{
                if (cache_miss>frames){
                    char holder3=RAM.get(0);
                    disco.add(holder3);
                    RAM.set(0,holder);
                    cache_miss++;
                }
                else{
                    RAM.add(holder);
                    cache_miss++;
                }
            }
            validar=0;
        }   
        
    }

    public int getCache_miss() {
        return cache_miss;
    }

    public void setCache_miss(int cache_miss) {
        this.cache_miss = cache_miss;
    }

    public int getCache_hit() {
        return cache_hit;
    }

    public void setCache_hit(int cache_hit) {
        this.cache_hit = cache_hit;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public ArrayList<Character> getPaginas() {
        return paginas;
    }

    public void setPaginas(ArrayList<Character> paginas) {
        this.paginas = paginas;
    }

    public ArrayList<Character> getRAM() {
        return RAM;
    }

    public void setRAM(ArrayList<Character> RAM) {
        this.RAM = RAM;
    }

    public ArrayList<Character> getDisco() {
        return disco;
    }

    public void setDisco(ArrayList<Character> disco) {
        this.disco = disco;
    }

    
    
    

   
    
}
