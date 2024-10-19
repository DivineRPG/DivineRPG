package divinerpg.items.base;

import divinerpg.enums.BulletType;
import divinerpg.util.RarityList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ItemModThrowable extends ItemModRanged {
    public ItemModThrowable(BulletType bulletType) {
        super(RarityList.COMMON, bulletType, 0);
        if(bulletType == BulletType.GRENADE) {
            cooldown = 20;
            sound = SoundEvents.TRIDENT_THROW.value();
        }
    }
    public ItemModThrowable(int nameColor, BulletType bulletType) {super(nameColor, bulletType, 0);}
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(!player.isCreative()) stack.shrink(1);
        return super.use(level, player, hand);
    }
}