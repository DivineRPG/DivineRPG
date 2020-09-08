package divinerpg.objects.blocks.vethea;

import divinerpg.objects.blocks.BlockModUnbreakable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockVetheaAltar extends BlockModUnbreakable {

    protected BlockVetheaAltar(String name) {
        super(name);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack heldItemStack = playerIn.getHeldItem(EnumHand.MAIN_HAND);

        if(!worldIn.isRemote && heldItemStack != null && heldItemStack.getItem() == acceptedItem()) {
            if (!playerIn.capabilities.isCreativeMode) {
                heldItemStack.shrink(1);
            }
            spawnBoss(worldIn, pos);
        }
        else {
            onFailure();
        }

        return true;
    }

    private void spawnBoss(World worldIn, BlockPos pos) {
        EntityLiving boss = this.getBoss(worldIn);
        boss.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
        worldIn.spawnEntity(boss);
    }

    protected abstract Item acceptedItem();
    protected abstract EntityLiving getBoss(World world);
    protected abstract void onFailure();

}
