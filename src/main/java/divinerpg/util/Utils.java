package divinerpg.util;

import com.google.gson.*;
import com.mojang.util.UUIDTypeAdapter;
import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nullable;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;

public class Utils {
    private static final Set<UUID> DEV_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> TESTER_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> SPECIAL_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> ARTIST_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> FRIEND_LIST = ConcurrentHashMap.newKeySet();

    public static boolean isDeveloperName(UUID name) {
        return DEV_LIST.contains(name);
    }

    public static boolean isTesterName(UUID name) {
        return TESTER_LIST.contains(name);
    }

    public static boolean isSpecial(UUID name) {
        return SPECIAL_LIST.contains(name);
    }

    public static boolean isArtist(UUID name) {
        return ARTIST_LIST.contains(name);
    }

    public static boolean isFriend(UUID name) {
        return FRIEND_LIST.contains(name);
    }

    public static void loadHatInformation() {

        CompletableFuture.supplyAsync(() -> {
            String urlString = "https://raw.githubusercontent.com/DivineRPG/DivineRPG-Assets/main/hats.json";

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
            SPECIAL_LIST.clear();
            ARTIST_LIST.clear();
            FRIEND_LIST.clear();

            if (rawJson != null) {
                try {
                    HatsInfo info = new Gson().fromJson(rawJson, HatsInfo.class);
                    if (info != null) {

                        DEV_LIST.addAll(info.dev);
                        TESTER_LIST.addAll(info.tester);
                        SPECIAL_LIST.addAll(info.special);
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

    public static boolean bordersTar(BlockGetter world, int x, int y, int z) {
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar"))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Spawns a persistent entity at the given location.
     *
     * @param world  the world to spawn the entity in
     * @param pos    the position to spawn the entity at
     * @param entity the entity to spawn
     */
    public static void spawnPersistentEntity(Level world, BlockPos pos, LivingEntity entity) {
        entity.getType().spawn((ServerLevel) world, ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, false, false);
    }

    /**
     * Populates the loot chest below the given position.
     *
     * @param world     the world
     * @param pos       the position above the chest
     * @param rand      the seeded random number generator
     * @param lootTable the loot table to fill it with
     */
    public static void populateLootChestBelow(Level world, BlockPos pos, Random rand, ResourceLocation lootTable) {
        BlockPos chestPosition = pos.below();
        BlockEntity blockEntity = world.getBlockEntity(chestPosition);
        if (blockEntity instanceof RandomizableContainerBlockEntity) {
            ((RandomizableContainerBlockEntity) blockEntity).setLootTable(lootTable, rand.nextLong());
        }
    }
    
    public static void drop(Level level, Vec3 pos, @Nullable ItemStack item) {
		if(item != null) level.addFreshEntity(new ItemEntity(level, pos.x, pos.y, pos.z, item));
	}

    public class HatsInfo {
        public List<UUID> dev;
        public List<UUID> tester;
        public List<UUID> special;
        public List<UUID> artists;
        public List<UUID> friend;
    }
}
