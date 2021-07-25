package divinerpg.tiles.bosses;

import divinerpg.registries.*;
import divinerpg.tiles.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

public class TileEntityAyeracoBeam extends ModUpdatableTileEntity {
    @OnlyIn(Dist.CLIENT)
    private long time;
    @OnlyIn(Dist.CLIENT)
    private float beam;
    public ResourceLocation texture;

    public TileEntityAyeracoBeam(ResourceLocation tex) {
        super(TileRegistry.AYERACO_BEAM);
        texture = tex;
    }
    public TileEntityAyeracoBeam() {
        super(TileRegistry.AYERACO_BEAM);
        texture = TileRegistry.AYERACO_BEAM.create().texture;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public double getViewDistance() {
        return 65536.0D;
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        super.load(state, tag);
        texture = new ResourceLocation(tag.getString("texture"));
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        tag.putString("texture", this.texture.toString());
        return tag;
    }

    @OnlyIn(Dist.CLIENT)
    public float renderBeam() {
        int var1 = (int) (this.level.getGameTime() - this.time);
        this.time = this.level.getGameTime();

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