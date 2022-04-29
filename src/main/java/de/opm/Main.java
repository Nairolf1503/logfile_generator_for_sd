package de.opm;

import java.io.File;

import de.opm.template.Template;
import de.opm.ui.App;

public class Main {
    public static void main(String[] args) {
        Template.loadParamsFromFile(new File("./config.json"));
        Template.loadActivitiesFromFile(new File("./activities.json"));
        Template.loadVariantsFromFile(new File("./variants.json"));
        App.main(args);
    }
}
