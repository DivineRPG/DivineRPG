package net.divinerpg.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class RegistryFile {

    protected String         filePath;
    protected BufferedWriter writer;

    public RegistryFile(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);

        try {
            if (file.exists()) {
                LogHelper.debug("Overriding registry file: " + file.getAbsolutePath());
                file.delete();
            }
            file.createNewFile();
            LogHelper.dev("Creating new registry file: " + file.getAbsoluteFile());
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public abstract void addNames();

    public void localizeName(String prefixOfLine, String unlocalizedName) {
        String name = unlocalizedName.substring(5);
        char firstLetter = name.charAt(0);
        if (Character.isLowerCase(firstLetter))
            firstLetter = Character.toUpperCase(firstLetter);

        String inGame = name.substring(1);
        String temp = inGame;
        for (int p = 1; p < temp.length(); p++) {
            char c = inGame.charAt(p);
            int code = (int) c;

            if (inGame.charAt(p - 1) != ' ') {
                for (int n = 65; n < 90; n++) {
                    if (code == n)
                        inGame = new StringBuffer(inGame).insert(p, " ").toString();
                }
            }
        }
        inGame = inGame.replaceAll(" Of ", " of ").replaceAll(" The ", " the ");
        String finalName = firstLetter + inGame;
        addToFile(prefixOfLine + "." + name + ".name=" + finalName, name);
    }
    
    public void addName(String prefix, String keyName, String inGameName){
        addToFile(prefix + '.' + keyName + '=' + inGameName, keyName);
    }

    public String readFile(String path) {
        StringBuilder source = new StringBuilder();
        BufferedReader reader = null;
        File file = new File(path);
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                source.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source.toString();
    }

    public void addToFile(String inGame, String oldName) {
        /*try {
            String temp = inGame;
            LogHelper.dev("Registered new name, " + oldName + " became: " + temp.substring(temp.indexOf('=') + 1));
            writer.write(inGame + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    
    public void addToFile(String text){
        /*try {
            writer.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void closeFile() {
        /*try {
            writer.close();
            LogHelper.debug("Registry file: " + filePath + " closed");
        } catch (IOException e) {
            e.printStackTrace();
            LogHelper.debug("Unable to close registry file: " + filePath);
        }*/
    }
}
