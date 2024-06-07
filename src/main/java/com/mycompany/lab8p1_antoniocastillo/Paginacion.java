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
        System.out.println("Pagina "+holder1+" llega");
        System.out.println(RAM);
        cache_miss=cache_miss+1;
        for (int x=1;x<paginas.size();x++){
            char holder=paginas.get(x);
            for (int y=1;y<RAM.size();y++){
                if (holder==RAM.get(y)){
                    validar=1;
                }
            }
            if (validar==1){
                System.out.println("Pagina "+holder+" llega");
                System.out.println(RAM);
                System.out.println("Acceso a página tal");
                
                cache_hit++;
            }
            else{
                if (cache_miss>frames){
                    System.out.println("Pagina "+holder+" llega");
                    System.out.println(RAM);
                    char holder3=RAM.get(0);
                    System.out.println("Pagina "+holder3+" sale de ram y llega a disco");
                    disco.add(holder3);
                    RAM.add(holder);
                    RAM.remove(0);
                    System.out.println(RAM);
                    cache_miss++;
                }
                else{
                    System.out.println("Pagina "+holder+" llega");
                    System.out.println(RAM);
                    RAM.add(holder);
                    cache_miss++;
                }
            }
            validar=0;
        }
    }

    @Override
    public String toString() {
        return "Arraylist Generado \n" +  paginas ;
    }

    public void OPT(){
        int pos=0;
        int validar=0;
        char holder1=paginas.get(0);
        RAM.add(holder1);
        cache_miss=cache_miss+1;
        for (int x=1;x<paginas.size();x++){
            char holder=paginas.get(x);
            for (int y=0;y<RAM.size();y++){
                if (holder==RAM.get(y)){
                    validar=1;
                    pos=y;
                    
                }
            }
            if (validar==1){
                while(pos<RAM.size()){
                    pos++;
                }
                System.out.println("Acceso a página tal");
                cache_hit++;
                
            }
            else{
                if (cache_miss>frames){
                    System.out.println("Pagina "+holder+" llega");
                    System.out.println(RAM);
                    char holder3=RAM.get(0);
                    System.out.println("Pagina "+holder3+" sale de ram y llega a disco");
                    disco.add(holder3);
                    RAM.add(holder);
                    RAM.remove(0);
                    System.out.println(RAM);
                    cache_miss++;
                }
                else{
                    System.out.println("Pagina "+holder+" llega");
                    RAM.add(holder);
                    cache_miss++;
                }
            }
            validar=0;
        }
        System.out.println("CACHE HIT: "+cache_hit);
        System.out.println("CACHE MISS: "+cache_miss);
        
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
