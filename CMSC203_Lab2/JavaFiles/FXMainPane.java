


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	
	Label label;
	TextField text;
	
	//  declare two HBoxes
	HBox HBox1;
	HBox HBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
    DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		button6 = new Button("Turkish");
		
		label = new Label("Feedback: ");
		text = new TextField();
	
		//  instantiate the HBoxes
		HBox1 = new HBox();
		HBox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
	    dataManager = new DataManager();

		//  set margins and set alignment of the components
	    HBox1.setAlignment(Pos.CENTER);
        HBox2.setAlignment(Pos.CENTER);
     // add spacing between label and text field and between buttons
        HBox1.setSpacing(10); 
        HBox2.setSpacing(10); 
        VBox.setMargin(HBox1, new Insets(10)); // set margin for HBox1
        VBox.setMargin(HBox2, new Insets(10)); // set margin for HBox2
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
        HBox1.getChildren().addAll(label, text);
		
		//  add the buttons to the other HBox
        HBox2.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		
		//  add the HBoxes to this FXMainPanel (a VBox)
        this.getChildren().addAll(HBox1, HBox2);
		
        ButtonHandler handler = new ButtonHandler();
        button1.setOnAction(handler);
        button2.setOnAction(handler);
        button3.setOnAction(handler);
        button4.setOnAction(handler);
        button5.setOnAction(handler);
        button6.setOnAction(handler);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            // Check which button was pressed and perform the corresponding action
            if (event.getTarget() == button1) {
                // "Hello" button was pressed
                text.setText(dataManager.getHello());
            } else if (event.getTarget() == button2) {
                // "Howdy" button was pressed
                text.setText(dataManager.getHowdy());
            } else if (event.getTarget() == button3) {
                // "Chinese" button was pressed
                text.setText(dataManager.getChinese());
            } else if (event.getTarget() == button4) {
            	 // Clear the text field
            	text.setText("");
            } else if (event.getTarget() == button5) {               
            	// "Exit" application
                Platform.exit();
                System.exit(0); 
            } else if (event.getTarget() == button6) {
               // Optional part: "Merhaba" (Turkish) button
                text.setText(dataManager.getTurkish()); // Call the new DataManager method
            }
        }
    }
}