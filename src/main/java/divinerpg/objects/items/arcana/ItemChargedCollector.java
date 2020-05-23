package divinerpg.objects.items.arcana;

import divinerpg.objects.entities.entity.arcana.EntityDungeonConstructor;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemChargedCollector extends ItemMod {

    public ItemChargedCollector(String name) {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == BlockRegistry.dramixAltar) {
                ItemStack stack = player.getHeldItem(hand);
                int x = pos.getX(), y = pos.getY(), z = pos.getZ();
                EntityDungeonConstructor con = new EntityDungeonConstructor(world);
                con.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
                world.spawnEntity(con);
                if (!player.capabilities.isCreativeMode)
                    stack.shrink(1);
                return EnumActionResult.PASS;
            }
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}