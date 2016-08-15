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
    protected File file;
    protected StringBuilder builder = new StringBuilder();

    public RegistryFile(String filePath) {
        this.filePath = filePath;
        file = new File(filePath);
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
    
    public static String getLocalizedMobName(String str) {
    	int k = str.length();
    	if(str.length() > 1) {
    		for(int i = 1; i < k; i++) {
    			if(Character.isUpperCase(str.charAt(i)) && str.charAt(i-1) != ' ') str = new StringBuffer(str).insert(i, " ").toString();
    		}
    	}
    	str = str.replace("DRPG", "");
    	return str;
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
    	String temp = inGame;
        LogHelper.dev("Registered new name, " + oldName + " became: " + temp.substring(temp.indexOf('=') + 1));
        builder.append(inGame + "\n");
    }
    
    public void addToFile(String text){
    	builder.append(text + "\n");
    }
    
    public void write() {
        try {
            if(!file.exists())file.createNewFile();
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
