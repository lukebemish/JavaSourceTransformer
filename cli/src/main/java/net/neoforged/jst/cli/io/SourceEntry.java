package net.neoforged.jst.cli.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public interface SourceEntry {
    /**
     * @return True for directories.
     */
    boolean directory();

    /**
     * Path to the file or directory. Uses forward slashes as path-separators, and does not have a leading slash.
     */
    String relativePath();

    /**
     * @return Millis since epoch denoting when the file was last modified. 0 for directories.
     */
    long lastModified();

    /**
     * @return An input stream to read this content.
     */
    InputStream openInputStream() throws IOException;

    default boolean hasExtension(String extension) {
        return relativePath().toLowerCase(Locale.ROOT).endsWith("." + extension.toLowerCase(Locale.ROOT));
    }
}
