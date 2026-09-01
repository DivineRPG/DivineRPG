package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.DataComponentRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.*;
import java.util.List;
import java.util.function.Consumer;

public class ItemTeleportationStar extends ItemMod {
    public ItemTeleportationStar(Properties properties) {super(properties.stacksTo(1).durability(64));}
    @Override public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean hasInfo = stack.has(DataComponentRegistry.dimension) && stack.has(DataComponentRegistry.position);
        Component message;
        if(!world.isClientSide()) {
            if(player.isShiftKeyDown()) {
                stack.set(DataComponentRegistry.dimension, player.level().dimension().identifier());
                stack.set(DataComponentRegistry.position, player.blockPosition());
                message = LocalizeUtils.clientMessage("teleport.change_position");
                player.sendSystemMessage(message);
                return InteractionResult.SUCCESS;
            } if(hasInfo) {
                ServerLevel serverWorld = world.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, stack.get(DataComponentRegistry.dimension)));
                if(player instanceof ServerPlayer) {
                    BlockPos pos = stack.get(DataComponentRegistry.position);
                    //TODO - change dimension/transition
//                    player.changeDimension(new DimensionTransition(serverWorld, new Vec3(pos.getX(), pos.getY(), pos.getZ()).add(.5, 0, .5), player.getDeltaMovement(), player.getYRot(), player.getXRot(), false, DimensionTransition.PLAY_PORTAL_SOUND));
                    if(!player.isCreative()) stack.hurtAndBreak(1, player, hand);
                    player.getCooldowns().addCooldown(stack, 160);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResult.SUCCESS;
                }
            } else {
                message = LocalizeUtils.clientMessage(ChatFormatting.RED, "teleport.no_position");
                player.sendSystemMessage(message);
                return InteractionResult.FAIL;
            }
        } return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        if(stack.has(DataComponentRegistry.dimension)) builder.accept(LocalizeUtils.i18n(ChatFormatting.WHITE, "teleport.dimension", stack.get(DataComponentRegistry.dimension).toString()));
        if(stack.has(DataComponentRegistry.position)) {
            BlockPos pos = stack.get(DataComponentRegistry.position);
            builder.accept(LocalizeUtils.i18n(ChatFormatting.WHITE, "teleport.block_position", pos.getX(), pos.getY(), pos.getZ()));
        } super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        itemEntity.level().playSound(null, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), SoundEvents.ENDER_EYE_DEATH, SoundSource.NEUTRAL);
    }
}