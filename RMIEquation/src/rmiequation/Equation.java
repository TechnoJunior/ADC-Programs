/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiequation;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author TechnoBoy
 */
public interface Equation extends Remote{
    public int Eq1(int a,int b) throws RemoteException;
    public int Eq2(int a,int b) throws RemoteException;
    public int Eq3(int a,int b) throws RemoteException;
    public int Eq4(int a,int b) throws RemoteException;
}
