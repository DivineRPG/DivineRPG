package divinerpg.items.vanilla;

import divinerpg.entities.projectile.EntityTomato;
import divinerpg.items.base.ItemModFood;
import divinerpg.registries.EntityRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemTomato extends ItemModFood {

    public ItemTomato(FoodProperties food) {
        super(new Item.Properties().food(food), food);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (player.isShiftKeyDown()) {

            if (!player.isCreative()) {
                itemstack.shrink(1);
            }

            world.playSound(null, player.blockPosition(), SoundEvents.EGG_THROW, SoundSource.NEUTRAL, 1, 1);

            if (!world.isClientSide) {
                EntityTomato bullet = new EntityTomato(EntityRegistry.TOMATO.get(), player, world);
                bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
                world.addFreshEntity(bullet);
            }

            return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, itemstack);
        }
        else {
            if (player.canEat(itemstack.getFoodProperties(player).canAlwaysEat())) {
                player.startUsingItem(hand);
                return InteractionResultHolder.consume(itemstack);
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
    }
}