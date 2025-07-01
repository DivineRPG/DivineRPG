package divinerpg.block_entities.bosses;

import divinerpg.block_entities.ModUpdatableBlockEntity;
import divinerpg.entities.boss.EntityAyeraco;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockEntityRegistry.AYERACO_SPAWN;
import static divinerpg.registries.EntityRegistry.AYERACO;
import static net.minecraft.world.level.block.Blocks.AIR;

public class AyeracoSpawnBlockEntity extends ModUpdatableBlockEntity {
    /**
     * Using in render, so it needs to be proceeded through update package
     */
    public int spawnTick;
    private BlockPos blueBeam, greenBeam, pinkBeam, purpleBeam, redBeam, yellowBeam;
    /**
     * Always should be an empty ctor
     *
     */
    public AyeracoSpawnBlockEntity(BlockPos pos, BlockState state) {
        super(AYERACO_SPAWN.get(), pos, state);
        spawnTick = 600;
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, AyeracoSpawnBlockEntity block) {
        switch(block.spawnTick) {
            case 600 -> {
                block.blueBeam = getBeamLocation(level, pos, 15, 0);
                block.greenBeam = getBeamLocation(level, pos, 8, 12);
                block.pinkBeam = getBeamLocation(level, pos, -8, 12);
                block.purpleBeam = getBeamLocation(level, pos, -15, 0);
                block.redBeam = getBeamLocation(level, pos, -8, -12);
                block.yellowBeam = getBeamLocation(level, pos, 8, -12);
                level.setBlock(block.blueBeam, BlockRegistry.ayeracoBeamBlue.get().defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.BLUE);
            } case 500 -> {
                level.setBlock(block.greenBeam, BlockRegistry.ayeracoBeamGreen.get().defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.GREEN);
            } case 400 -> {
                level.setBlock(block.pinkBeam, BlockRegistry.ayeracoBeamPink.get().defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.LIGHT_PURPLE);
            } case 300 -> {
                level.setBlock(block.purpleBeam, BlockRegistry.ayeracoBeamPurple.get().defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.DARK_PURPLE);
            } case 200 -> {
                level.setBlock(block.redBeam, BlockRegistry.ayeracoBeamRed.get().defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.RED);
            } case 100 -> {
                level.setBlock(block.yellowBeam, BlockRegistry.ayeracoBeamYellow.get().defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.YELLOW, "yellow");
            } case 0 -> {
                if(!level.isClientSide) {
                    EntityAyeraco[] group = new EntityAyeraco[6];
                    for(byte i = 0; i < 6; i++) group[i] = AYERACO.get().create((ServerLevel) level, null, pos, MobSpawnType.MOB_SUMMONED, true, false).setVariant(i);
                    group[0].setBeamPos(block.blueBeam);
                    group[1].setBeamPos(block.greenBeam);
                    group[2].setBeamPos(block.pinkBeam);
                    group[3].setBeamPos(block.purpleBeam);
                    group[4].setBeamPos(block.redBeam);
                    group[5].setBeamPos(block.yellowBeam);
                    for(byte i = 0; i < 6; i++) {
                        group[i].moveTo(pos.getX() + level.random.nextInt(5) - 2, pos.getY() + level.random.nextInt(10, 20), pos.getZ() + level.random.nextInt(5) - 2);
                        level.addFreshEntity(group[i]);
                        group[i].setVariant(i);
                    }
                } level.setBlock(block.worldPosition, AIR.defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.AQUA, "spawn");
            }
        } if(block.spawnTick > -1) block.spawnTick--;
    }
    private static BlockPos getBeamLocation(Level level, BlockPos pos, int x, int z) {
        BlockPos beamCoords = pos.offset(x, 0, z);
        if(level.getBlockState(beamCoords) == AIR.defaultBlockState()) while(beamCoords.getY() > level.getMinBuildHeight() && level.getBlockState(beamCoords.below()) == AIR.defaultBlockState()) beamCoords = beamCoords.below();
        else while(beamCoords.getY() < level.getMaxBuildHeight() && level.getBlockState(beamCoords) != AIR.defaultBlockState()) beamCoords = beamCoords.above();
        return beamCoords;
    }
    @Override public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        this.spawnTick = tag.getInt("spawnTick");
        if(tag.contains("blueBeam")) blueBeam = BlockPos.of(tag.getLong("blueBeam"));
        if(tag.contains("greenBeam")) greenBeam = BlockPos.of(tag.getLong("greenBeam"));
        if(tag.contains("pinkBeam")) pinkBeam = BlockPos.of(tag.getLong("pinkBeam"));
        if(tag.contains("purpleBeam")) purpleBeam = BlockPos.of(tag.getLong("purpleBeam"));
        if(tag.contains("redBeam")) redBeam = BlockPos.of(tag.getLong("redBeam"));
        if(tag.contains("yellowBeam")) yellowBeam = BlockPos.of(tag.getLong("yellowBeam"));
    }
    @Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("spawnTick", this.spawnTick);
        if(blueBeam != null) tag.putLong("blueBeam", blueBeam.asLong());
        if(greenBeam != null) tag.putLong("greenBeam", greenBeam.asLong());
        if(pinkBeam != null) tag.putLong("greenBeam", pinkBeam.asLong());
        if(purpleBeam != null) tag.putLong("purpleBeam", purpleBeam.asLong());
        if(redBeam != null) tag.putLong("redBeam", redBeam.asLong());
        if(yellowBeam != null) tag.putLong("yellowBeam", yellowBeam.asLong());
    }
    /**
     * Prevent from double logging on client
     *
     * @param formatting - format of message
     */
    private static void logAyeracoSpawn(Level level, ChatFormatting formatting) {logAyeracoSpawn(level, formatting, null);}
    /**
     * Log ayeraco spawn, prevent from double client logging
     *
     * @param formatting - message format
     * @param name       - special name
     */
    private static void logAyeracoSpawn(Level level, ChatFormatting formatting, String name) {
        if(level.getServer() != null) {
            if(name == null) name = formatting.name().toLowerCase();
            final String langKey = "ayeraco." + name;
            level.getServer()
                    .getPlayerList()
                    .getPlayers()
                    .forEach(x -> {
                        Component text = LocalizeUtils.clientMessage(formatting, langKey);
                        x.displayClientMessage(text, true);
                    });
        }
    }
}