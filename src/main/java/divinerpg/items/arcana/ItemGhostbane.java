package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.entities.arcana.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemGhostbane extends ItemMod {
    public ItemGhostbane() {
        super("ghostbane", new Item.Properties().tab(DivineRPG.tabs.spawners).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        PlayerEntity player = context.getPlayer();
        IArcana arcana = ArcanaProvider.ARCANA_CAP.getDefaultInstance();
            if (!world.isClientSide && arcana.getArcana() >= 200) {
                EntityWraith wraith = new EntityWraith(EntityRegistry.WRAITH, world, player);
                wraith.moveTo(context.getClickedPos().above(), 0.0F, 0.0F);
                world.addFreshEntity(wraith);
                arcana.consume(player, 200);
                return ActionResultType.PASS;
            }
        return ActionResultType.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.arcanaConsumed(200));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.spawn"));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.damage"));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.health"));
        list.add(LocalizeUtils.i18n("tooltip.ghostbane.despawn"));
    }
}
