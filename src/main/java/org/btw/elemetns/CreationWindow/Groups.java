package org.btw.elemetns.CreationWindow;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Groups {
    public ToggleGroup cameraTypeGroup = new ToggleGroup();
    public ToggleGroup ShootingModeGroup = new ToggleGroup();
    public ToggleGroup InputModuleGroup = new ToggleGroup();
    public ToggleGroup OutputConnectorGroup = new ToggleGroup();
    public Groups(Buttons buttons){
        makeGroup(cameraTypeGroup, buttons.SLRCamera, buttons.WebCamera, buttons.PhoneCamera);
        makeGroup(ShootingModeGroup, buttons.inputShootingModePhoto, buttons.inputShootingModeVideo);
        makeGroup(InputModuleGroup, buttons.frontModule, buttons.mainModule);
        makeGroup(OutputConnectorGroup, buttons.connectorTypeA, buttons.connectorTypeC);
    }
    private void makeGroup(ToggleGroup g, RadioButton b1, RadioButton b2, RadioButton b3){
        b1.setToggleGroup(g);
        b2.setToggleGroup(g);
        b3.setToggleGroup(g);

    }
    private void makeGroup(ToggleGroup g, RadioButton b1,RadioButton b2){
        b1.setToggleGroup(g);
        b2.setToggleGroup(g);
        g.selectToggle(b1);
    }
}
