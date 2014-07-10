package net.divinerpg.utils;

import java.util.ArrayList;

import net.divinerpg.api.Sound;

public class SoundGenerator extends RegistryFile {

    private static ArrayList<Sound>   sounds    = new ArrayList<Sound>();
    private static final RegistryFile instance  = new SoundGenerator();

    public SoundGenerator() {
        super("./src/main/resources/assets/divinerpg/sounds.json");
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