package divinerpg.items.vethea;

import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemStaff extends ItemModRanged {
    public ItemStaff(BulletType projectileType, int arcana, int onUseDamage) {
        super(projectileType, SoundRegistry.STAFF.get(), null, 0, 0, arcana);
        this.onUseDamage = onUseDamage;
    }
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        DivineThrowable projectile = new EntityBouncingProjectile(EntityRegistry.BOUNCING_PROJECTILE.get(), player, world, bulletType);
        projectile.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, .4F);
        world.addFreshEntity(projectile);
    }
}