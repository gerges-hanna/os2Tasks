/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gerges_Hanna
 */
public class Task1 {

    public static int i=0;
    public static void finishThread() throws InterruptedException {
        Thread t1 =new Thread(new Greeting("Hello"));
        Thread t2=new Thread(new Greeting("Goodby"));
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        if(!t1.isAlive() && !t2.isAlive())
            System.out.println("Hello Thread has finished\nGoodby Thread has finished");
        
    }
    
    public static void MatrixThread() throws InterruptedException {
        ArrayList<Thread> listThread=new ArrayList<Thread>();
        Date start = new Date();

        int[][] m1 = MatrixGenerator.generateMatrix(3, 3);
        int[][] m2 = MatrixGenerator.generateMatrix(3, 3);

        int resultRows = m1.length;
        int resultColumns = m2[0].length;
        int[][] result = new int[resultRows][resultColumns];


        i=0;
        listThread.clear();
        while (i<m1.length) {
            listThread.add(new Thread(new Runnable() {
                int x=i;
                @Override
                public void run() {
                  for (int j = 0; j < m2[0].length; j++) {
                    result[x][j]=m1[x][0]*m2[0][j]+m1[x][1]*m2[1][j]+m1[x][2]*m2[2][j];
                }
                  
                }
            })); 
            i++;
        }
        for (int j = 0; j < m1.length; j++) {
            listThread.get(j).start();
        }
        for (int j = 0; j < m1.length; j++) {
            listThread.get(j).join();
        }

        
        
        System.out.println("Matrix 1 : ");
        MatrixGenerator.print(m1);

        System.out.println("\nMatrix 2 : ");
        MatrixGenerator.print(m2);
        
        System.out.println("\nOutput Matrix : ");
        MatrixGenerator.print(result);
        


        Date end = new Date();
        System.out.println("\nTime taken in milli seconds: " + (end.getTime() - start.getTime()));
   
    }
    
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int resultRows = matrix1.length;
        int resultColumns = matrix2[0].length;

        int[][] result = new int[resultRows][resultColumns];

        int columns2 = matrix2[0].length;

        for (int i = 0; i < resultRows; i++) {
         for (int j = 0; j < columns2; j++) {
          result[i][j] = 0;
          for (int k = 0; k < resultColumns; k++) {
           result[i][j] += matrix1[i][k] * matrix2[k][j];
          }
         }
        }

        return result;
        
    }
    
    
    public static void main(String[] args) throws InterruptedException  {
        // 1 ==> Modify the Greeting program in such a way to print a message after both threads finish their work.
         
        //finishThread();
        
        // 2==> Make a program for matrix multiplication that utilizes threads to enhance performance. You should be able to identify different ways to apply multi-threading.
        //MatrixThread();
       
    
    }

       
    
    
}
