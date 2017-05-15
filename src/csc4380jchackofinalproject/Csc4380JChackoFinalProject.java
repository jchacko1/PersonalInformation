/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc4380jchackofinalproject;

/**
 *
 * @author admin
 */
public class Csc4380JChackoFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        
        viewFinalPersonalInformation viewPI = new viewFinalPersonalInformation();
        modelFinalPersonalInformation modelPI = new modelFinalPersonalInformation();
        
        controllerFinalPersonalInformation controllerPI = new controllerFinalPersonalInformation(viewPI, modelPI);
        
        modelPI.modelFinalPersonalInformation();
        
        
        
        viewPI.setVisible(true);
        
        
    }
    
}

