package dev.fr13.customerdisplay.domain;

import java.time.LocalDateTime;

public class Cashier {
    private String uuid;
    private String name;
    private LocalDateTime startDate;

    {
        startDate = LocalDateTime.now();
    }

    public Cashier() {
    }

    public Cashier(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
