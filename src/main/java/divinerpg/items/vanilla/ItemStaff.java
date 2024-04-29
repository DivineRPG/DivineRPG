package divinerpg.items.vanilla;

import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.items.vethea.ItemEvernight;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class ItemStaff extends ItemModRanged {
    public ItemStaff(BulletType projectileType) {super(projectileType, SoundRegistry.STAFF.get(), null, 0, 0, 10);}
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        DivineThrowable projectile = new EntityBouncingProjectile(EntityRegistry.BOUNCING_PROJECTILE.get(), player, world, bulletType);
        projectile.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, .4F);
        world.addFreshEntity(projectile);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if(!(this instanceof ItemEvernight)) tooltip.add(LocalizeUtils.arcanaDam((int)bulletType.getDamage()));
        tooltip.add(LocalizeUtils.bouncingShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}