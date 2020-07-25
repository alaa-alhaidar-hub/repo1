package shopPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RechnungPrint {

    public void createFile() throws IOException {
        File file = new File ( "c://temp//testFile1.txt" );
        FileWriter writer = new FileWriter ( file );
    }
}
