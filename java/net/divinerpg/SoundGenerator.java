package net.divinerpg;

import java.util.ArrayList;

import net.divinerpg.api.Sound;
import net.divinerpg.helper.utils.RegistryFile;

public class SoundGenerator extends RegistryFile {

    private static ArrayList<Sound>   sounds    = new ArrayList<Sound>();
    private final static String       FILE_NAME = "/sounds.json";
    private final static String[]     PATHS     = new String[]
                                                {
                                                "./DivineRPG/resources/assets/divinerpg",
                                                "./resources/assets/divinerpg",
                                                "./main/resources/assets/divinerpg",
                                                "./src/main/resources/assets/divinerpg"
                                                };
    private static final RegistryFile instance  = new SoundGenerator();

    public SoundGenerator() {
        super(FILE_NAME, PATHS);
    }

    public static void addSound(Sound sound) {
        sounds.add(sound);
    }

    public static void registerSounds() {
        instance.addNames();
        instance.closeFile();
    }

    @Override
    public void addNames() {
        addToFile("{");
        for (int i = 0; i < sounds.size(); i++) {
            String name = sounds.get(i).getName();
            boolean mob = sounds.get(i).isMob();
            boolean item = sounds.get(i).isItem();
            if (!item) {
                if (mob) name = name + "Hurt";
                addToFile(" \"" + name + "\": {\n  \"category\":\"master\",\"sounds\": [{\n    \"name\":\n      \"" + name + "\",\n      \"stream\": false\n    }]\n  },");
            } else addToFile(" \"" + name + "\": {\n  \"category\":\"neutral\",\"sounds\": [\"" + name + "\"] },");
        }
        addToFile("}");
    }
}