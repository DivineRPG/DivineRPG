package divinerpg.items.arcana;

import divinerpg.entities.arcana.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class ItemChargedCollector extends ItemMod {

    public ItemChargedCollector(String name) {
        super(name);
    }

    @Override
    public ActionResultType useOn(ItemUseContext ctx) {
        World world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Hand hand = ctx.getHand();
        PlayerEntity player = ctx.getPlayer();

        if (!world.isClientSide) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == BlockRegistry.dramixAltar) {
                ItemStack stack = player.getItemInHand(hand);
                int x = pos.getX(), y = pos.getY(), z = pos.getZ();
                EntityDungeonConstructor con = new EntityDungeonConstructor(EntityRegistry.DUNGEON_CONSTRUCTOR, world);
                con.moveTo(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
                world.addFreshEntity(con);
                if (!player.isCreative())
                    stack.shrink(1);
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.FAIL;
    }
}