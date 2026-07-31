package divinerpg.items.vanilla;

import divinerpg.items.base.ItemThrowable;
import divinerpg.registries.EntityRegistry;
import divinerpg.utils.FoodList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.DivineRPG.MODID;

public class ItemTomato extends ItemThrowable {
    public ItemTomato() {
        super(new Properties().food(FoodList.TOMATO).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "tomato"))), EntityRegistry.TOMATO::value, .5F);
    }
    @Override public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(player.isShiftKeyDown()) return super.use(world, player, hand);
        else if(player.canEat(stack.get(DataComponents.FOOD).canAlwaysEat())) {
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        } else return InteractionResult.PASS;
    }
}