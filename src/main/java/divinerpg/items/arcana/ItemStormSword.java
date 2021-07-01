package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.items.base.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class ItemStormSword extends ItemModSword {

    public ItemStormSword(String name, IItemTier toolMaterial) {
        super(name, toolMaterial, DivineRPG.tabs.melee);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP).orElse(null);
        if (arcana.getArcana() >= 20) {
            arcana.consume(player, 20);
            for (int i = 2; i < 5; i += 2) {
                double angle = 0;
                while (angle < 2 * Math.PI) {
                    int xOffset = (int) Math.round(Math.sin(angle) * i);
                    int zOffset = (int) Math.round(Math.cos(angle) * i);
                    if (Math.sqrt(xOffset * xOffset + zOffset * zOffset) > 3) {
                        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                        bolt.moveTo(player.xo + xOffset, player.yo, player.zo + zOffset);
                        world.addFreshEntity(bolt);
                        angle += Math.PI / 8.0D;
                    }
                }
            }
        }

        return super.use(world, player, hand);
    }

}
