package divinerpg.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.util.UUIDTypeAdapter;
import divinerpg.registry.ModBlocks;
import io.netty.util.internal.ConcurrentSet;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Utils {
    public static int mobID = 500, projectileID = 0, entityListID = 2500;

    public static DamageSource trapSource = new DamageSource("trap");
    public static DamageSource acidSource = new DamageSource("acid");
    public static DamageSource spikeSource = new DamageSource("spike");
    public static DamageSource arcanaSource = new DamageSource("arcana");

    private static String str;

    private static Object args;
    public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73",
            DARK_RED = "\u00a74";
    public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78",
            BLUE = "\u00a79";
    public static String GREEN = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d",
            YELLOW = "\u00a7e";
    public static String WHITE = "\u00a7f";

    private static Set<UUID> DEV_LIST = new ConcurrentSet<>();
    private static Set<UUID> TESTER_LIST = new ConcurrentSet<>();
    private static Set<UUID> PATRON_LIST = new ConcurrentSet<>();
    private static Set<UUID> ARTIST_LIST = new ConcurrentSet<>();

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

    /**
     * Loads hat information
     *
     * @return
     */
    public static void loadHatInformation() {

        CompletableFuture.supplyAsync(() -> {
            String urlString = "https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/hat_lists/hats.json";

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

            if (rawJson != null) {
                try {
                    HatsInfo info = new Gson().fromJson(rawJson, HatsInfo.class);
                    if (info != null) {

                        DEV_LIST.addAll(info.getDevs());
                        TESTER_LIST.addAll(info.getTesters());
                        PATRON_LIST.addAll(info.getPatreons());
                        ARTIST_LIST.addAll(info.getArtists());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return rawJson;
        });
    }

    /**
     * Performs API request to detect UUID of nick
     *
     * @param nick
     * @return
     */
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

    public static ITextComponent getChatComponent(String str) {
        TextComponentString ret = new TextComponentString(str);
        return ret;
    }

    public static ITextComponent getChatComponent(String str, String args) {
        TextComponentString ret = new TextComponentString(args + str);
        ret.getStyle().setColor(TextFormatting.WHITE);
        return ret;
    }

    public static DamageSource causeArcanaDamage(Entity projectile, Entity shooter) {
        return new EntityDamageSourceIndirect("arrow", projectile, shooter).setMagicDamage();
    }

    public static boolean bordersTar(World world, int x, int y, int z) {
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == ModBlocks.tar) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean bordersTar(World w, BlockPos pos) {
        return bordersTar(w, pos.getX(), pos.getY(), pos.getZ());
    }

    public static ITextComponent addChatMessage(ITextComponent displayName) {
        TextComponentString ret = new TextComponentString(args + str);
        ret.getStyle().setColor(TextFormatting.WHITE);
        return ret;
    }

    public static TextComponentString addChatMessage(String str, Object... args) {
        TextComponentString ret = new TextComponentString(args + str);
        ret.getStyle().setColor(TextFormatting.WHITE);
        return ret;
    }

    public static ToolMaterial addHammerMaterial(float damage) {
        return EnumHelper.addToolMaterial("sword", 0, -1, 0, damage - 4, 22);
    }

    public class HatsInfo {
        public List<Map<UUID, String>> dev;
        public List<Map<UUID, String>> tester;
        public List<Map<UUID, String>> patreon;
        public List<Map<UUID, String>> artists;

        private Set<UUID> getSet(List<Map<UUID, String>> list) {
            if (list == null || list.isEmpty())
                return new HashSet<>();

            return list.stream().map(Map::keySet).flatMap(Collection::stream).collect(Collectors.toSet());
        }

        public Set<UUID> getDevs() {
            return getSet(dev);
        }

        public Set<UUID> getTesters() {
            return getSet(tester);
        }

        public Set<UUID> getPatreons() {
            return getSet(patreon);
        }

        public Set<UUID> getArtists() {
            return getSet(artists);
        }
    }
}