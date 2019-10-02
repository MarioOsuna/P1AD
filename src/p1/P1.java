/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner teclado = new Scanner(System.in);
        //variables
        String fich1,texto,fich2; 
                
        //Introducir primera ruta
        System.out.print("Introduzca la ruta de un fichero de texto: ");
        fich1=teclado.nextLine();           
            
              
        System.out.println("Introduzca texto: ");
        texto=teclado.nextLine();

        escribirfich(fich1,texto);


         System.out.println("Introduzca ruta del segundo fichero");
        fich2=teclado.nextLine();

         System.out.println("");            
         cambiar(fich1,fich2);

         System.out.println("Fichero 1: ");
         leerfich(fich1);
         System.out.println("Fichero 2: ");
         leerfich(fich2);
          
        
    }
    public static void leerfich(String fich) throws FileNotFoundException, IOException{
        
        File fichero=new File(fich);
        FileReader fic= new FileReader(fichero);
        int i;
        
        while ((i=fic.read())!=-1){
            System.out.print((char) i);
        }
        fic.close();       
        
        
    }
    public static void cambiar(String fich,String fich2) throws FileNotFoundException, IOException
    {
         File fichero=new File(fich);         
         
        FileReader fic= new FileReader(fichero);
        int i;
        char letra;
        String cadena="";
        
        while ((i=fic.read())!=-1)
        {
           
           letra=(char) i;
           if(Character.isUpperCase(letra))
           {
               cadena=cadena+Character.toLowerCase(letra);
           }
           else
           {
                if(Character.isLowerCase(letra))
                {
                    cadena=cadena+Character.toUpperCase(letra);
                }
                else
                {
                    cadena=cadena+" ";
                }
           }
        }
        escribirfich(fich2,cadena);
        fic.close();  
    }
    public static void  escribirfich(String fi,String texto) throws IOException
    {
        File fichero=new File(fi);
        BufferedWriter fich= new BufferedWriter(new FileWriter(fichero,true));
        
        fich.write(texto);
        
        fich.newLine();
        
        fich.close();
    }
    
}
