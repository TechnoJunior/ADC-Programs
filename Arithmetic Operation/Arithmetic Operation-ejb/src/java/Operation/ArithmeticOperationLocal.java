/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

import javax.ejb.Local;

/**
 *
 * @author TechnoBoy
 */
@Local
public interface ArithmeticOperationLocal {

    int Add(int x, int y);

    int Minus(int x, int y);

    int Multiply(int x, int y);

    int Divide(int x, int y);
    
}
