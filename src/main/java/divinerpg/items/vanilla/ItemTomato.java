package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityTomato;
import divinerpg.items.base.ItemModFood;
import divinerpg.registries.EntityRegistry;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ItemTomato extends ItemModFood {

    public ItemTomato(FoodProperties food) {
        super(new Item.Properties().tab(DivineRPG.tabs.food).food(food), food);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.isCrouching()) {
            ItemStack itemstack = player.getItemInHand(hand);

            if (!player.isCreative()) {
                itemstack.shrink(1);
            }

            world.playSound(null, player.blockPosition(), SoundEvents.EGG_THROW, SoundSource.MASTER, 1, 1);

            if (!world.isClientSide) {
                EntityTomato bullet = new EntityTomato(EntityRegistry.TOMATO.get(), player, world);
                bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
                world.addFreshEntity(bullet);
            }

            return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, itemstack);
        }
        else {
            ItemStack itemstack = player.getItemInHand(hand);
            if (itemstack.isEdible()) {
                if (player.canEat(itemstack.getFoodProperties(player).canAlwaysEat())) {
                    player.startUsingItem(hand);
                    return InteractionResultHolder.consume(itemstack);
                } else {
                    return InteractionResultHolder.fail(itemstack);
                }
            } else {
                return InteractionResultHolder.pass(player.getItemInHand(hand));
            }
        }
    }
}
