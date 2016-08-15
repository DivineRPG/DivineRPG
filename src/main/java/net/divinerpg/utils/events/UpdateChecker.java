package net.divinerpg.utils.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LogHelper;

public class UpdateChecker {

    public static boolean isUpdateAvailable() {
        try {
            if (!getCurrentVersion().contains(Reference.MOD_VERSION))
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
                            LogHelper.debug("Internet connection found");
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogHelper.warn("Something is probably wrong with your network configuration. DivineRPG can continue loading but joining worlds will be slightly slower!");
            try {
                URL url = new URL("https://github.com");
                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                Object data = httpConnection.getContent();
            } catch (Exception ex) {
                LogHelper.debug("Internet connection not found");
                return false;
            }
            LogHelper.debug("Internet connection found");
            return true;
        }
        LogHelper.debug("Internet connection not found");
        return false;
    }

    public static String getCurrentVersion() throws IOException {
        BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/DivineRPG/DivineRPG/master/Version.txt").openStream()));
        String curVersion = versionFile.readLine();
        versionFile.close();
        return curVersion;
    }
}
