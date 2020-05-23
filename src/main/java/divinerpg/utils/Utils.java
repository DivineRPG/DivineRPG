package divinerpg.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.util.UUIDTypeAdapter;
import divinerpg.registry.BlockRegistry;
import io.netty.util.internal.ConcurrentSet;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Utils {
    public static int mobID = 500, projectileID = 0, entityListID = 2500;

    public static DamageSource trapSource = new DamageSource("trap");
    public static DamageSource acidSource = new DamageSource("acid");
    public static DamageSource spikeSource = new DamageSource("spike");
    public static DamageSource arcanaSource = new DamageSource("arcana");

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

                        DEV_LIST.addAll(info.dev);
                        TESTER_LIST.addAll(info.tester);
                        PATRON_LIST.addAll(info.patreon);
                        ARTIST_LIST.addAll(info.artists);
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

    public static DamageSource causeArcanaDamage(Entity projectile, Entity shooter) {
        return new EntityDamageSourceIndirect("arrow", projectile, shooter).setMagicDamage();
    }

    public static boolean bordersTar(World world, int x, int y, int z) {
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == BlockRegistry.tar) {
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

    public static int getSurfaceBlockY(World world, int x, int z) {
        int y = world.getChunkFromBlockCoords(new BlockPos(x, 0, z)).getTopFilledSegment() + 16;

        BlockPos pos;
        IBlockState state;
        Block block;
        do {
            --y;
            if (y < 0) {
                break;
            }

            pos = new BlockPos(x, y, z);
            state = world.getBlockState(pos);
            block = state.getBlock();

        } while (block.isAir(state, world, pos)
                || block.isReplaceable(world, pos)
                || block.isWood(world, pos)
                || block.isFoliage(world, pos)
                // personally hate plants
                || state.getMaterial() == Material.PLANTS
                || block.isLeaves(state, world, pos)
                || block.canBeReplacedByLeaves(state, world, pos));

        return y;
    }

    public class HatsInfo {
        public List<UUID> dev;
        public List<UUID> tester;
        public List<UUID> patreon;
        public List<UUID> artists;
    }
}