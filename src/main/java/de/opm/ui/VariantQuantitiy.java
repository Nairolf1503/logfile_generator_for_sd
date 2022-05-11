package de.opm.ui;

import de.opm.template.variants.Variants;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class VariantQuantitiy extends HBox{
    private ComboBox<String> label = new ComboBox<String>();
    private TextField input = new TextField();

    protected VariantQuantitiy(String variant){
        label.getItems().add(variant);
        label.getSelectionModel().selectFirst();
        label.getItems().addAll(Variants.getVariantByKey(variant).getOrderOfExection());
        label.setOnAction((event) -> label.getSelectionModel().selectFirst());
        input.setText("0");
        label.setMinWidth(400);
        label.setMaxWidth(400);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(label, input);
    }

    public String getVariantKey(){
        String variant_key = label.getItems().get(0);
        return variant_key;
    }

    public int getQuantity(){
        String str = input.getText();
        try{
            int quantity = Integer.parseInt(str);
            return quantity;
        }catch(NumberFormatException e){
            System.out.println("No valid quantity was provided for " + label.getItems().get(0));
            return 0;
        }
    }
}
