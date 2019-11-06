/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiequation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author TechnoBoy
 */
public class EquationImpl extends UnicastRemoteObject implements Equation {

    int ans=0;
    public EquationImpl() throws RemoteException {
    }

    @Override
    public int Eq1(int a, int b) throws RemoteException {
        ans=(a*a)+(2*a*b)+(b*b);
        return ans;
    }

    @Override
    public int Eq2(int a, int b) throws RemoteException {
        ans=(a*a)-(2*a*b)+(b*b);
        return ans;
    }

    @Override
    public int Eq3(int a, int b) throws RemoteException {
        ans=(a*a*a)+(3*a*a*b)+(3*a*b*b)+(b*b*b);
        return ans;
    }

    @Override
    public int Eq4(int a, int b) throws RemoteException {
        ans=(a*a*a)-(3*a*a*b)-(3*a*b*b)-(b*b*b);
        return ans;
    }
    
}
