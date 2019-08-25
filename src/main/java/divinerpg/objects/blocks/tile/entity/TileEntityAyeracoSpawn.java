package divinerpg.objects.blocks.tile.entity;

import com.google.common.collect.Lists;
import divinerpg.objects.entities.entity.vanilla.ayeraco.*;
import divinerpg.registry.ModBlocks;
import divinerpg.utils.MessageLocalizer;
import divinerpg.utils.log.Logging;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;

public class TileEntityAyeracoSpawn extends TileEntity implements ITickable {
    private BlockPos greenBeam;
    private BlockPos blueBeam;
    private BlockPos redBeam;
    private BlockPos yellowBeam;
    private BlockPos purpleBeam;
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
                setBlock(greenBeam, ModBlocks.ayeracoBeamGreen);
                logAyeracoSpawn(TextFormatting.GREEN);
                break;

            case 430:
                setBlock(blueBeam, ModBlocks.ayeracoBeamBlue);
                logAyeracoSpawn(TextFormatting.BLUE);
                break;

            case 300:
                setBlock(redBeam, ModBlocks.ayeracoBeamRed);
                logAyeracoSpawn(TextFormatting.RED);
                break;

            case 210:
                setBlock(yellowBeam, ModBlocks.ayeracoBeamYellow);
                logAyeracoSpawn(TextFormatting.YELLOW);
                break;

            case 145:
                setBlock(purpleBeam, ModBlocks.ayeracoBeamPurple);
                logAyeracoSpawn(TextFormatting.DARK_PURPLE, "purple");
                break;

            case 0:
                // Spawn entities only on server
                if (!world.isRemote) {
                    // Order is important!
                    ArrayList<Ayeraco> ayeracos = Lists.newArrayList(
                            new AyeracoRed(this.world, redBeam),
                            new AyeracoGreen(this.world, greenBeam),
                            new AyeracoBlue(this.world, blueBeam),
                            new AyeracoYellow(this.world, yellowBeam),
                            new AyeracoPurple(this.world, purpleBeam));

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

        greenBeam = new BlockPos(tag.getInteger("greenBeamX"), tag.getInteger("greenBeamY"),
                tag.getInteger("greenBeamZ"));
        blueBeam = new BlockPos(tag.getInteger("blueBeamX"), tag.getInteger("blueBeamY"), tag.getInteger("blueBeamZ"));
        redBeam = new BlockPos(tag.getInteger("redBeamX"), tag.getInteger("redBeamY"), tag.getInteger("redBeamZ"));
        yellowBeam = new BlockPos(tag.getInteger("yellowBeamX"), tag.getInteger("yellowBeamY"),
                tag.getInteger("yellowBeamZ"));
        purpleBeam = new BlockPos(tag.getInteger("purpleBeamX"), tag.getInteger("purpleBeamY"),
                tag.getInteger("purpleBeamZ"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("spawnTick", this.spawnTick);

        tag.setInteger("greenBeamX", greenBeam.getX());
        tag.setInteger("greenBeamY", greenBeam.getY());
        tag.setInteger("greenBeamZ", greenBeam.getZ());

        tag.setInteger("blueBeamX", blueBeam.getX());
        tag.setInteger("blueBeamY", blueBeam.getY());
        tag.setInteger("blueBeamZ", blueBeam.getZ());

        tag.setInteger("redBeamX", redBeam.getX());
        tag.setInteger("redBeamY", redBeam.getY());
        tag.setInteger("redBeamZ", redBeam.getZ());

        tag.setInteger("yellowBeamX", yellowBeam.getX());
        tag.setInteger("yellowBeamY", yellowBeam.getY());
        tag.setInteger("yellowBeamZ", yellowBeam.getZ());

        tag.setInteger("purpleBeamX", purpleBeam.getX());
        tag.setInteger("purpleBeamY", purpleBeam.getY());
        tag.setInteger("purpleBeamZ", purpleBeam.getZ());
        return tag;
    }

    /**
     * Prevent from double logging on client
     * @param formatting - format of message
     */
    private void logAyeracoSpawn(TextFormatting formatting){
        logAyeracoSpawn(formatting, null);
    }

    /**
     * Log ayeraco spawn, prevent from double client logging
     * @param formatting - message format
     * @param name - special name
     */
    private void logAyeracoSpawn(TextFormatting formatting, String name){
        if (world.isRemote)
            return;

        if (name == null){
            name = formatting.name().toLowerCase();
        }

        // Here creating the key like "message.ayeraco.blue"
        Logging.broadcast(MessageLocalizer.normal("message.ayeraco." + name, formatting));
    }

    private void setBlock(BlockPos pos, Block block) {
        this.world.setBlockState(pos, block.getDefaultState());
    }
}