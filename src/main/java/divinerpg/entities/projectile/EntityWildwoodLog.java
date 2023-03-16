package divinerpg.entities.projectile;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.*;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityWildwoodLog extends DivineThrowable {

	public EntityWildwoodLog(EntityType<? extends ThrowableProjectile> type, Level world) {
		super(type, world);
	}

	public EntityWildwoodLog(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		if (tickCount != 1 || tickCount != 0) {
			if (result.getEntity() != null) {
				result.getEntity().hurt(result.getEntity().level.damageSources().thrown(this, this.getOwner()), 8.0F);
			}
			if (!this.level.isClientSide) {
				level.addFreshEntity(new ItemEntity(level, this.xo, this.yo, this.zo, new ItemStack(getBlock())));
				this.kill();
			}
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult p_230299_1_) {
		if(tickCount != 1 || tickCount != 0) {
			if (!this.level.isClientSide) {
				level.addFreshEntity(new ItemEntity(level, this.xo, this.yo, this.zo, new ItemStack(getBlock())));
				this.kill();
			}
		}
	}

	public static Block getBlock() {
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_log"));
	}
}