package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityGeneralsStaff;
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

public class ItemGeneralsStaff extends ItemModRanged {

    public ItemGeneralsStaff() {
        super("generals_staff", null, SoundRegistry.STARLIGHT.get(), 0, 50, null, 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(18));
        tooltip.add(LocalizeUtils.i18n("tooltip.generals_staff.split"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType,
                               String entityType) {

        ThrowableProjectile bullet = new EntityGeneralsStaff(EntityRegistry.GENERALS_STAFF.get(), player, world);
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
        world.addFreshEntity(bullet);
    }

}
