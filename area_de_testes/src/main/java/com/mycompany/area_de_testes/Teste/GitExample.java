    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.area_de_testes.Teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author icout
 */
public class GitExample {
    public static void main(String[] args) throws IOException {
        
        String repositoryPath, filePath;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Enter the repository path: ");
        repositoryPath = teclado.nextLine();
        System.out.println("Enter the file path: ");
        filePath = teclado.nextLine();
        //init("C:\\Users\\icout\\OneDrive\\Documentos\\criando_novo");
        //add("C:\\Users\\icout\\OneDrive\\Documentos\\criando_novo","C:\\Users\\icout\\OneDrive\\Documentos\\criando_novo\\texto.txt");
        init(repositoryPath);
        add(repositoryPath,filePath);
    }

    
    public static void init(String directory){
        String command1 = "git init ";
        try {
            execute(command1, directory);
        } catch (IOException ex) {
            Logger.getLogger(GitExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void add(String directory, String filePath){
        String command1 = "git add " + filePath;
        try{
            execute(command1, directory);
        } catch (IOException ex){
            Logger.getLogger(GitExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void execute(String command, String repositoryPath) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec(command, null,
                new File(repositoryPath));

        String s;

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(exec.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(exec.getErrorStream()));

        // read the output from the command
        System.out.println("==================Saida============================");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // read any errors from the attempted command
        System.out.println("==================Erro============================");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }
}

