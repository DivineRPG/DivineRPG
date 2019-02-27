package naturix.divinerpg.objects.blocks.tile.entity;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityAyeracoBeam extends TileEntity {
    @SideOnly(Side.CLIENT)
    private long time;
    @SideOnly(Side.CLIENT)
    private float beam;
    public ResourceLocation texture;

    public TileEntityAyeracoBeam(ResourceLocation tex) {
        texture = tex;
    }

    public TileEntityAyeracoBeam() {
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 65536.0D;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }

    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        texture = new ResourceLocation(compound.getString("texture"));
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setString("texture", this.texture.toString());
        return compound;
    }

    @SideOnly(Side.CLIENT)
    public float renderBeam() {
        int var1 = (int) (this.world.getTotalWorldTime() - this.time);
        this.time = this.world.getTotalWorldTime();

        if (var1 > 1) {
            this.beam -= (float) var1 / 40.0F;
            if (this.beam < 0.0F)
                this.beam = 0.0F;
        }

        this.beam += 0.025F;

        if (this.beam > 1.0F)
            this.beam = 1.0F;

        return this.beam;
    }
}