/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiequation;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) {
        int choice,answer = 0,a,b;
        Scanner sc=new Scanner(System.in);
        try {
            while(true){
            Equation equ=(Equation)Naming.lookup("rmi://localhost:5000/solver");
            System.out.println("Equations :");
            System.out.println("1. (a+b)^2 \n2. (a-b)^2 \n3. (a+b)^3 \n4. (a-b)^3");
            System.out.println("Select a Equation :");
            choice=sc.nextInt();
            System.out.print("Enter value of a :");
            a=sc.nextInt();
            System.out.print("Enter value of b :");
            b=sc.nextInt();
            String equation="";
            switch(choice)
            {
                case 1:
                    answer=equ.Eq1(a, b);
                    equation=a+"^2 + "+"2."+a+"."+b+" + "+b+"^2 = ";
                    break;
                    
                case 2:
                    answer=equ.Eq2(a, b);
                    equation=a+"^2 - "+"2."+a+"."+b+" + "+b+"^2 = ";
                    break;
                    
                case 3:
                    answer=equ.Eq3(a, b);
                    equation=a+"^3 + "+"3."+a+"^2."+b+" + 3."+a+"."+b+"^2 + "+b+"^3 = ";
                    break;
                    
                case 4:
                    answer=equ.Eq4(a, b);
                    equation=a+"^3 - "+"3."+a+"^2."+b+" - 3."+a+"."+b+"^2 - "+b+"^3 = ";
                    break;
                    
                default:
                    System.out.println("Invalid Selection");
            }
            System.out.println("Answer :"+equation+answer);
            }
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
