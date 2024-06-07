/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab8p1_antoniocastillo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ac
 */
public class Lab8P1_AntonioCastillo {
    static int frames=0;
    static ArrayList<Character> pagina = new ArrayList();
    static ArrayList <Paginacion> paginas = new ArrayList<Paginacion>();
    public static void main(String[] args) {
        int lab=0;
        while (lab==0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Laboratorio 8\n0) Generar ArrayList\n1) FIFO\n2) OPT \n3) Comparar\n4) Salir\n-> Selecciono:");
            int user=scanner.nextInt();
            switch (user){
                case 0:
                    generarArray();
                    break;
                case 1:
                    fifo();                 
                    break;
                case 2:
                    opt();
                    break;
                case 3:
                    break;
                case 4:
                    lab=1;
                    break;
            }// Fin switch
            
        }//Fin While

    }// Main
        public static void generarArray(){
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
        int tamano=0;
        while (tamano==0){
            System.out.println("Ingrese el tamaño del arraylist (Mayor o igual a 8)");
            tamano=scanner.nextInt();
        }
        while (frames<3||frames>6){
            System.out.println("Ingrese la cantidad de frames (Entre 3 y 6)");
            frames=scanner.nextInt();
        }
        for (int x=0;x<tamano;x++){
            int holder=ran.nextInt(65,90);
            char newChar= (char)(holder);
            pagina.add(newChar);
        }
        
    }
    public static void fifo(){
           Paginacion p =paginas.get(0);
           p.FIFO();
    }
    public static void opt(){
           Paginacion p =paginas.get(1);
           p.OPT();
    }
        
    public static ArrayList<Paginacion>paginacion(){
        paginas.add(new Paginacion(frames,pagina));
        return paginas;
    }
    public static ArrayList<Character> getPagina() {
        return pagina;
    }

    public static void setPagina(ArrayList<Character> pagina) {
        Lab8P1_AntonioCastillo.pagina = pagina;
    }
        
}
