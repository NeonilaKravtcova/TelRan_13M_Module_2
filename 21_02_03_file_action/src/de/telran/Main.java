package de.telran;

import de.telran.action.CapitalLettersFileAction;
import de.telran.action.ReplaceFileAction;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileOperations fileOperations = new FileOperations();
        CapitalLettersFileAction capitalLettersFileAction = new CapitalLettersFileAction(fileOperations);
        capitalLettersFileAction.handleFile("text.txt");

        ReplaceFileAction replaceFileAction = new ReplaceFileAction(fileOperations, "find", "check");
        replaceFileAction.handleFile("text2.txt");

    }
}
