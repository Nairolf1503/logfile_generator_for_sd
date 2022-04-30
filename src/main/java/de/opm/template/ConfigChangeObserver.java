package de.opm.template;

public interface ConfigChangeObserver {
    public void setConfigPath(String path_to_config);
    public void setActivitiesPath(String path_to_activities);
    public void setVariantsPath(String path_to_variants);
}
