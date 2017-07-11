package by.kooks.infoHandling.reader;


import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestInformationReader {
    private File tempFile;
    private FileWriter fileWriter;
    private String expected;

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void initData() {
        try {
            expected = "It is a (0-5+1/2*(2+5*2-(--j)))*1200 established fact that a reader\n" +
                    "It is a long established fact that a reader will be distracted main.by the readable\n";
            tempFile = temporaryFolder.newFile("tempFile.txt");
            fileWriter = new FileWriter(tempFile);
            fileWriter.write(expected);
            fileWriter.flush();
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @After
    public void removeTempFile() {
        expected = null;
        tempFile = null;
        fileWriter = null;
        temporaryFolder.delete();
    }

    @Test
    public void readFileTest() {
        String actual = InformationReader.readFile(tempFile.getPath());
        Assert.assertEquals(expected, actual);
    }
}
