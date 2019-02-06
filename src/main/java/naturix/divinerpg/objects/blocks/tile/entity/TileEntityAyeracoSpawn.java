package naturix.divinerpg.objects.blocks.tile.entity;

import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoBlue;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoGreen;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoPurple;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoRed;
import naturix.divinerpg.objects.entities.entity.vanilla.AyeracoYellow;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

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
        if (!this.world.isRemote) {
            if (this.spawnTick == 600) {
                greenBeam = getBeamLocation(8, 8);
                blueBeam = getBeamLocation(15, 0);
                redBeam = getBeamLocation(5, -12);
                yellowBeam = getBeamLocation(-5, -12);
                purpleBeam = getBeamLocation(-8, 8);

                Logging.broadcast(MessageLocalizer.normal("message.ayeraco.green", TextFormatting.GREEN));
                this.world.setBlockState(greenBeam, ModBlocks.ayeracoBeamGreen.getDefaultState());
            } else if (this.spawnTick == 430) {
                Logging.broadcast(MessageLocalizer.normal("message.ayeraco.blue", TextFormatting.BLUE));
                this.world.setBlockState(blueBeam, ModBlocks.ayeracoBeamBlue.getDefaultState());
            } else if (this.spawnTick == 300) {
                Logging.broadcast(MessageLocalizer.normal("message.ayeraco.red", TextFormatting.RED));
                this.world.setBlockState(redBeam, ModBlocks.ayeracoBeamRed.getDefaultState());
            } else if (this.spawnTick == 210) {
                Logging.broadcast(MessageLocalizer.normal("message.ayeraco.yellow", TextFormatting.YELLOW));
                this.world.setBlockState(yellowBeam, ModBlocks.ayeracoBeamYellow.getDefaultState());
            } else if (this.spawnTick == 145) {
                Logging.broadcast(MessageLocalizer.normal("message.ayeraco.purple", TextFormatting.DARK_PURPLE));
                this.world.setBlockState(purpleBeam, ModBlocks.ayeracoBeamPurple.getDefaultState());
            } else if (this.spawnTick == 0) {
                AyeracoGreen ayercoGreen = new AyeracoGreen(this.world);
                AyeracoBlue ayercoBlue = new AyeracoBlue(this.world);
                AyeracoRed ayercoRed = new AyeracoRed(this.world);
                AyeracoYellow ayercoYellow = new AyeracoYellow(this.world);
                AyeracoPurple ayercoPurple = new AyeracoPurple(this.world);

                ayercoGreen.setLocationAndAngles(greenBeam.getX(), greenBeam.getY() + 4, greenBeam.getZ(),
                        this.world.rand.nextFloat() * 360.0F, 0.0F);
                ayercoBlue.setLocationAndAngles(blueBeam.getX(), blueBeam.getY() + 4, blueBeam.getZ(),
                        this.world.rand.nextFloat() * 360.0F, 0.0F);
                ayercoRed.setLocationAndAngles(redBeam.getX(), redBeam.getY() + 4, redBeam.getZ(),
                        this.world.rand.nextFloat() * 360.0F, 0.0F);
                ayercoYellow.setLocationAndAngles(yellowBeam.getX(), yellowBeam.getY() + 4, yellowBeam.getZ(),
                        this.world.rand.nextFloat() * 360.0F, 0.0F);
                ayercoPurple.setLocationAndAngles(purpleBeam.getX(), purpleBeam.getY() + 4, purpleBeam.getZ(),
                        this.world.rand.nextFloat() * 360.0F, 0.0F);

                ayercoGreen.initOthers(ayercoBlue, ayercoRed, ayercoYellow, ayercoPurple);
                ayercoBlue.initOthers(ayercoGreen, ayercoRed, ayercoYellow, ayercoPurple);
                ayercoRed.initOthers(ayercoBlue, ayercoGreen, ayercoYellow, ayercoPurple);
                ayercoYellow.initOthers(ayercoBlue, ayercoGreen, ayercoRed, ayercoPurple);
                ayercoPurple.initOthers(ayercoBlue, ayercoGreen, ayercoRed, ayercoYellow);

                ayercoGreen.setBeamLocation(greenBeam.getX(), greenBeam.getY(), greenBeam.getZ());
                ayercoBlue.setBeamLocation(blueBeam.getX(), blueBeam.getY(), blueBeam.getZ());
                ayercoRed.setBeamLocation(redBeam.getX(), redBeam.getY(), redBeam.getZ());
                ayercoYellow.setBeamLocation(yellowBeam.getX(), yellowBeam.getY(), yellowBeam.getZ());
                ayercoPurple.setBeamLocation(purpleBeam.getX(), purpleBeam.getY(), purpleBeam.getZ());

                this.world.spawnEntity(ayercoGreen);
                this.world.spawnEntity(ayercoBlue);
                this.world.spawnEntity(ayercoRed);
                this.world.spawnEntity(ayercoYellow);
                this.world.spawnEntity(ayercoPurple);

                Logging.broadcast(MessageLocalizer.normal("message.ayeraco.spawn", TextFormatting.AQUA));
            }
            if (spawnTick == 0)
                this.world.setBlockState(this.pos, Blocks.AIR.getDefaultState());
        }
        if (this.spawnTick > 0) {
            this.spawnTick--;
        }
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
}