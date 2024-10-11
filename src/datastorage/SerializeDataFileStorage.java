package datastorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
                // TODO: this might be the problem
                out.writeObject(object);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e); // Fatal error, but reduce boilerplate with unchecked
        }
    }

    @SuppressWarnings("unchecked")
    public <T> Collection<T> read() {
        Collection<T> objects;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            objects = (Collection<T>) in.readObject();
        } catch (FileNotFoundException e) {
            objects = new ArrayList<>();
        } catch (IOException e) {
            throw new UncheckedIOException(e); // Fatal error, but reduce boilerplate with unchecked
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e); // Fatal error, but reduce boilerplate with unchecked
        }
        return objects;
    }
}
