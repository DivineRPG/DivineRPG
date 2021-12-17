package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import divinerpg.util.teleport.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemTeleportationCrystal extends ItemMod {

    public ItemTeleportationCrystal() {
        super("teleportation_crystal", new Item.Properties().durability(10).tab(DivineRPG.tabs.utilities));
    }

    public ItemTeleportationCrystal(String name, int durability) {
        super(name, new Item.Properties().durability(durability).tab(DivineRPG.tabs.utilities));
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.teleport_bed_spawn"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }



    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            if (player instanceof ServerPlayerEntity) {
                player.changeDimension(world.getServer().getLevel(World.OVERWORLD), new SecondaryTeleporter(world.getServer().getLevel(World.OVERWORLD)));
                if (!player.isCreative()) {
                    player.getUseItem().hurtAndBreak(1, player, (stage) -> {
                        stage.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                    });
                }
                return ActionResult.success(player.getItemInHand(hand));
            }
        }
            return ActionResult.fail(player.getItemInHand(hand));
    }
}
