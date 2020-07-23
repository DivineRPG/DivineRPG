package divinerpg.objects.blocks.twilight;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BlockBrambles extends BlockModDoublePlant {

    public BlockBrambles(String name, Supplier<Block> grassSupplier, MapColor mapColorIn) {
        super(name, grassSupplier, mapColorIn);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity) {
        if (entity instanceof EntityPlayer)
            entity.attackEntityFrom(DamageSource.CACTUS, 6);
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
            @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
        player.attackEntityFrom(DamageSource.CACTUS, 1);
    }
}
