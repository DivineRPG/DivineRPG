package divinerpg.tiles;

import divinerpg.registries.TileRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.*;
import net.minecraft.util.INameable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.*;

import javax.annotation.Nullable;
import java.util.Random;

public class AltarOfCorruptionEntity extends TileEntity implements INameable, ITickableTileEntity {
    public int ticks;
    public float field_195523_f;
    public float field_195524_g;
    public float field_195525_h;
    public float field_195526_i;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public float nextPageAngle;
    public float pageAngle;
    public float field_195531_n;
    private static final Random random = new Random();
    private ITextComponent customname;

    public AltarOfCorruptionEntity(TileEntityType<AltarOfCorruptionEntity> altarOfCorruptionTeType) {
        super(TileRegistry.ALTAR_OF_CORRUPTION_TE_TYPE);
    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (this.hasCustomName()) {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customname));
        }

        return compound;
    }

    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        if (nbt.contains("CustomName", 8)) {
            this.customname = ITextComponent.Serializer.getComponentFromJson(nbt.getString("CustomName"));
        }

    }

    public void tick() {
        this.pageTurningSpeed = this.nextPageTurningSpeed;
        this.pageAngle = this.nextPageAngle;
        PlayerEntity playerentity = this.world.getClosestPlayer((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D, 3.0D, false);
        if (playerentity != null) {
            double d0 = playerentity.getPosX() - ((double)this.pos.getX() + 0.5D);
            double d1 = playerentity.getPosZ() - ((double)this.pos.getZ() + 0.5D);
            this.field_195531_n = (float) MathHelper.atan2(d1, d0);
            this.nextPageTurningSpeed += 0.1F;
            if (this.nextPageTurningSpeed < 0.5F || random.nextInt(40) == 0) {
                float f1 = this.field_195525_h;

                do {
                    this.field_195525_h += (float)(random.nextInt(4) - random.nextInt(4));
                } while(f1 == this.field_195525_h);
            }
        } else {
            this.field_195531_n += 0.02F;
            this.nextPageTurningSpeed -= 0.1F;
        }

        while(this.nextPageAngle >= (float)Math.PI) {
            this.nextPageAngle -= ((float)Math.PI * 2F);
        }

        while(this.nextPageAngle < -(float)Math.PI) {
            this.nextPageAngle += ((float)Math.PI * 2F);
        }

        while(this.field_195531_n >= (float)Math.PI) {
            this.field_195531_n -= ((float)Math.PI * 2F);
        }

        while(this.field_195531_n < -(float)Math.PI) {
            this.field_195531_n += ((float)Math.PI * 2F);
        }

        float f2;
        for(f2 = this.field_195531_n - this.nextPageAngle; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F)) {
        }

        while(f2 < -(float)Math.PI) {
            f2 += ((float)Math.PI * 2F);
        }

        this.nextPageAngle += f2 * 0.4F;
        this.nextPageTurningSpeed = MathHelper.clamp(this.nextPageTurningSpeed, 0.0F, 1.0F);
        ++this.ticks;
        this.field_195524_g = this.field_195523_f;
        float f = (this.field_195525_h - this.field_195523_f) * 0.4F;
        float f3 = 0.2F;
        f = MathHelper.clamp(f, -0.2F, 0.2F);
        this.field_195526_i += (f - this.field_195526_i) * 0.9F;
        this.field_195523_f += this.field_195526_i;
    }

    public ITextComponent getName() {
        return (ITextComponent)(this.customname != null ? this.customname : new TranslationTextComponent("tile.altar_of_corruption.name"));
    }

    public void setCustomName(@Nullable ITextComponent name) {
        this.customname = name;
    }

    @Nullable
    public ITextComponent getCustomName() {
        return this.customname;
    }
}