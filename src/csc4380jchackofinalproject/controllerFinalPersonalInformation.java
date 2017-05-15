/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc4380jchackofinalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author admin
 */


public class controllerFinalPersonalInformation {
    
    private viewFinalPersonalInformation viewPI;
    private modelFinalPersonalInformation modelPI;
    
        
    public controllerFinalPersonalInformation(viewFinalPersonalInformation viewPI, modelFinalPersonalInformation modelPI) {
    
        this.viewPI = viewPI;
        this.modelPI = modelPI;
        //modelPI.DefaultResults();
        
        //loads default values in gui/database and adds listeners
        loadDefault();
        
        
    }
    
        
        public void loadDefault(){
            modelPI.objResults = modelPI.DefaultResults();
            
            //sets default values in gui
            viewPI.setIdResults(modelPI.objResults.intFindId);
            viewPI.setNameResults(modelPI.objResults.strFindName);
            viewPI.setGenderResults(modelPI.objResults.strFindGender);
            viewPI.setAgeResults(modelPI.objResults.intFindAge);
            viewPI.setAddressResults(modelPI.objResults.strFindAddress);
            viewPI.setFatherResults(modelPI.objResults.strFindFatherName);
            viewPI.setMotherResults(modelPI.objResults.strFindMotherName);
            viewPI.setSiblingResults(modelPI.objResults.intFindSiblingNumber);
            viewPI.setPartnerResults(modelPI.objResults.strFindPartnerName);
            viewPI.setChildrenResults(modelPI.objResults.intFindChildrenNumber);
            
            //adds listeners to the buttons
            this.viewPI.addUpdateNameListener(new btnNameListener());
            this.viewPI.addUpdateGenderListener(new btnGenderListener());
            this.viewPI.addUpdateAgeListener(new btnAgeListener());
            this.viewPI.addUpdateAddressListener(new btnAddressListener());
            this.viewPI.addUpdateFatherListener(new btnFatherListener());
            this.viewPI.addUpdateMotherListener(new btnMotherListener());
            this.viewPI.addUpdateSiblingListener(new btnSiblingListener());
            this.viewPI.addUpdatePartnerListener(new btnPartnerListener());
            this.viewPI.addUpdateChildrenListener(new btnChildrenListener());
            this.viewPI.addNewPersonListener(new btnAddPersonListener());
            this.viewPI.addSearchListener(new btnSearchListener());
            
            this.viewPI.addDefaultLayoutListener(new btnDefaultListener());
            this.viewPI.addLineLayoutListener(new btnLineListener());
            this.viewPI.addBackwardsLayoutListener(new btnBackwardsListener());
            this.viewPI.addExperimentLayoutListener(new btnExperimentListener());
        }
        

        
        /************* Action Listeners ******************/
        
        //gets the values from gui and updates them in gui and in the database
    class btnNameListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            
            modelPI.objResults.strFindName = viewPI.getUpdateName();
            modelPI.UpdateName(modelPI.objResults);
        }
}
    class btnGenderListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.strFindGender = viewPI.getUpdateGender();
            modelPI.UpdateGender(modelPI.objResults);
        }
}
    class btnAgeListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.intFindAge= viewPI.getUpdateAge();
            modelPI.UpdateAge(modelPI.objResults);
        }
}
    class btnAddressListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.strFindAddress = viewPI.getUpdateAddress();
            modelPI.UpdateAddress(modelPI.objResults);
        }
}
    class btnFatherListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.strFindFatherName = viewPI.getUpdateFather();
            modelPI.UpdateFather(modelPI.objResults);
        }
}
    class btnMotherListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.strFindMotherName = viewPI.getUpdateMother();
            modelPI.UpdateMother(modelPI.objResults);
        }
}
    class btnSiblingListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.intFindSiblingNumber = viewPI.getUpdateSibling();
            modelPI.UpdateSibling(modelPI.objResults);
        }
}
    class btnPartnerListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.strFindPartnerName = viewPI.getUpdatePartner();
            modelPI.UpdatePartner(modelPI.objResults);
        }
}
    class btnChildrenListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            modelPI.objResults.intFindChildrenNumber = viewPI.getUpdateChildren();
            modelPI.UpdateChildren(modelPI.objResults);
        }
}
    class btnAddPersonListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            //viewPI.setName(modelPI.objResults.strFindName);
            //modelPI.objResults.strFindName = viewPI.getUpdateName();
            //modelPI.UpdateName(modelPI.objResults);
            
            //adds id and gets it back 
            modelPI.objResults.intFindId = modelPI.AddPerson();
            
            //sends id to be searched
            modelPI.objResults = modelPI.Search(modelPI.objResults.intFindId);
            
            //Shows the newest Id values in gui
            viewPI.setIdResults(modelPI.objResults.intFindId);
            viewPI.setNameResults(modelPI.objResults.strFindName);
            viewPI.setGenderResults(modelPI.objResults.strFindGender);
            viewPI.setAgeResults(modelPI.objResults.intFindAge);
            viewPI.setAddressResults(modelPI.objResults.strFindAddress);
            viewPI.setFatherResults(modelPI.objResults.strFindFatherName);
            viewPI.setMotherResults(modelPI.objResults.strFindMotherName);
            viewPI.setSiblingResults(modelPI.objResults.intFindSiblingNumber);
            viewPI.setPartnerResults(modelPI.objResults.strFindPartnerName);
            viewPI.setChildrenResults(modelPI.objResults.intFindChildrenNumber);
            
            //Shows a person has been successfully added
            viewPI.setAddSuccess("Person Successfully Added");
            //viewPI.setIdResults();
            
        }
}
    class btnSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            //gets id from textfield
            modelPI.objResults.intFindId = viewPI.getUpdateId();
            
            //sends id to be searched
            modelPI.objResults = modelPI.Search(modelPI.objResults.intFindId);
            
            //Shows new values in gui
            viewPI.setIdResults(modelPI.objResults.intFindId);
            viewPI.setNameResults(modelPI.objResults.strFindName);
            viewPI.setGenderResults(modelPI.objResults.strFindGender);
            viewPI.setAgeResults(modelPI.objResults.intFindAge);
            viewPI.setAddressResults(modelPI.objResults.strFindAddress);
            viewPI.setFatherResults(modelPI.objResults.strFindFatherName);
            viewPI.setMotherResults(modelPI.objResults.strFindMotherName);
            viewPI.setSiblingResults(modelPI.objResults.intFindSiblingNumber);
            viewPI.setPartnerResults(modelPI.objResults.strFindPartnerName);
            viewPI.setChildrenResults(modelPI.objResults.intFindChildrenNumber);
            
            //When person is switched after being added the AddSuccess label is cleared
            viewPI.setAddSuccess("");
            
            
            viewPI.setNotFound(modelPI.objResults.boolSearchError);
            
        }
    }
    
        /********Layout Button Actions****/
    class btnDefaultListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            viewPI.setDefaultLayout();
        }
}
    class btnLineListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            viewPI.setLineLayout();
        }
}
    class btnBackwardsListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            viewPI.setBackwardsLayout();
        }
}
      class btnExperimentListener implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
            viewPI.setExperimentLayout();
        }
}  
        
    //String strUpdateName;
}

