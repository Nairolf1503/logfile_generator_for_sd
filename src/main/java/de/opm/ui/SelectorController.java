package de.opm.ui;

import java.io.File;
import java.io.IOException;

import de.opm.template.ConfigChangeObserver;
import de.opm.template.Template;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class SelectorController implements ConfigChangeObserver{

    @FXML
    private void switchToGenerator() throws IOException {
        App.setRoot("generator");
    }

    @FXML
    private void selectConfigFile(){
        File file = chooseFile("Choose your Config.json");
        if(file != null){
            Template.loadParamsFromFile(file);
        }
    }

    @FXML
    private void selectActivitiesFile(){
        File file = chooseFile("Choose your Activities.json");
        if(file != null){
            Template.loadActivitiesFromFile(file);
        }
    }

    @FXML
    private void selectVariantsFile(){
        File file = chooseFile("Choose your Variants.json");
        if(file != null){
            Template.loadVariantsFromFile(file);

        }
    }

    @FXML 
    private Label configFilePath;

    @Override
    public void setConfigPath(String path_to_config) {
        configFilePath.setText(path_to_config);
    }

    @FXML 
    private Label activitiesFilePath;

    @Override
    public void setActivitiesPath(String path_to_activities) {
        activitiesFilePath.setText(path_to_activities);
    }

    @FXML
    private Label variantsFilePath;

    @Override
    public void setVariantsPath(String path_to_variants) {
        variantsFilePath.setText(path_to_variants);      
    }

    private File chooseFile(String title){
        FileChooser fileChooser = new FileChooser();
        File default_dir = new File("./");
        fileChooser.setInitialDirectory(default_dir);
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().add(new ExtensionFilter("JSON", "*.json"));
        File file = fileChooser.showOpenDialog(new Stage());
        return file;
    }
}
