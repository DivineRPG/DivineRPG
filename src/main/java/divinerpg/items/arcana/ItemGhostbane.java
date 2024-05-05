package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.entities.arcana.EntityWraith;
import divinerpg.enums.EntityStats;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedUse && !level.isClientSide) new EntityWraith(EntityRegistry.WRAITH.get(), level, player).getType().spawn((ServerLevel)level, ItemStack.EMPTY, null, player.blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
        }); return super.use(level, player, hand);
    }
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos(), pos1;
        Level level = context.getLevel();
        if(level.getBlockState(pos).getCollisionShape(level, pos).isEmpty()) pos1 = pos;
        else pos1 = pos.relative(context.getClickedFace());
        Player player = context.getPlayer();
        return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedUse) {
                arcana.consume(player, arcanaConsumedUse);
                player.getCooldowns().addCooldown(this, cooldown);
                if(!level.isClientSide) new EntityWraith(EntityRegistry.WRAITH.get(), level, player).getType().spawn((ServerLevel)level, ItemStack.EMPTY, null, pos1, MobSpawnType.MOB_SUMMONED, true, false);
                return InteractionResult.SUCCESS;
            } return InteractionResult.FAIL;
        }).orElse(super.useOn(context));
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