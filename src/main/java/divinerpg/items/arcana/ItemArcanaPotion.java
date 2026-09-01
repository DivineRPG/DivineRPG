package divinerpg.items.arcana;

import divinerpg.items.base.ItemModFood;
import divinerpg.utils.ArcanaHelper;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

import static net.minecraft.advancements.triggers.CriteriaTriggers.CONSUME_ITEM;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.item.Items.GLASS_BOTTLE;

public class ItemArcanaPotion extends ItemModFood {
    protected int amountToAdd;
    public ItemArcanaPotion(FoodProperties food, int amountToAdd, Properties properties) {
        super(false, food, properties.component(DataComponents.CONSUMABLE, Consumables.DEFAULT_DRINK).usingConvertsTo(GLASS_BOTTLE));
        this.amountToAdd = amountToAdd;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if(entity instanceof ServerPlayer player){
            CONSUME_ITEM.trigger(player, stack);
            player.awardStat(ITEM_USED.get(this));
            stack.consume(1, player);
        }
        if(!level.isClientSide()){
            if(ArcanaHelper.getArcana(entity) != 0) {
                ArcanaHelper.modifyAmount(entity, amountToAdd);
            }
            if(stack.isEmpty()) return new ItemStack(GLASS_BOTTLE);
            else if (entity instanceof Player player && !player.hasInfiniteMaterials()) {
                ItemStack glassBottle = new ItemStack(GLASS_BOTTLE);
                if(!player.getInventory().add(glassBottle)) player.drop(glassBottle, false);
            }
        } return stack;
    }

    @Override public ItemUseAnimation getUseAnimation(ItemStack itemStack) {return ItemUseAnimation.DRINK;}
    @Override public boolean isFoil(ItemStack itemStack) {return true;}

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.arcanaRegen(amountToAdd));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}
