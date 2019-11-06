/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import javax.ejb.Stateless;

/**
 *
 * @author TechnoBoy
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public int add(int x, int y) {
        return x+y;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
