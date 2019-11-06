/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import javax.ejb.Stateless;

/**
 *
 * @author TechnoBoy
 */
@Stateless
public class ArithmeticOperation implements ArithmeticOperationLocal {

    @Override
    public int Add(int x, int y) {
        return x+y;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int Minus(int x, int y) {
        return x-y;
    }

    @Override
    public int Multiply(int x, int y) {
        return x*y;
    }

    @Override
    public int Divide(int x, int y) {
        return x/y;
    }
    
}
