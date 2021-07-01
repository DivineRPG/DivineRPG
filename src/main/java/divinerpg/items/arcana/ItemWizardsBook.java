package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.entities.boss.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class ItemWizardsBook extends ItemMod {
    public ItemWizardsBook() {
        super("wizards_book", new Properties().tab(DivineRPG.tabs.spawners).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        if (!world.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            Block block = world.getBlockState(pos).getBlock();
            double spawnX = pos.getX();
            double spawnY = pos.above().getY();
            double spawnZ = pos.getZ();

            if (block == BlockRegistry.parasectaAltar) {
                EntityParasecta parasecta = new EntityParasecta(EntityRegistry.PARASECTA, world);
                parasecta.moveTo(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
                world.addFreshEntity(parasecta);
                if (!player.isCreative())
                    stack.shrink(1);
                return ActionResultType.PASS;
            }

            if (block == BlockRegistry.dramixAltar) {
                EntityDramix dramix = new EntityDramix(EntityRegistry.DRAMIX, world);
                dramix.moveTo(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
                world.addFreshEntity(dramix);
                if (!player.isCreative())
                    stack.shrink(1);
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.FAIL;
    }

}
