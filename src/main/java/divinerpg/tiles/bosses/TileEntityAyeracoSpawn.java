package divinerpg.tiles.bosses;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.EntityAyeraco;
import divinerpg.registries.*;
import divinerpg.tiles.ModUpdatableTileEntity;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityAyeracoSpawn extends ModUpdatableTileEntity {
    /**
     * Using in render, so it need to be proceed through update package
     */
    public int spawnTick;
    private BlockPos blueBeam, greenBeam, pinkBeam, purpleBeam, redBeam, yellowBeam;
    /**
     * Always should be a empty ctor
     *
     * @param p_155229_
     * @param p_155230_
     */
    public TileEntityAyeracoSpawn(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntityRegistry.AYERACO_SPAWN.get(), p_155229_, p_155230_);
        spawnTick = 600;
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, TileEntityAyeracoSpawn block) {
        switch (block.spawnTick) {
            case 600:
                block.blueBeam = getBeamLocation(level, pos, 15, 0);
                block.greenBeam = getBeamLocation(level, pos, 8, 12);
                block.pinkBeam = getBeamLocation(level, pos, -8, 12);
                block.purpleBeam = getBeamLocation(level, pos, -15, 0);
                block.redBeam = getBeamLocation(level, pos, -8, -12);
                block.yellowBeam = getBeamLocation(level, pos, 8, -12);
                level.setBlock(block.blueBeam, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_blue")).defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.BLUE);
                break;
            case 500:
                level.setBlock(block.greenBeam, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_green")).defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.GREEN);
                break;
            case 400:
                level.setBlock(block.pinkBeam, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_pink")).defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.LIGHT_PURPLE);
                break;
            case 300:
                level.setBlock(block.purpleBeam, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_purple")).defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.DARK_PURPLE);
                break;
            case 200:
                level.setBlock(block.redBeam, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_red")).defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.RED);
                break;
            case 100:
                level.setBlock(block.yellowBeam, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_yellow")).defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.YELLOW, "yellow");
                break;
            case 0:
                if (!level.isClientSide) {
                    EntityAyeraco group[] = new EntityAyeraco[6];
                    for(byte i = 0; i < 6; i++) group[i] = EntityRegistry.AYERACO.get().create(level).setVariant(i);
                    group[0].setBeamPos(block.blueBeam).assignGroup(new EntityAyeraco[]{group[1], group[2], group[3], group[4], group[5]});
                    group[1].setBeamPos(block.greenBeam).assignGroup(new EntityAyeraco[]{group[0], group[2], group[3], group[4], group[5]});
                    group[2].setBeamPos(block.pinkBeam).assignGroup(new EntityAyeraco[]{group[1], group[0], group[3], group[4], group[5]});;
                    group[3].setBeamPos(block.purpleBeam).assignGroup(new EntityAyeraco[]{group[1], group[2], group[0], group[4], group[5]});
                    group[4].setBeamPos(block.redBeam).assignGroup(new EntityAyeraco[]{group[1], group[2], group[3], group[0], group[5]});
                    group[5].setBeamPos(block.yellowBeam).assignGroup(new EntityAyeraco[]{group[1], group[2], group[3], group[4], group[0]});
                    for(byte i = 0; i < 6; i++) {
                        group[i].moveTo(pos.getX() + level.random.nextInt(5) - 2, pos.getY() + level.random.nextInt(10, 20), pos.getZ() + level.random.nextInt(5) - 2);
                        level.addFreshEntity(group[i]);
                        group[i].setVariant(i);
                    }
                }
                level.setBlock(block.worldPosition, Blocks.AIR.defaultBlockState(), 3);
                logAyeracoSpawn(level, ChatFormatting.AQUA, "spawn");
                break;
        }
        if(block.spawnTick > -1) block.spawnTick--;
    }
    private static BlockPos getBeamLocation(Level level, BlockPos pos, int x, int z) {
        BlockPos beamCoords = pos.offset(x, 0, z);
        if(level.getBlockState(beamCoords) == Blocks.AIR.defaultBlockState()) while(beamCoords.getY() > 0 && level.getBlockState(beamCoords.below()) == Blocks.AIR.defaultBlockState()) beamCoords = beamCoords.below();
        else while(beamCoords.getY() < 200 && level.getBlockState(beamCoords) != Blocks.AIR.defaultBlockState()) beamCoords = beamCoords.above();
        return beamCoords;
    }
    @Override
    public void load(CompoundTag tag) {
        this.spawnTick = tag.getInt("spawnTick");

        blueBeam = BlockPos.of(tag.getLong("blueBeam"));
        greenBeam = BlockPos.of(tag.getLong("greenBeam"));
        pinkBeam = BlockPos.of(tag.getLong("pinkBeam"));
        purpleBeam = BlockPos.of(tag.getLong("purpleBeam"));
        redBeam = BlockPos.of(tag.getLong("redBeam"));
        yellowBeam = BlockPos.of(tag.getLong("yellowBeam"));
    }
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
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
    private static void logAyeracoSpawn(Level level, ChatFormatting formatting) {
        logAyeracoSpawn(level, formatting, null);
    }
    /**
     * Log ayeraco spawn, prevent from double client logging
     *
     * @param formatting - message format
     * @param name       - special name
     */
    private static void logAyeracoSpawn(Level level, ChatFormatting formatting, String name) {
        if (level.getServer() != null) {
            if (name == null) name = formatting.name().toLowerCase();
            final String langKey = "message.ayeraco." + name;
            level.getServer()
                    .getPlayerList()
                    .getPlayers()
                    .forEach(x -> {
                        Component text = LocalizeUtils.getClientSideTranslation(x, langKey);
                        text.getStyle().withColor(formatting);
                        x.displayClientMessage(text, true);
                    });
        }
    }
}