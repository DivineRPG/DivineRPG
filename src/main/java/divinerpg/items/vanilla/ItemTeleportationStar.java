package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.DataComponentRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemTeleportationStar extends ItemMod {
    public ItemTeleportationStar() {super(new Properties().durability(64));}
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean hasInfo = stack.has(DataComponentRegistry.dimension) && stack.has(DataComponentRegistry.position);
        Component message;
        if(!world.isClientSide) {
            if(player.isShiftKeyDown()) {
            	stack.set(DataComponentRegistry.dimension, player.level().dimension().location());
                stack.set(DataComponentRegistry.position, player.blockPosition());
                message = LocalizeUtils.clientMessage(ChatFormatting.RED, "teleport.change_position");
                player.displayClientMessage(message, true);
                return InteractionResultHolder.success(stack);
            } if(hasInfo) {
            	ServerLevel serverWorld = world.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, stack.get(DataComponentRegistry.dimension)));
                if(player instanceof ServerPlayer) {
                	BlockPos pos = stack.get(DataComponentRegistry.position);
                    player.changeDimension(new DimensionTransition(serverWorld, new Vec3(pos.getX(), pos.getY(), pos.getZ()), player.getDeltaMovement(), player.getXRot(), player.getYRot(), false, DimensionTransition.DO_NOTHING));
                    if(!player.isCreative()) stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                    player.getCooldowns().addCooldown(this, 160);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.success(stack);
                }
            } else {
                message = LocalizeUtils.clientMessage(ChatFormatting.RED, "teleport.no_position");
                player.displayClientMessage(message, true);
                return InteractionResultHolder.fail(stack);
            }
        } return super.use(world, player, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        if(stack.has(DataComponentRegistry.dimension)) tooltip.add(LocalizeUtils.i18n(ChatFormatting.WHITE, "teleport.dimension", stack.get(DataComponentRegistry.dimension).toString()));
        if(stack.has(DataComponentRegistry.position)) {
            BlockPos pos = stack.get(DataComponentRegistry.position);
            tooltip.add(LocalizeUtils.i18n(ChatFormatting.WHITE, "teleport.block_position", pos.getX(), pos.getY(), pos.getZ()));
        } super.appendHoverText(stack, context, tooltip, flagIn);
    }
}