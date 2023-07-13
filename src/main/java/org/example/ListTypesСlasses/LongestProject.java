package org.example.ListTypesСlasses;

public class LongestProject {
    private String name;
    private int projectDuration;

    public LongestProject (String name, int projectDuration) {
        this.name = name;
        this.projectDuration = projectDuration;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", projectDuration=" + projectDuration +
                '}';
    }
}
