package divinerpg.tiles.bosses;

import com.google.common.collect.*;
import divinerpg.entities.boss.ayeraco.*;
import divinerpg.registries.*;
import divinerpg.tiles.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;

import java.util.*;

public class TileEntityAyeracoSpawn extends ModUpdatableTileEntity implements ITickableTileEntity {
    private BlockPos greenBeam;
    private BlockPos blueBeam;
    private BlockPos redBeam;
    private BlockPos yellowBeam;
    private BlockPos purpleBeam;

    /**
     * Using in render, so it need to be proceed through update package
     */
    public int spawnTick;

    public TileEntityAyeracoSpawn() {
        super(TileRegistry.AYERACO_SPAWN);
        this.spawnTick = 600;
    }

    @Override
    public void tick() {
        switch (spawnTick) {
            case 600:
                greenBeam = getBeamLocation(8, 8);
                blueBeam = getBeamLocation(15, 0);
                redBeam = getBeamLocation(5, -12);
                yellowBeam = getBeamLocation(-5, -12);
                purpleBeam = getBeamLocation(-8, 8);
                setBlock(greenBeam, BlockRegistry.ayeracoBeamGreen);
                logAyeracoSpawn(TextFormatting.GREEN);
                break;

            case 430:
                setBlock(blueBeam, BlockRegistry.ayeracoBeamBlue);
                logAyeracoSpawn(TextFormatting.BLUE);
                break;

            case 300:
                setBlock(redBeam, BlockRegistry.ayeracoBeamRed);
                logAyeracoSpawn(TextFormatting.RED);
                break;

            case 210:
                setBlock(yellowBeam, BlockRegistry.ayeracoBeamYellow);
                logAyeracoSpawn(TextFormatting.YELLOW);
                break;

            case 145:
                setBlock(purpleBeam, BlockRegistry.ayeracoBeamPurple);
                logAyeracoSpawn(TextFormatting.DARK_PURPLE, "purple");
                break;

            case 0:
                // Spawn entities only on server
                if (!level.isClientSide) {
                    // Order is important!
                    ArrayList<EntityAyeraco> ayeracos = Lists.newArrayList(
//                            new EntityAyeracoRed(this.level, redBeam),
//                            new EntityAyeracoGreen(this.level, greenBeam),
//                            new EntityAyeracoBlue(this.level, blueBeam),
//                            new EntityAyeracoYellow(this.level, yellowBeam),
//                            new EntityAyeracoPurple(this.level, purpleBeam));
                    new EntityAyeracoRed(EntityRegistry.AYERACO_RED, this.level),
                            new EntityAyeracoGreen(EntityRegistry.AYERACO_GREEN, this.level),
                            new EntityAyeracoBlue(EntityRegistry.AYERACO_BLUE, this.level),
                            new EntityAyeracoYellow(EntityRegistry.AYERACO_YELLOW, this.level),
                            new EntityAyeracoPurple(EntityRegistry.AYERACO_PURPLE, this.level));

                    AyeracoGroup ayeracoGroup = new AyeracoGroup(ayeracos);

                    ayeracos.forEach(x -> x.initGroup(ayeracoGroup));
                    ayeracos.forEach(x -> x.moveTo(worldPosition.getX(), worldPosition.getY()+10, worldPosition.getZ()));
                    ayeracos.forEach(x -> level.addFreshEntity(x));
                }

                setBlock(this.worldPosition, Blocks.AIR);
                logAyeracoSpawn(TextFormatting.AQUA, "spawn");
                break;
        }

        spawnTick--;
    }

    private BlockPos getBeamLocation(int x, int z) {
        BlockPos beamCoords = this.worldPosition.offset(x, 0, z);
        if (this.level.getBlockState(beamCoords) == Blocks.AIR.defaultBlockState()) {
            while (beamCoords.getY() > 0
                    && this.level.getBlockState(beamCoords.below()) == Blocks.AIR.defaultBlockState()) {
                beamCoords = beamCoords.below();
            }
        } else {
            while (beamCoords.getY() < 200 && this.level.getBlockState(beamCoords) != Blocks.AIR.defaultBlockState()) {
                beamCoords = beamCoords.above();
            }
        }
        return beamCoords;
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        this.spawnTick = tag.getInt("spawnTick");

        greenBeam = BlockPos.of(tag.getLong("greenBeam"));
        blueBeam = BlockPos.of(tag.getLong("blueBeam"));
        redBeam = BlockPos.of(tag.getLong("redBeam"));
        yellowBeam = BlockPos.of(tag.getLong("yellowBeam"));
        purpleBeam = BlockPos.of(tag.getLong("purpleBeam"));
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        tag.putInt("spawnTick", this.spawnTick);

        if (greenBeam != null) {
            tag.putLong("greenBeam", greenBeam.asLong());
        }

        if (blueBeam != null) {
            tag.putLong("blueBeam", blueBeam.asLong());
        }

        if (redBeam != null) {
            tag.putLong("redBeam", redBeam.asLong());
        }

        if (yellowBeam != null) {
            tag.putLong("yellowBeam", yellowBeam.asLong());
        }

        if (purpleBeam != null) {
            tag.putLong("purpleBeam", purpleBeam.asLong());
        }

        return tag;
    }

    /**
     * Prevent from double logging on client
     *
     * @param formatting - format of message
     */
    private void logAyeracoSpawn(TextFormatting formatting) {
        logAyeracoSpawn(formatting, null);
    }

    /**
     * Log ayeraco spawn, prevent from double client logging
     *
     * @param formatting - message format
     * @param name       - special name
     */
    private void logAyeracoSpawn(TextFormatting formatting, String name) {

        if (level.getServer() != null) {

            if (name == null) {
                name = formatting.name().toLowerCase();
            }

            final String langKey = "message.ayeraco." + name;

            level.getServer()
                    .getPlayerList()
                    .getPlayers()
                    .forEach(x -> {
                        ITextComponent text = LocalizeUtils.getClientSideTranslation(x, langKey);
                        text.getStyle().withColor(formatting);

                        x.sendMessage(text, x.getUUID());
                    });
        }
    }

    private void setBlock(BlockPos pos, Block block) {
        this.level.setBlock(pos, block.defaultBlockState(), 0);
    }
}