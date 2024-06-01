package divinerpg.block_entities;

import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.*;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class AltarOfCorruptionBlockEntity extends BlockEntity implements Nameable {
    public int time;
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    public float rot;
    public float oRot;
    public float tRot;
    private static final RandomSource RANDOM = RandomSource.create();
    private Component name;

    public AltarOfCorruptionBlockEntity(BlockPos p_155501_, BlockState p_155502_) {
        super(BlockEntityRegistry.ALTAR_OF_CORRUPTION.get(), p_155501_, p_155502_);
    }

    protected void saveAdditional(CompoundTag p_187500_) {
        super.saveAdditional(p_187500_);
        if (this.hasCustomName()) {
            p_187500_.putString("CustomName", Component.Serializer.toJson(this.name));
        }

    }

    public void load(CompoundTag p_155509_) {
        super.load(p_155509_);
        if (p_155509_.contains("CustomName", 8)) {
            this.name = Component.Serializer.fromJson(p_155509_.getString("CustomName"));
        }

    }

    public static void bookAnimationTick(Level p_155504_, BlockPos p_155505_, BlockState p_155506_, AltarOfCorruptionBlockEntity p_155507_) {
        p_155507_.oOpen = p_155507_.open;
        p_155507_.oRot = p_155507_.rot;
        Player player = p_155504_.getNearestPlayer((double)p_155505_.getX() + 0.5D, (double)p_155505_.getY() + 0.5D, (double)p_155505_.getZ() + 0.5D, 3.0D, false);
        if (player != null) {
            double d0 = player.getX() - ((double)p_155505_.getX() + 0.5D);
            double d1 = player.getZ() - ((double)p_155505_.getZ() + 0.5D);
            p_155507_.tRot = (float)Mth.atan2(d1, d0);
            p_155507_.open += 0.1F;
            if (p_155507_.open < 0.5F || RANDOM.nextInt(40) == 0) {
                float f1 = p_155507_.flipT;

                do {
                    p_155507_.flipT += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while(f1 == p_155507_.flipT);
            }
        } else {
            p_155507_.tRot += 0.02F;
            p_155507_.open -= 0.1F;
        }

        while(p_155507_.rot >= (float)Math.PI) {
            p_155507_.rot -= ((float)Math.PI * 2F);
        }

        while(p_155507_.rot < -(float)Math.PI) {
            p_155507_.rot += ((float)Math.PI * 2F);
        }

        while(p_155507_.tRot >= (float)Math.PI) {
            p_155507_.tRot -= ((float)Math.PI * 2F);
        }

        while(p_155507_.tRot < -(float)Math.PI) {
            p_155507_.tRot += ((float)Math.PI * 2F);
        }

        float f2;
        for(f2 = p_155507_.tRot - p_155507_.rot; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F)) {
        }

        while(f2 < -(float)Math.PI) {
            f2 += ((float)Math.PI * 2F);
        }

        p_155507_.rot += f2 * 0.4F;
        p_155507_.open = Mth.clamp(p_155507_.open, 0.0F, 1.0F);
        ++p_155507_.time;
        p_155507_.oFlip = p_155507_.flip;
        float f = (p_155507_.flipT - p_155507_.flip) * 0.4F;
        f = Mth.clamp(f, -0.2F, 0.2F);
        p_155507_.flipA += (f - p_155507_.flipA) * 0.9F;
        p_155507_.flip += p_155507_.flipA;
    }

    public Component getName() {
        return this.name != null ? this.name : Component.translatable("container.enchant");
    }

    public void setCustomName(@Nullable Component p_59273_) {
        this.name = p_59273_;
    }

    @Nullable
    public Component getCustomName() {
        return this.name;
    }
}
