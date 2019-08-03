package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import naturix.divinerpg.objects.entities.entity.arcana.Parasecta;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemWizardsBook extends ItemMod {

    public ItemWizardsBook(String name) {
        super(name, DivineRPGTabs.spawner);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack stack = player.getHeldItem(hand);
            Block block = world.getBlockState(pos).getBlock();
            RayTraceResult rtr = player.rayTrace(4, 1);
            double spawnX = rtr.getBlockPos().getX() + 0.5F;
            double spawnY = rtr.getBlockPos().getY() + 1;
            double spawnZ = rtr.getBlockPos().getZ() + 0.5F;

            if (block == ModBlocks.parasectaAltar) {
                Parasecta parasecta = new Parasecta(world);
                parasecta.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
                world.spawnEntity(parasecta);
                if (!player.capabilities.isCreativeMode)
                    stack.shrink(1);
                return EnumActionResult.PASS;
            }

            if (block == ModBlocks.dramixAltar) {
                Dramix dramix = new Dramix(world);
                dramix.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
                world.spawnEntity(dramix);
                if (!player.capabilities.isCreativeMode)
                    stack.shrink(1);
                return EnumActionResult.PASS;
            }
        }
        return EnumActionResult.FAIL;
    }
}