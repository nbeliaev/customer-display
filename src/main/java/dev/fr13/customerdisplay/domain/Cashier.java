package dev.fr13.customerdisplay.domain;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Cashier {
    private String uuid;
    private String description;
    private String computerName;
    private LocalDateTime startDate;
    private List<String> images;

    {
        startDate = LocalDateTime.now();
    }

    public Cashier() {
    }

    public Cashier(String uuid, String description, String computerName) {
        this.uuid = uuid;
        this.description = description;
        this.computerName = computerName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public List<String> getImages() {
        return Collections.unmodifiableList(images);
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void addImageName(String name) {
        images.add(name);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "uuid='" + uuid + '\'' +
                ", name='" + description + '\'' +
                ", computerName='" + computerName + '\'' +
                '}';
    }
}
