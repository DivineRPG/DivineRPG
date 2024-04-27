package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityFirefly;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFirefly extends ItemModRanged {
    public ItemFirefly() {
        super("firefly", null, SoundRegistry.FIREFLY.get(), 0, 0, null, 5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.homingShots());
        tooltip.add(LocalizeUtils.rangedDam(15));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        ThrowableProjectile bullet = new EntityFirefly(EntityRegistry.FIREFLY.get(), player, world);
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
        world.addFreshEntity(bullet);
    }

}
