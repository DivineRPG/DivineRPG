package divinerpg.items.vethea;

import divinerpg.items.base.ItemMod;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMinersAmulet extends ItemMod {
    public ItemMinersAmulet() {super(new Properties().stacksTo(1));}
    @Override public void inventoryTick(ItemStack stack, Level world, Entity entity, int i, boolean b) {
        Player player = (Player) entity;
        for(InteractionHand hand : InteractionHand.values()) {
            ItemStack handStack = player.getItemInHand(hand);
            if(handStack.getItem() == this) player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, false, false));
        } super.inventoryTick(stack, world, entity, i, b);
    }
}