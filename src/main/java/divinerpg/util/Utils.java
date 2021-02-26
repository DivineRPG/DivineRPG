package divinerpg.util;

import com.google.gson.*;
import com.mojang.util.*;
import io.netty.util.internal.*;
import org.apache.commons.io.*;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
import java.util.concurrent.*;

public class Utils {
    private static Set<UUID> DEV_LIST = new ConcurrentSet<>();
    private static Set<UUID> TESTER_LIST = new ConcurrentSet<>();
    private static Set<UUID> PATRON_LIST = new ConcurrentSet<>();
    private static Set<UUID> ARTIST_LIST = new ConcurrentSet<>();
    private static Set<UUID> FRIEND_LIST = new ConcurrentSet<>();

    public static boolean isDeveloperName(UUID name) {
        return DEV_LIST.contains(name);
    }

    public static boolean isTesterName(UUID name) {
        return TESTER_LIST.contains(name);
    }

    public static boolean isPatreon(UUID name) {
        return PATRON_LIST.contains(name);
    }

    public static boolean isArtist(UUID name) {
        return ARTIST_LIST.contains(name);
    }

    public static boolean isFriend(UUID name) {
        return FRIEND_LIST.contains(name);
    }
    public static void loadHatInformation() {

        CompletableFuture.supplyAsync(() -> {
            String urlString = "https://raw.githubusercontent.com/DivineRPG/DivineRPG/1.16x/hat_lists/hats.json";

            try {
                HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
                con.setConnectTimeout(1000);
                InputStream in2 = con.getInputStream();
                List<String> lines = IOUtils.readLines(in2, Charset.defaultCharset());

                return String.join("\n", lines);

            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }).thenApply(rawJson -> {
            DEV_LIST.clear();
            TESTER_LIST.clear();
            PATRON_LIST.clear();
            ARTIST_LIST.clear();
            FRIEND_LIST.clear();

            if (rawJson != null) {
                try {
                    HatsInfo info = new Gson().fromJson(rawJson, HatsInfo.class);
                    if (info != null) {

                        DEV_LIST.addAll(info.dev);
                        TESTER_LIST.addAll(info.tester);
                        PATRON_LIST.addAll(info.patreon);
                        ARTIST_LIST.addAll(info.artists);
                        FRIEND_LIST.addAll(info.friend);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return rawJson;
        });
    }


    public static CompletableFuture<UUID> getLicenceId(String nick) {
        return CompletableFuture.supplyAsync(() -> {
            String url = "https://api.mojang.com/users/profiles/minecraft/" + nick;
            UUID result = new UUID(0, 0);

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                InputStream stream = connection.getInputStream();
                String json = IOUtils.toString(stream, Charset.defaultCharset());
                JsonObject object = new Gson().fromJson(json, JsonObject.class);

                if (!object.has("error")) {
                    result = UUIDTypeAdapter.fromString(object.get("id").getAsString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        });
    }


    public class HatsInfo {
        public List<UUID> dev;
        public List<UUID> tester;
        public List<UUID> patreon;
        public List<UUID> artists;
        public List<UUID> friend;
    }
}
