package divinerpg.objects.blocks.vethea;

import divinerpg.objects.blocks.BlockModLog;
import divinerpg.objects.entities.entity.vethea.Ent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockVetheaLog extends BlockModLog {

    private Random rand = new Random();
    
    public BlockVetheaLog(String name) {
        super(name);
//        setCreativeTab(DivineRPGTabs.vethea);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World w, BlockPos pos, IBlockState state)
    {    super.onBlockDestroyedByPlayer(w, pos, state);
        if(!w.isRemote && this.rand.nextInt(5)==0) {
            Ent e = new Ent(w);
            e.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
            w.spawnEntity(e);
        }
    }

}