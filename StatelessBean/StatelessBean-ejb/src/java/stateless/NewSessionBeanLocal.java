/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import javax.ejb.Local;

/**
 *
 * @author TechnoBoy
 */
@Local
public interface NewSessionBeanLocal {

    int add(int x, int y);
    
}
