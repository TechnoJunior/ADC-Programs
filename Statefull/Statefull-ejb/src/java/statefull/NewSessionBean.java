/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefull;

import javax.ejb.Stateful;

/**
 *
 * @author TechnoBoy
 */
@Stateful
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public String show(String Name) {
        return Name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
