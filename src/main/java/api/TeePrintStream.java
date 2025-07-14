package api;

import java.io.OutputStream;
import java.io.PrintStream;

class TeePrintStream extends PrintStream {
    private final PrintStream second;

    public TeePrintStream(OutputStream main, PrintStream second) {
        super(main, true);
        this.second = second;
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        second.write(buf, off, len);
        second.flush();
    }

    @Override
    public void flush() {
        super.flush();
        second.flush();
    }
}
