package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.entities.arcana.EntityWraith;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGhostbane extends ItemMod {
    public ItemGhostbane() {
        super(new Item.Properties().tab(DivineRPG.tabs.spawners).stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if (arcana.getArcana() >= 200 && !world.isClientSide) {
                new EntityWraith(EntityRegistry.WRAITH.get(), world, player).getType().spawn((ServerLevel) world, null, null, context.getClickedPos(), MobSpawnType.MOB_SUMMONED, true, false);
                arcana.consume(player, 200);
            }
        });
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        list.add(LocalizeUtils.arcanaConsumed(200));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.spawn"));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.damage"));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.health"));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.despawn"));
    }
}
