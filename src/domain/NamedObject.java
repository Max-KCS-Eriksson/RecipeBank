package domain;

import java.io.Serializable;

/** NamedObject */
public abstract class NamedObject implements Serializable {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            String[] classPath = getClass().toString().split("\\.");
            throw new IllegalArgumentException(
                    classPath[classPath.length - 1] + " name cannot be empty");
        }
        this.name = name.toLowerCase();
    }

    @Override
    public String toString() {
        return name;
    }
}
