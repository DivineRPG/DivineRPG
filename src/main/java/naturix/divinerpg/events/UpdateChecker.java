package naturix.divinerpg.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;


public class UpdateChecker {

    public static boolean pingGoogle() {
        try {
            return InetAddress.getByName("google.com").isReachable(500);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static String getCurrentVersion() {
        try {
            BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/version.txt").openStream()));
            String curVersion = versionFile.readLine();
            versionFile.close();
            return curVersion;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}