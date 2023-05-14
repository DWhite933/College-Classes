package chapter21;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 21.5
File: convert2HTML.java
Description:
Write a program that converts a Java file into an HTML file. In the HTML file, the keywords, comments, and literals are
displayed in bold navy, green and blue respectively. Use the command line to pass a java file and an HTML file.

 */


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class convert2HTML {

    public static void main(String[] args) {

        // check for user input error
        if (args.length != 2){
            System.out.println("Usage: java convert2HTML filename.java filename.html ");
            System.exit(1);
        }

        // create files
        File javaSource = new File(args[0]);
        File htmlFile = new File(args[1]);

        // check if java file exists
        if (!javaSource.exists()){
            System.out.println(javaSource.getName() + " does not exist");
            System.exit(2);
        }
        // check for java file
        else if (!javaSource.getName().endsWith(".java")){
            System.out.println(javaSource.getName() + " is not a Java file");
            System.exit(3);
        }
        // check for html file
        else if (!htmlFile.getName().endsWith(".html")){
            System.out.println(htmlFile.getName() + " is not an HTML file");
            System.exit(4);
        }

        // create HTML file
        try {
            generateHTML(javaSource, htmlFile);
        } catch (Exception e){
            System.out.println("Something went wrong");
        }

    }

    /**
     * @param javaSource java source file
     * @param htmlFile html destination file
     */
    public static void generateHTML(
            File javaSource, File htmlFile) throws IOException {
        String[] keywordString = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                "class", "const", "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto", "if",
                "implements", "import", "instanceof", "int", "interface", "long",
                "native", "new", "package", "private", "protected", "public", "return",
                "short", "static", "strictfp", "super", "switch", "synchronized",
                "this", "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"
        };

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n<html>\n<head>");
        html.append("<title>").append(htmlFile.getName()).append("</title>\n</head>\n");
        html.append("<body>\n<pre>\n");

        Scanner input = new Scanner(javaSource);

        while (input.hasNext()) {
            String line = input.nextLine() + "\n";
            if (line.startsWith("//")) {
                html.append("<span style=\"color:green\">").append(line).append("</span>\n");
            } else {
                StringBuilder word = new StringBuilder();
                boolean openQuote = true;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '\"') {
                        if (openQuote) {
                            word.append("<span style=\"color:navy;font-weight:bold\">").append(c);
                            openQuote = false;
                        } else {
                            word.append(c).append("</span>");
                            openQuote = true;
                        }
                    } else if (c == ' ' || c == '\n') {
                        if (keywordSet.contains(word.toString())) {
                            html.append("<span style=\"color:blue\"").append(word).append("</span> ");
                        } else {
                            html.append(word).append(" ");
                        }
                        word = new StringBuilder();
                    } else {
                        word.append(c);
                    }
                }
                html.append("\n");
            }
        }

        input.close();

        html.append("</pre>\n</body>\n</html>");

        PrintWriter output = new PrintWriter(htmlFile);
        output.print(html);
        output.close();
    }

}
