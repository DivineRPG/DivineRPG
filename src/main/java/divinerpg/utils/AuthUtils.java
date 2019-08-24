package divinerpg.utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
public class AuthUtils {
    /*
        List of all approved testers nicks
     */
    private static List<String> APPROVAL_LIST = new ArrayList<>();
    private DLThread workThread;

    /*
        Starting auth protection
     */
    public static void init(String textfile){
        MinecraftForge.EVENT_BUS.register(new AuthUtils(textfile));
    }

    private AuthUtils(String textfileUrl){
        workThread = new DLThread(textfileUrl);
        workThread.setDaemon(true);
        workThread.start();
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event){
        // Crush only while playing
        if (Minecraft.getMinecraft().world == null
            || Minecraft.getMinecraft().isSingleplayer()){
            return;
        }

        if (!workThread.isFinished()){
            return;
        }

        String playerName = Minecraft.getMinecraft().player.getName();
        if (workThread.isFailed() || !APPROVAL_LIST.contains(playerName)){
            throw new RuntimeException("Dear " + playerName + ", you need to get a Tester rank here:\nhttps://discord.gg/tDudMqm");
        }
    }

    /*
        Nested class
     */

    private class DLThread extends Thread {

        private boolean finished = false;
        private boolean failed = false;
        private String downloadLink;

        DLThread(String downloadLink) {
            super("Special testers check thread");
            this.downloadLink = downloadLink;
        }

        @Override
        public void run() {
            super.run();

            // Try to download 5 times
            for (int i = 0; i < 5; i++){
                tryDownload();

                if (isFinished())
                    break;
            }

            // Force finish status
            finished = true;
        }

        private void tryDownload(){
            try {
                HttpURLConnection con = (HttpURLConnection) new URL(downloadLink).openConnection();
                con.setConnectTimeout(1000);

                InputStream in2 = con.getInputStream();
                List<String> strings = IOUtils.readLines(in2, Charset.defaultCharset());
                AuthUtils.APPROVAL_LIST.addAll(strings);

                in2.close();
                con.disconnect();

                finished = true;
                failed = AuthUtils.APPROVAL_LIST.isEmpty();
            }
            catch (Exception e) {
                failed = true;
                e.printStackTrace();
            }
        }

        boolean isFinished() {
            return finished;
        }

        boolean isFailed() {
            return failed;
        }
    }
}

