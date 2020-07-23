package divinerpg.objects.blocks.tile.entity;

import com.google.common.collect.Lists;
import divinerpg.objects.blocks.tile.entity.base.ModUpdatableTileEntity;
import divinerpg.objects.entities.entity.boss.ayeraco.*;
import divinerpg.registry.BlockRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;

public class TileEntityAyeracoSpawn extends ModUpdatableTileEntity implements ITickable {
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
        this.spawnTick = 600;
    }

    @Override
    public void update() {
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
                if (!world.isRemote) {
                    // Order is important!
                    ArrayList<EntityAyeraco> ayeracos = Lists.newArrayList(
                            new EntityAyeracoRed(this.world, redBeam),
                            new EntityAyeracoGreen(this.world, greenBeam),
                            new EntityAyeracoBlue(this.world, blueBeam),
                            new EntityAyeracoYellow(this.world, yellowBeam),
                            new EntityAyeracoPurple(this.world, purpleBeam));

                    AyeracoGroup ayeracoGroup = new AyeracoGroup(ayeracos);

                    ayeracos.forEach(x -> x.initGroup(ayeracoGroup));
                    ayeracos.forEach(x -> world.spawnEntity(x));
                }

                setBlock(this.pos, Blocks.AIR);
                logAyeracoSpawn(TextFormatting.AQUA, "spawn");
                break;
        }

        spawnTick--;
    }

    private BlockPos getBeamLocation(int x, int z) {
        BlockPos beamCoords = this.pos.add(x, 0, z);
        if (this.world.getBlockState(beamCoords) == Blocks.AIR.getDefaultState()) {
            while (beamCoords.getY() > 0
                    && this.world.getBlockState(beamCoords.down()) == Blocks.AIR.getDefaultState()) {
                beamCoords = beamCoords.down();
            }
        } else {
            while (beamCoords.getY() < 200 && this.world.getBlockState(beamCoords) != Blocks.AIR.getDefaultState()) {
                beamCoords = beamCoords.up();
            }
        }
        return beamCoords;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.spawnTick = tag.getInteger("spawnTick");

        greenBeam = BlockPos.fromLong(tag.getLong("greenBeam"));
        blueBeam = BlockPos.fromLong(tag.getLong("blueBeam"));
        redBeam = BlockPos.fromLong(tag.getLong("redBeam"));
        yellowBeam = BlockPos.fromLong(tag.getLong("yellowBeam"));
        purpleBeam = BlockPos.fromLong(tag.getLong("purpleBeam"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("spawnTick", this.spawnTick);

        if (greenBeam != null) {
            tag.setLong("greenBeam", greenBeam.toLong());
        }

        if (blueBeam != null) {
            tag.setLong("blueBeam", blueBeam.toLong());
        }

        if (redBeam != null) {
            tag.setLong("redBeam", redBeam.toLong());
        }

        if (yellowBeam != null) {
            tag.setLong("yellowBeam", yellowBeam.toLong());
        }

        if (purpleBeam != null) {
            tag.setLong("purpleBeam", purpleBeam.toLong());
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

        if (world.getMinecraftServer() != null) {

            if (name == null) {
                name = formatting.name().toLowerCase();
            }

            final String langKey = "message.ayeraco." + name;

            world.getMinecraftServer()
                    .getPlayerList()
                    .getPlayers()
                    .forEach(x -> {
                        ITextComponent text = LocalizeUtils.getClientSideTranslation(x, langKey);
                        text.getStyle().setColor(formatting);

                        x.sendMessage(text);
                    });
        }
    }

    private void setBlock(BlockPos pos, Block block) {
        this.world.setBlockState(pos, block.getDefaultState());
    }
}