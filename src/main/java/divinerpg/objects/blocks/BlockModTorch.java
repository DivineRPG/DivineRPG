package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.enums.ParticleType;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModTorch extends BlockTorch  {
    private ParticleType flameParticle;

    public BlockModTorch(String name, ParticleType particle) {
        super();
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        setUnlocalizedName(name);
        setRegistryName(Reference.MODID, name);
        this.setLightLevel(1);
        this.setHardness(0.0F);
        this.flameParticle = particle;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        EnumFacing enumfacing = (EnumFacing) stateIn.getValue(FACING);
        double d0 = (double) pos.getX() + 0.5D;
        double d1 = (double) pos.getY() + 0.7D;
        double d2 = (double) pos.getZ() + 0.5D;

        if (enumfacing.getAxis().isHorizontal()) {
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            d0 = d0 + 0.27D * (double) enumfacing1.getFrontOffsetX();
            d1 = d1 + 0.22D;
            d2 = d2 + 0.27D * (double) enumfacing1.getFrontOffsetZ();
        }
        DivineRPG.proxy.spawnParticle(worldIn, flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}