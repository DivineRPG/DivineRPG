package divinerpg.items.vethea;


import divinerpg.items.base.ItemMod;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMinersAmulet extends ItemMod {
    public ItemMinersAmulet() {
        super();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, false, false));
        }
        super.inventoryTick(stack, world, entity, p_77663_4_, p_77663_5_);
    }

}