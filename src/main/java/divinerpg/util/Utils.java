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
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.*;
import net.minecraft.world.Container;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nullable;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;

public class Utils {
	public static volatile byte ICEIKA_WEATHER = (byte)(Math.random() * 4);//0 = snow, 1 = hail, 2 = blizzard, 3 = fog
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
    public static final ResourceLocation ADVANCEMENT_OOPS = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/oops");
    public static void loadHatInformation() {
        CompletableFuture.supplyAsync(() -> {
            String urlString = "https://raw.githubusercontent.com/DivineRPG/DivineRPG-Assets/main/hats.json";
            try {
				HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
                con.setConnectTimeout(1000);
                InputStream in2 = con.getInputStream();
                List<String> lines = IOUtils.readLines(in2, Charset.defaultCharset());
                return String.join("\n", lines);
            } catch(Exception e) {
                e.printStackTrace();
                return "";
            }
        }).thenApply(rawJson -> {
            DEV_LIST.clear();
            TESTER_LIST.clear();
            SPECIAL_LIST.clear();
            ARTIST_LIST.clear();
            FRIEND_LIST.clear();
            try {
                HatsInfo info = new Gson().fromJson(rawJson, HatsInfo.class);
                if(info != null) {
                    DEV_LIST.addAll(info.dev);
                    TESTER_LIST.addAll(info.tester);
                    SPECIAL_LIST.addAll(info.special);
                    ARTIST_LIST.addAll(info.artists);
                    FRIEND_LIST.addAll(info.friend);
                }
            } catch(Exception e) {
                e.printStackTrace();
            } return rawJson;
        });
    }
    public static boolean bordersTar(BlockGetter world, int x, int y, int z) {
        for(int i = x - 4; i <= x + 4; ++i) {
            for(int j = y; j <= y + 1; ++j) {
                for(int k = z - 4; k <= z + 4; ++k) {
                    if(world.getBlockState(new BlockPos(i, j, k)).getBlock() == FluidRegistry.SMOLDERING_TAR_BLOCK.get()) return true;
                }
            }
        } return false;
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
    public static byte getTimeOfDay(Level level, ItemStack stack) {
        return stack.is(ItemRegistry.frozen_clock) ? stack.get(DataComponentRegistry.variant) : Utils.determineTimeOfDay(level);
    }
    public static boolean clockUse(Level level, ItemStack stack, BlockPos pos, BlockState state, List<? extends Player> players, Direction face) {
        Block portal = null, rift = null;
        switch(Utils.getTimeOfDay(level, stack)) {
            case 0: if(state.is(BlockRegistry.edenBlock)) portal = BlockRegistry.edenPortal.get(); else if(state.is(BlockRegistry.divineFlame)) rift = BlockRegistry.edenRift.get(); break;
            case 1: if(state.is(BlockRegistry.wildwoodBlock)) portal = BlockRegistry.wildwoodPortal.get(); else if(state.is(BlockRegistry.wildFlame)) rift = BlockRegistry.wildwoodRift.get(); break;
            case 2: if(state.is(BlockRegistry.apalachiaBlock)) portal = BlockRegistry.apalachiaPortal.get(); else if(state.is(BlockRegistry.enchantedFlame)) rift = BlockRegistry.apalachiaRift.get(); break;
            case 3: if(state.is(BlockRegistry.skythernBlock)) portal = BlockRegistry.skythernPortal.get(); else if(state.is(BlockRegistry.skyFire)) rift = BlockRegistry.skythernRift.get(); break;
            case 4: if(state.is(BlockRegistry.mortumBlock)) portal = BlockRegistry.mortumPortal.get(); else if(state.is(BlockRegistry.mortumEmbers)) rift = BlockRegistry.mortumRift.get(); break;
            case 5: if(state.is(BlockRegistry.divineRock)) portal = BlockRegistry.divinePortal.get(); else if(state.is(Blocks.FIRE)) rift = BlockRegistry.overworldRift.get(); break;
        } if(portal != null) {
            BlockPos facing = face == null ? pos.above() : pos.relative(face);
            Direction.Axis axis = Utils.checkForFrame(level, facing, new BlockMatchTest(state.getBlock()));
            if(axis != null) {
                if(!level.isClientSide) Utils.spreadBlock(level, portal.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), facing, Blocks.AIR, axis);
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, level.random.nextFloat() * .4F + .8F);
                level.playSound(null, pos, SoundRegistry.PORTAL_CREATION.get(), SoundSource.BLOCKS, 1, 1F);
                return true;
            }
        } else if(rift != null && !level.getBlockState(pos.above()).is(rift)) {
            level.setBlock(pos.above(), rift.defaultBlockState(), 3);
            return true;
        } else if(state.is(BlockTags.FIRE) && !state.is(Blocks.FIRE)) {
            level.explode(players.getFirst(), pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 3, true, Level.ExplosionInteraction.BLOCK);
            if(level instanceof ServerLevel s) for(Player player : players) Utils.awardAdvancement(s.getServer(), (ServerPlayer) player, ADVANCEMENT_OOPS, "explode_rift");
            return true;
        } return false;
    }
    public static byte determineTimeOfDay(Level level) {
        if(level.dimension() == LevelRegistry.EDEN) return 0;//guaranteed return to overworld
        if(level.dimension() == LevelRegistry.WILDWOOD) return 1;//guaranteed return to eden
        if(level.dimension() == LevelRegistry.APALACHIA) return 2;//guaranteed return to wildwood
        if(level.dimension() == LevelRegistry.SKYTHERN) return 3;//guaranteed return to apalachia
        if(level.dimension() == LevelRegistry.MORTUM) return 4;//guaranteed return to skythern
        float timeOfDay = level.getTimeOfDay(1F);
        return
            timeOfDay < .0625F ? 0 : //noon
            timeOfDay < .14F ? (byte)1 : //afternoon
            timeOfDay < .25 ? (byte)2 : //evening
            timeOfDay < .37 ? (byte)3 : //night
            timeOfDay < .6 ? (byte)4 : //midnight
            timeOfDay < .9 ? (byte)5 : //morning
            0; //noon
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
     * Use this if you do not have level registry access
     */
    public static int getEnchantmentLevel(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return entry.getIntValue();
        return 0;
    }
    /**
     * Use this if you do not have level registry access
     */
    public static int getStoredEnchantmentLevel(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return entry.getIntValue();
        return 0;
    }
    /**
     * Use this if you do not have level registry access
     */
    public static boolean hasEnchantment(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return true;
        return false;
    }
    /**
     * Use this if you do not have level registry access
     */
    public static boolean hasStoredEnchantment(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return true;
        return false;
    }
    /**
     * Use this if you do not have level registry access
     */
    public static boolean hasStoredTag(TagKey<Enchantment> enchantment, ItemStack stack) {
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
    public static Direction.Axis checkForFrame(Level level, BlockPos pos, RuleTest frame) {
        Direction d = null;
        for(Direction di : Direction.values()) if(frame.test(level.getBlockState(pos.relative(di)), level.random)) {
            d = di;
            break;
        } if(d == null) return null;
        return travel(level, pos, Direction.Axis.X, frame) ? Direction.Axis.X : (travel(level, pos, Direction.Axis.Z, frame) ? Direction.Axis.Z : null);
    }
    protected static boolean travel(Level level, BlockPos pos, Direction.Axis axis, RuleTest frame) {
        Direction d = lookForFrameBlock(level, pos, axis, frame), dir = d;
        if(d == null) return false;
        BlockState state;
        BlockPos.MutableBlockPos mut = pos.mutable();
        while((dir = dir.getClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X)) != d) {
            state = level.getBlockState(mut.relative(dir));
            if(frame.test(state, level.random)) continue;
            if(state.isAir()) break;
            return false;
        } if(dir == d) return true;
        mut.move(d = dir);
        while(mut.distManhattan(pos) < 33 && !mut.equals(pos)) {
            if(!frame.test(level.getBlockState(mut.relative(d.getCounterClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X))), level.random)) return false;
            do {
                state = level.getBlockState(mut.relative(dir));
                if(frame.test(state, level.random)) continue;
                if(state.isAir()) {
                    d = dir;
                    break;
                } return false;
            } while((dir = dir.getClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X)) != d);
            mut.move(d);
        } return frame.test(level.getBlockState(mut.relative(d.getCounterClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X))), level.random) && mut.equals(pos);
    }
    protected static Direction lookForFrameBlock(Level level, BlockPos pos, Direction.Axis axis, RuleTest frame) {
        Direction d = axis == Direction.Axis.X ? Direction.EAST : Direction.SOUTH, dir = d;
        do {
            if(frame.test(level.getBlockState(pos.relative(dir)), level.random)) return dir;
        } while((dir = dir.getClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X)) != d);
        return null;
    }
    public static void spreadBlock(Level level, BlockState newState, BlockPos pos, Block spreadTarget, Direction.Axis axis) {
        BlockState state;
        if((state = level.getBlockState(pos)).is(spreadTarget) && !state.is(newState.getBlock())) {
            level.setBlock(pos, newState, 16);
            spreadBlock(level, newState, pos.above(), spreadTarget, axis);
            spreadBlock(level, newState, pos.below(), spreadTarget, axis);
            spreadBlock(level, newState, pos.relative(axis, 1), spreadTarget, axis);
            spreadBlock(level, newState, pos.relative(axis, -1), spreadTarget, axis);
        } level.sendBlockUpdated(pos, spreadTarget.defaultBlockState(), newState, 3);
    }
}