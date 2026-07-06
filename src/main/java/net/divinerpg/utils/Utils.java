package net.divinerpg.utils;

import com.google.gson.Gson;
import net.divinerpg.DivineRPG;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Utils {

    private static final Set<UUID> DEV_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> TESTER_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> SPECIAL_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> ARTIST_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> FRIEND_LIST = ConcurrentHashMap.newKeySet();

    public static boolean isDeveloperName(UUID name) {return DEV_LIST.contains(name);}
    public static boolean isTesterName(UUID name) {return TESTER_LIST.contains(name);}
    public static boolean isSpecial(UUID name) {return SPECIAL_LIST.contains(name);}
    public static boolean isArtist(UUID name) {return ARTIST_LIST.contains(name);}
    public static boolean isFriend(UUID name) {return FRIEND_LIST.contains(name);}

    public static String translate(String langTo, String text) {
        try {
            String urlStr = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=" + langTo + "&dt=t&q=" + URLEncoder.encode(text, StandardCharsets.UTF_8);
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
            String result = response.toString();
            return result.substring(4, result.indexOf("\"", 4));
        } catch (Exception e) {
            return text;
        }
    }

    public static void loadHatInformation() {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://raw.githubusercontent.com/DivineRPG/DivineRPG-Assets/main/hats.json"))
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    if (response.statusCode() == 200) {
                        parseHats(response.body());
                    }
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
    }
    public static class HatsInfo {
        public List<UUID> dev;
        public List<UUID> tester;
        public List<UUID> special;
        public List<UUID> artists;
        public List<UUID> friend;
    }

    private static void parseHats(String json) {
        try {
            HatsInfo info = new Gson().fromJson(json, HatsInfo.class);
            if (info != null) {
                DEV_LIST.clear();
                DEV_LIST.addAll(info.dev);
                TESTER_LIST.clear();
                TESTER_LIST.addAll(info.tester);
                SPECIAL_LIST.clear();
                SPECIAL_LIST.addAll(info.special);
                ARTIST_LIST.clear();
                ARTIST_LIST.addAll(info.artists);
                FRIEND_LIST.clear();
                FRIEND_LIST.addAll(info.friend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ModelLayerLocation createLocation(String name) {return new ModelLayerLocation(Identifier.fromNamespaceAndPath(DivineRPG.MODID, name), "main");}

    public static final ModelLayerLocation
            layerHumanoid = createLocation("humanoid"),
            layerBat = createLocation("bat"),
            layerSpider = createLocation("spider"),
            layerMinecart = createLocation("minecart");
}