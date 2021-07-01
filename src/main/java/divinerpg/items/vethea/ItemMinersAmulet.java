package divinerpg.items.vethea;


import divinerpg.*;
import divinerpg.items.base.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;

public class ItemMinersAmulet extends ItemMod {
    public ItemMinersAmulet(String name) {
        super(name, DivineRPG.tabs.vethea);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        if(entity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entity;
            player.addEffect(new EffectInstance(Effects.DIG_SPEED, 40, 1, false, false));
        }
        super.inventoryTick(stack, world, entity, p_77663_4_, p_77663_5_);
    }

}