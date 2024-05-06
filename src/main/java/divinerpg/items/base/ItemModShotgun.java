package divinerpg.items.base;

import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModShotgun extends ItemModRanged {
	public ItemModShotgun(BulletType bulletType, SoundEvent sound, int uses, int delay, Item ammoSupplier, int arcanaConsuming, int projectileAmount) {
		super(bulletType, sound, ammoSupplier, uses, delay, arcanaConsuming);
		this.projectileAmount = projectileAmount;
	}
	@Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        RandomSource rand = world.random;
        for(int i = 0; i < projectileAmount; i++) {
            ThrowableProjectile entity = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, bulletType);
            entity.shootFromRotation(player, player.xRot + ((rand.nextFloat() - .5F) * 3.5F), player.yRot + ((rand.nextFloat() - .5F) * 3.5F), 0, 1.5F, 1);
            entity.moveTo(entity.getX() + (rand.nextDouble() - .5), entity.getY() + (rand.nextDouble() - .5), entity.getZ() + (rand.nextDouble() - .5));
            world.addFreshEntity(entity);
        }
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(bulletType.getBulletDamageType() == BulletType.BulletDamageType.PHYSIC) tooltip.add(LocalizeUtils.rangedDam(projectileAmount + "x" + (int)bulletType.getDamage()));
        if(bulletType.getBulletDamageType() == BulletType.BulletDamageType.ARCANA) tooltip.add(LocalizeUtils.arcanaDam(projectileAmount + "x" + (int)bulletType.getDamage()));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}