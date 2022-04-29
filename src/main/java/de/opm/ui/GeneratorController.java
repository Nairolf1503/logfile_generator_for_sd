package de.opm.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.opm.dataset.Dataset;
import de.opm.template.variants.Variants;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class GeneratorController {

    @FXML
    private void switchToSelector() throws IOException {
        App.setRoot("selector");
    }

    @FXML
    private void generateLogfile() throws IOException{
        ObservableList<Node> inputs_list = variants.getChildren();
        List<VariantQuantitiy> quant_list = new ArrayList<VariantQuantitiy>();
        for(Node node : inputs_list){
            if(node instanceof VariantQuantitiy){
                VariantQuantitiy quant = (VariantQuantitiy) node;
                quant_list.add(quant);
            }
        }

        VariantQuantitiy[] inputs = quant_list.toArray(new VariantQuantitiy[quant_list.size()]);

        Dataset.buildDataset(inputs);
    }

    @FXML
    private VBox variants;

    public void initialize() {
        variants.getChildren().clear();

        String[] variant_keys = Variants.getVariantKeys();
        for(String variant : variant_keys){
            VariantQuantitiy quantitiy = new VariantQuantitiy(variant);
            variants.getChildren().add(quantitiy);
        }
    }
}