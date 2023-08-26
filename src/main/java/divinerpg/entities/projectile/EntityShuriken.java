package divinerpg.entities.projectile;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityShuriken extends DivineThrowable {

    public EntityShuriken(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityShuriken(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityShuriken(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            result.getEntity().hurt(damageSources().thrown(this, getOwner()), 4.0F);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level().isClientSide()) {
                ItemEntity item = new ItemEntity(level(), xo, yo, zo, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shuriken"))));
                level().addFreshEntity(item);
                this.kill();
            }
        }
    }
}