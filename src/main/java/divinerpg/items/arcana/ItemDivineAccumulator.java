package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
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

public class ItemDivineAccumulator extends ItemMod {
    public ItemDivineAccumulator() {
        super("divine_accumulator", new Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).isPresent()) {
            int x = (int) player.xo, y = (int) player.yo, z = (int) player.zo;
            Arcana arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElseThrow(RuntimeException::new);
            if (arcana.getArcana() >= 80) {
                if (!world.isClientSide) {
                    //NetworkingRegistry.INSTANCE.sendToServer(new PacketDivineAccumulator(x, y, z));
                    world.playSound(player, player.blockPosition(), SoundRegistry.DIVINE_ACCUMULATOR, SoundCategory.PLAYERS, 1, 1);
                    arcana.consume(player, 80);
                }
                player.setDeltaMovement(player.getDeltaMovement().x, 2, player.getDeltaMovement().z);
            }
        }
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, player.getMainHandItem());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.launch"));
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.fall"));
        list.add(LocalizeUtils.arcanaConsumed(80));
        list.add(LocalizeUtils.infiniteUses());
    }
}
