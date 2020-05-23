package divinerpg.objects.blocks.iceika;

import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.enums.ParticleType;
import divinerpg.objects.blocks.BlockModChest;
import divinerpg.objects.blocks.tile.entity.TileEntityFrostedChest;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.TriggerRegistry;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFrostedChest extends BlockModChest {

    public BlockFrostedChest(String name) {
        super(name, Material.GLASS);
        setSoundType(SoundType.GLASS);
    }

    public int getGuiID() {
        return GUIHandler.FROSTED_CHEST_GUI_ID;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityFrostedChest();
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te,
            ItemStack stack) {
        super.harvestBlock(world, player, pos, state, te, stack);
        if (player instanceof EntityPlayerMP) {
            TriggerRegistry.DIVINERPG_BLOCK.trigger((EntityPlayerMP) player, this);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Random random = worldIn.rand;
        for (int i = 0; i < 6; ++i) {
            double d1 = pos.getX() + random.nextFloat();
            double d2 = pos.getY() + random.nextFloat();
            double d3 = pos.getZ() + random.nextFloat();

            if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
                d2 = pos.getY() + 0.0625D + 1.0D;
            }

            if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
                d2 = pos.getY() - 0.0625D;
            }

            if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
                d3 = pos.getZ() + 0.0625D + 1.0D;
            }

            if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
                d3 = pos.getZ() - 0.0625D;
            }

            if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
                d1 = pos.getX() + 0.0625D + 1.0D;
            }

            if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
                d1 = pos.getX() - 0.0625D;
            }

            if (d1 < pos.getX() || d1 > pos.getX() + 1 || d2 < 0.0D || d2 > pos.getY() + 1 || d3 < pos.getZ()
                    || d3 > pos.getZ() + 1) {
                if (rand.nextInt(10) <= 5) {
                    DivineRPG.proxy.spawnParticle(worldIn, ParticleType.FROST, d1, d2, d3, 0.0D, 0.5D, 0.0D);
                }
            }
        }
    }
}
