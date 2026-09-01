package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import divinerpg.utils.ArcanaHelper;
import divinerpg.utils.EntityStats;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ItemGhostbane extends ItemMod {
    public ItemGhostbane(Properties properties) {
        super(properties.stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
        arcanaConsumedUse = 200;
        cooldown = 60;
    }

    @Override
    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        if(level instanceof ServerLevel) EntityRegistry.WRAITH.get().spawn((ServerLevel) level, ItemStack.EMPTY, player, player.blockPosition(), EntitySpawnReason.MOB_SUMMONED, true, false).tame(player);
        return InteractionResult.SUCCESS;
    }
    @Override public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() instanceof ServerPlayer pl) {
            float amount = ArcanaHelper.getArcana(pl);
            if(arcanaConsumedUse != 0 && amount >= arcanaConsumedUse) {
                ArcanaHelper.modifyAmount(pl, -arcanaConsumedUse);
                pl.getCooldowns().addCooldown(context.getItemInHand(), cooldown);
                BlockPos pos = context.getClickedPos();
                if(!context.getLevel().getBlockState(pos).getCollisionShape(context.getLevel(), pos).isEmpty()) pos = pos.relative(context.getClickedFace());
                EntityRegistry.WRAITH.get().spawn((ServerLevel)context.getLevel(), ItemStack.EMPTY, pl, pos, EntitySpawnReason.MOB_SUMMONED, true, false).tame(pl);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.summoned(EntityRegistry.WRAITH.get()));
        builder.accept(LocalizeUtils.summonedDamage((int) EntityStats.WRAITH.getAttackDamage()));
        builder.accept(LocalizeUtils.summonedHealth((int)EntityStats.WRAITH.getHealth()));
        builder.accept(LocalizeUtils.summonedDespawn());
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}