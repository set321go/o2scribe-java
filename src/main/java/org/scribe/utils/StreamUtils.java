package org.scribe.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Utils to deal with Streams.
 *
 * @author Pablo Fernandez
 */
public final class StreamUtils {

    private static final int BUFFER_SIZE = 0x10000;

    private StreamUtils() { }

  /**
   * Returns the stream contents as an UTF-8 encoded string.
   *
   * @param is input stream
   * @return string contents
   */
  public static String getStreamContents(final InputStream is) {
    Preconditions.checkNotNull(is, "Cannot get String from a null object");
    try {
      final char[] buffer = new char[BUFFER_SIZE];
      StringBuilder out = new StringBuilder();
      Reader in = new InputStreamReader(is, "UTF-8");
      int read;
      do {
        read = in.read(buffer, 0, buffer.length);
        if (read > 0) {
          out.append(buffer, 0, read);
        }
      } while (read >= 0);
      in.close();
      return out.toString();
    } catch (IOException ioe) {
      throw new IllegalStateException("Error while reading response body", ioe);
    }
  }
}
