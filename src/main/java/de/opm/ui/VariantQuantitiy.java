package de.opm.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class VariantQuantitiy extends HBox{
    private Label label;
    private TextField input = new TextField();

    protected VariantQuantitiy(String variant){
        label = new Label(variant);
        input.setText("0");
        label.setMinWidth(200);
        label.setMaxWidth(200);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(label, input);
    }

    public String getVariantKey(){
        String variant_key = label.getText();
        return variant_key;
    }

    public int getQuantity(){
        String str = input.getText();
        try{
            int quantity = Integer.parseInt(str);
            return quantity;
        }catch(NumberFormatException e){
            System.out.println("No valid quantity was provided for " + label.getText());
            return 0;
        }
    }
}
