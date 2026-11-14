package divinerpg.block_entities.block;

import divinerpg.entities.boss.EntityAyeraco;
import divinerpg.registries.BlockRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.*;

import static divinerpg.registries.BlockEntityRegistry.AYERACO_SPAWN;
import static divinerpg.registries.EntityRegistry.AYERACO;
import static net.minecraft.world.level.block.Blocks.AIR;

public class AyeracoSpawnBlockEntity extends UpdatableBlockEntity {
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
                if(!level.isClientSide()) {
                    EntityAyeraco[] group = new EntityAyeraco[6];
                    for(byte i = 0; i < 6; i++) group[i] = AYERACO.get().create((ServerLevel) level, null, pos, EntitySpawnReason.MOB_SUMMONED, true, false).setVariant(i);
                    group[0].setBeamPos(block.blueBeam);
                    group[1].setBeamPos(block.greenBeam);
                    group[2].setBeamPos(block.pinkBeam);
                    group[3].setBeamPos(block.purpleBeam);
                    group[4].setBeamPos(block.redBeam);
                    group[5].setBeamPos(block.yellowBeam);
                    for(byte i = 0; i < 6; i++) {
                        group[i].setPos(pos.getX() + level.getRandom().nextInt(5) - 2, pos.getY() + level.getRandom().nextInt(10, 20), pos.getZ() + level.getRandom().nextInt(5) - 2);
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
        if(level.getBlockState(beamCoords) == AIR.defaultBlockState()) while(level.isInsideBuildHeight(beamCoords.getY() - 1) && level.getBlockState(beamCoords.below()) == AIR.defaultBlockState()) beamCoords = beamCoords.below();
        else while(level.isInsideBuildHeight(beamCoords.getY() + 1) && level.getBlockState(beamCoords) != AIR.defaultBlockState()) beamCoords = beamCoords.above();
        return beamCoords;
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.spawnTick = input.getIntOr("spawnTick", 0);
        input.getLong("blueBeam").ifPresent(x -> blueBeam = BlockPos.of(x));
        input.getLong("greenBeam").ifPresent(x -> greenBeam = BlockPos.of(x));
        input.getLong("pinkBeam").ifPresent(x -> pinkBeam = BlockPos.of(x));
        input.getLong("purpleBeam").ifPresent(x -> purpleBeam = BlockPos.of(x));
        input.getLong("redBeam").ifPresent(x -> redBeam = BlockPos.of(x));
        input.getLong("yellowBeam").ifPresent(x -> yellowBeam = BlockPos.of(x));
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("spawnTick", this.spawnTick);
        if(blueBeam != null) output.putLong("blueBeam", blueBeam.asLong());
        if(greenBeam != null) output.putLong("greenBeam", greenBeam.asLong());
        if(pinkBeam != null) output.putLong("greenBeam", pinkBeam.asLong());
        if(purpleBeam != null) output.putLong("purpleBeam", purpleBeam.asLong());
        if(redBeam != null) output.putLong("redBeam", redBeam.asLong());
        if(yellowBeam != null) output.putLong("yellowBeam", yellowBeam.asLong());
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
                        x.sendOverlayMessage(text);
                    });
        }
    }
}