package naturix.divinerpg.utils;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;

public class TokenHelper {

    public static String replaceToken(String original, char token, Object replacement) {
        String result = original;
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c == token) {
                logReplacement(token, replacement, i);
                result = result.replaceAll(String.valueOf(token), replacement.toString());
            }
        }
        return result;
    }

    private static void logReplacement(char token, Object replacement, int index) {
        if (Config.debug) {
            DivineRPG.logger.info("Replacing token '" + token + "' at index " + index + "with \"" + replacement + "\"");
        }
    }

}
