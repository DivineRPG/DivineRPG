package divinerpg.util;

import com.google.gson.*;
import com.mojang.authlib.GameProfile;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineNeutral;
import divinerpg.registries.*;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.*;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.world.Container;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nullable;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;

public class Utils {
	public static volatile byte ICEIKA_WEATHER = (byte) (Math.random() * 4);//0 = snow, 1 = hail, 2 = blizzard, 3 = fog
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
                @SuppressWarnings("deprecation")
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

    public static boolean bordersTar(BlockGetter world, int x, int y, int z) {
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == FluidRegistry.SMOLDERING_TAR_BLOCK.get()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void drop(Level level, Vec3 pos, @Nullable ItemStack item) {
		if(item != null) level.addFreshEntity(new ItemEntity(level, pos.x, pos.y, pos.z, item));
	}

    public static class HatsInfo {
        public List<UUID> dev;
        public List<UUID> tester;
        public List<UUID> special;
        public List<UUID> artists;
        public List<UUID> friend;
    }
    public static byte determineTimeOfDay(Level level) {
        if(level.dimension() == LevelRegistry.EDEN) return 5;//guaranteed return to overworld
        if(level.dimension() == LevelRegistry.WILDWOOD) return 0;//guaranteed return to eden
        if(level.dimension() == LevelRegistry.APALACHIA) return 1;//guaranteed return to wildwood
        if(level.dimension() == LevelRegistry.SKYTHERN) return 2;//guaranteed return to apalachia
        if(level.dimension() == LevelRegistry.MORTUM) return 5;//guaranteed return to skythern
        float timeOfDay = level.getTimeOfDay(1F);
        return
            timeOfDay < .0625F ? 0 : //noon
            timeOfDay < .14F ? (byte)1 : //afternoon
            timeOfDay < .25 ? (byte)2 : //evening
            timeOfDay < .37 ? (byte)3 : //night
            timeOfDay < .6 ? (byte)4 : //midnight
            timeOfDay < .9 ? (byte)5 : //morning
            0;
    }
    public static Block getBlock(String registryName) {
    	return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, registryName));
    }
    public static BlockState getBlockState(String registryName) {
    	return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, registryName)).defaultBlockState();
    }
    public static boolean hasEnchantment(ItemStack stack, RegistryLookup<Enchantment> registry, ResourceKey<Enchantment> enchantment) {
    	return stack.getEnchantmentLevel(registry.getOrThrow(enchantment)) != 0;
    }
    public static boolean isPotion(ItemStack stack, Holder<Potion> potion) {
    	return (stack.is(Items.POTION) || stack.is(Items.SPLASH_POTION) || stack.is(Items.LINGERING_POTION)) && stack.get(DataComponents.POTION_CONTENTS).is(potion);
    }
    public static BlockPos getNearbySpawnPos(ServerLevel level, RandomSource random, BlockPos position) {
		int x = position.getX() + random.nextInt(16) - 8, z = position.getZ() + random.nextInt(16) - 8, y = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 64, 250, 1, level, random, x, z);
		MutableBlockPos pos = new MutableBlockPos(x, y, z);
		BlockState state;
		while((state = level.getBlockState(pos)).is(BlockTags.LEAVES) || state.is(BlockTags.SNOW)) pos.move(Direction.DOWN);
        do pos.move(Direction.UP);
        while(level.getBlockState(pos).is(BlockTags.SNOW));
		return pos;
	}
	public static BlockPos adjustHeight(ServerLevel level, MutableBlockPos pos) {
		while(!level.getBlockState(pos).isAir()) pos.move(Direction.UP);
		while(level.getBlockState(pos).isAir()) pos.move(Direction.DOWN);
		return pos.move(Direction.UP);
	}
	public static float rotlerp(float rot, float g, float bound) {
        float f = Mth.wrapDegrees(g - rot);
        if(f > bound) f = bound;
        if(f < -bound) f = -bound;
        float f1 = rot + f;
        if(f1 < 0F) f1 += 360F;
        else if(f1 > 360F) f1 -= 360F;
        return f1;
    }

    public static void awardAdvancement(MinecraftServer server, ServerPlayer player, ResourceLocation advancement, String criterion) {
        var adv = server.getAdvancements().get(advancement);
        if(adv != null) {
            var progress = player.getAdvancements().getOrStartProgress(adv);
            if(!progress.isDone()) progress.getRemainingCriteria().forEach((c) -> {
                if(c.equals(criterion)) player.getAdvancements().award(adv, c);
            });
        }
    }
    public static List<ServerPlayer> getNearbyPlayers(ServerLevel level, double x, double y, double z, double boxSize) {
        return level.getPlayers((p) -> Math.abs(p.getX() - x) <= boxSize && Math.abs(p.getY() - y) <= boxSize && Math.abs(p.getZ() - z) <= boxSize);
    }

    /**
     * use this if you do not have level registry access
     */
    public static int getEnchantmentLevel(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return entry.getIntValue();
        return 0;
    }
    /**
     * use this if you do not have level registry access
     */
    public static int getStoredEnchantmentLevel(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return entry.getIntValue();
        return 0;
    }
    /**
     * use this if you do not have level registry access
     */
    public static boolean hasEnchantment(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return true;
        return false;
    }
    /**
     * use this if you do not have level registry access
     */
    public static boolean hasStoredEnchantment(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return true;
        return false;
    }

    public static final Container EMPTY_CONTAINER = new Container() {
        @Override public void clearContent() {}
        @Override public int getContainerSize() {return 1;}
        @Override public boolean isEmpty() {return true;}
        @Override public ItemStack getItem(int i) {return ItemStack.EMPTY;}
        @Override public ItemStack removeItem(int i, int i1) {return ItemStack.EMPTY;}
        @Override public ItemStack removeItemNoUpdate(int i) {return ItemStack.EMPTY;}
        @Override public void setItem(int i, ItemStack itemStack) {}
        @Override public void setChanged() {}
        @Override public boolean stillValid(Player player) {return true;}
    };
    public static final GameProfile FAKE_PLAYER = new GameProfile(UUID.randomUUID(), "drpgfakeplayer");

    public static void summonEntityAt(ServerLevel level, EntityType<?> type, BlockPos pos, @Nullable Player player) {
        int y = Surface.getSurface(Surface_Type.LOWEST_GROUND, Surface.Mode.FULL, pos.getY() - 4, pos.getY() + 5, 0, level, level.getRandom(), pos.getX(), pos.getZ());
        pos = new BlockPos(pos.getX(), y, pos.getZ());
        if(level.getBlockStates(type.getSpawnAABB(pos.getX() + .5, pos.getY() + .14, pos.getZ() + .5)).allMatch(BlockBehaviour.BlockStateBase::isAir))
            type.spawn(level, (e) -> {
                if(player != null) {
                    if(e instanceof EntityDivineNeutral n) n.setPersistentAngerTarget(player.getUUID());
                    else if(e instanceof Mob l) l.setTarget(player);
                }
            }, pos, MobSpawnType.TRIGGERED, true, false);
    }
}