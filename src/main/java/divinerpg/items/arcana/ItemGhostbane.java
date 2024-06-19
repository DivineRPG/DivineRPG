package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.enums.EntityStats;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemGhostbane extends ItemMod {
    public ItemGhostbane() {
        super(new Properties().stacksTo(1));
        arcanaConsumedUse = 200;
        cooldown = 60;
    }
    @Override
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand) {
    	if(level instanceof ServerLevel) EntityRegistry.WRAITH.get().spawn((ServerLevel)level, ItemStack.EMPTY, player, player.blockPosition(), MobSpawnType.MOB_SUMMONED, true, false).tame(player);
    	return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    @Override public InteractionResult useOn(UseOnContext context) {
    	Player player = context.getPlayer();
    	if(player instanceof ServerPlayer) return context.getPlayer().getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcanaConsumedUse != 0 && arcana.getAmount(false) >= arcanaConsumedUse) {
                arcana.modifyAmount(player, -arcanaConsumedUse);
                player.getCooldowns().addCooldown(this, cooldown);
                BlockPos pos = context.getClickedPos();
                if(!context.getLevel().getBlockState(pos).getCollisionShape(context.getLevel(), pos).isEmpty()) pos = pos.relative(context.getClickedFace());
            	EntityRegistry.WRAITH.get().spawn((ServerLevel)context.getLevel(), ItemStack.EMPTY, player, context.getClickedPos(), MobSpawnType.MOB_SUMMONED, true, false).tame(player);
                return InteractionResult.SUCCESS;
            } return InteractionResult.PASS;
        }).orElse(InteractionResult.PASS);
    	return InteractionResult.PASS;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.summoned(EntityRegistry.WRAITH.get()));
        tooltip.add(LocalizeUtils.summonedDamage((int)EntityStats.WRAITH.getAttackDamage()));
        tooltip.add(LocalizeUtils.summonedHealth((int)EntityStats.WRAITH.getHealth()));
        tooltip.add(LocalizeUtils.summonedDespawn());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}