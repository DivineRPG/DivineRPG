package divinerpg.items.arcana;

import divinerpg.entities.projectile.EntityFirefly;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemFirefly extends ItemModRanged {
    public ItemFirefly() {super("firefly", null, SoundRegistry.FIREFLY.get(), 1216, 30, null, 25);}
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        ThrowableProjectile bullet = new EntityFirefly(EntityRegistry.FIREFLY.get(), player, world);
        bullet.moveTo(player.xo, player.getEyeY(), player.zo);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, 1);
        world.addFreshEntity(bullet);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaDam(8));
        tooltip.add(LocalizeUtils.homingShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}