package divinerpg.items.base;

import java.util.function.Supplier;

import divinerpg.enums.BulletType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class ItemModShotgun extends ItemModRanged {
	protected final int projectileAmount;
	public ItemModShotgun(String entityType, BulletType bulletType, Supplier<SoundEvent> sound, SoundSource soundCategory, int maxDamage, int delay, ResourceLocation ammoSupplier, int arcanaConsuming, int projectileAmount) {
		super(entityType, bulletType, sound, soundCategory, maxDamage, delay, ammoSupplier, arcanaConsuming);
		this.projectileAmount = projectileAmount;
	}
	@Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        RandomSource rand = world.random;
        for(int i = 0; i < projectileAmount; i++) {
            ThrowableProjectile entity = createProjectile(world, player);
            entity.shootFromRotation(player, player.xRot + ((rand.nextFloat() - .5F) * 3.5F), player.yRot + ((rand.nextFloat() - .5F) * 3.5F), 0.0F, 1.5F, 1.0F);
            entity.moveTo(entity.getX() + (rand.nextDouble() - .5), entity.getY() + (rand.nextDouble() - .5), entity.getZ() + (rand.nextDouble() - .5));
            world.addFreshEntity(entity);
        }
    }
	protected abstract ThrowableProjectile createProjectile(Level world, LivingEntity player);
}