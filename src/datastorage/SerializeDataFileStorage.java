package datastorage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/** SerializeDataFileStorage */
public class SerializeDataFileStorage {

    private final File FILE;

    public SerializeDataFileStorage(final File FILE) {
        this.FILE = FILE;
    }

    public <T> void write(Collection<T> objects) {
        // TODO: Implement
    }

    public <T> Collection<T> read() {
        return new ArrayList<T>(); // TODO: Implement
    }
}
