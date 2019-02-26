package naturix.divinerpg.events;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.Reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


public class UpdateChecker {

    public static boolean isUpdateAvailable() {
        try {
            if (!getCurrentVersion().contains(Reference.VERSION))
                return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean isOnline() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface interf = interfaces.nextElement();
                if (interf.isUp() && !interf.isLoopback()) {
                    List<InterfaceAddress> adrs = interf.getInterfaceAddresses();
                    for (Iterator<InterfaceAddress> iter = adrs.iterator(); iter.hasNext();) {
                        InterfaceAddress adr = iter.next();
                        InetAddress inadr = adr.getAddress();
                        if (inadr instanceof Inet4Address) {
                            DivineRPG.logger.debug("Internet connection found");
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
        	DivineRPG.logger.warn("Something is probably wrong with your network configuration. DivineRPG can continue loading but joining worlds will be slightly slower!");
            try {
                URL url = new URL("https://github.com");
                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                Object data = httpConnection.getContent();
            } catch (Exception ex) {
            	DivineRPG.logger.debug("Internet connection not found");
                return false;
            }
            DivineRPG.logger.debug("Internet connection found");
            return true;
        }
        DivineRPG.logger.debug("Internet connection not found");
        return false;
    }

    public static String getCurrentVersion() throws IOException {
        BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/version.txt").openStream()));
        String curVersion = versionFile.readLine();
        versionFile.close();
        return curVersion;
    }
}