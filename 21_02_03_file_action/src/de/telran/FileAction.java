package de.telran;

import java.io.IOException;
import java.util.List;

public abstract class FileAction {

    final FileOperations fileOperations;

    protected FileAction(FileOperations fileOperations){
        this.fileOperations = fileOperations;
    }

    protected abstract List<String> perform(List<String> text);

    /**
     * The method receives a fileName and must read the file into a @{@link List} of Strings, calls the 'perform'
     * method, then writes the result back to the file
     *
     * @param fileName name of the file to handle
     */
    public void handleFile(String fileName) throws IOException {
        List<String> text = fileOperations.readToList(fileName);
        List<String> performedText = perform(text);
        fileOperations.writeList(performedText, fileName);
    }
}
