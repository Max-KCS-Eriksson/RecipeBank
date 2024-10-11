package datastorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collection;

/** SerializeDataFileStorage */
public class SerializeDataFileStorage {

    private final File FILE;

    public SerializeDataFileStorage(final File FILE) {
        this.FILE = FILE;
    }

    public <T> void write(Collection<T> objects) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            for (T object : objects) {
                out.writeObject(object);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e); // Fatal error, but reduce boilerplate with unchecked
        }
    }

    public <T> Collection<T> read() {
        return new ArrayList<T>(); // TODO: Implement
    }
}
