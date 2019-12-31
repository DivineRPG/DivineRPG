package divinerpg.objects.blocks.vethea;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.blocks.BlockModLog;
import divinerpg.objects.entities.entity.vethea.EntityEnt;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockVetheaLog extends BlockModLog {

    private Random random;

    public BlockVetheaLog(String name, @Nonnull MapColor mapColorIn) {
        super(name, mapColorIn);
        this.random = new Random();
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            if (random.nextInt(5) == 0) {
                EntityLiving ent = new EntityEnt(worldIn);
                ent.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
                worldIn.spawnEntity(ent);
            }
        }
    }
}
