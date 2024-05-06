package divinerpg.items.vethea;

import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.EntityRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemVetheanDisk extends ItemModRanged {
    public ItemVetheanDisk(BulletType diskType) {super(diskType, SoundEvents.ARROW_SHOOT, 0, 0);}
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(!player.isCreative()) itemstack.shrink(1);
        return super.use(world, player, hand);
    }
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        DivineThrowable projectile = new EntityDisk(EntityRegistry.DISK.get(), player, world, bulletType);
        projectile.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, .4F);
        world.addFreshEntity(projectile);
    }
}