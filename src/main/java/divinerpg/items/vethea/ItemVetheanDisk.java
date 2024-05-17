package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
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
}