package org.example.ListTypesСlasses;

import java.time.LocalDate;

public class YoungestEldestWorkers {
    private WorkerType type;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorkers(WorkerType type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}' + "\n";
    }
}
