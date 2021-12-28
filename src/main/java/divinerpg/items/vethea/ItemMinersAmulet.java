package divinerpg.items.vethea;


import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.util.RarityList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ItemMinersAmulet extends ItemMod {
    public ItemMinersAmulet(String name) {
        super(name, RarityList.COMMON, DivineRPG.tabs.vethea);
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