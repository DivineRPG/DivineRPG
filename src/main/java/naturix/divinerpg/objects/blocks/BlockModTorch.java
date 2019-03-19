package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModTorch extends BlockTorch implements IHasModel {
    private String particle;

    public BlockModTorch(String name, String particle) {
        super();
        this.setCreativeTab(DivineRPG.BlocksTab);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setLightLevel(1);
        this.setHardness(0.0F);
        this.particle = particle;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (this.particle != null) {
            EnumFacing enumfacing = (EnumFacing) stateIn.getValue(FACING);
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.7D;
            double d2 = (double) pos.getZ() + 0.5D;
            double d3 = 0.22D;
            double d4 = 0.27D;

            if (enumfacing.getAxis().isHorizontal()) {
                EnumFacing enumfacing1 = enumfacing.getOpposite();
                //worldIn.spawnParticle(this.particle, d0 + 0.27D * (double)enumfacing1.getFrontOffsetX(), d1 + 0.22D, d2 + 0.27D * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D);
            } else {
                //worldIn.spawnParticle(this.particle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}