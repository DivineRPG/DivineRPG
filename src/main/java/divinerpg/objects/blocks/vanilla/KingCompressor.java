package divinerpg.objects.blocks.vanilla;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.objects.blocks.tile.entity.TileEntityKingCompressior;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class KingCompressor extends BlockContainer {
    public KingCompressor(String name, boolean isBurning) {
        super(Material.ROCK, MapColor.BLACK);

        setRegistryName(Reference.MODID, name);
        setUnlocalizedName(name);

        if (isBurning)
            setLightLevel(0.8F);
        else
            setCreativeTab(DivineRPGTabs.BlocksTab);

        setHardness(3.5F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            TileEntity entity = worldIn.getTileEntity(pos);

            if (entity instanceof TileEntityKingCompressior)
                playerIn.openGui(DivineRPG.instance, GUIHandler.KingCompressorGuiId, worldIn, pos.getX(), pos.getY(), pos.getZ());

        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityKingCompressior();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);

        if (tileEntity instanceof TileEntityKingCompressior && !((TileEntityKingCompressior) tileEntity).keepInventory)
            InventoryHelper.dropInventoryItems(worldIn, pos, ((IInventory) tileEntity));

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
