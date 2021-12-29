package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockModFire extends FireBlock {

    public BlockModFire(String name) {
        super(AbstractBlock.Properties.of(Material.FIRE).randomTicks().noCollission().instabreak().noDrops().lightLevel((p_235468_0_) -> {
            return 15;
        }).sound(SoundType.WOOL));
        this.setRegistryName(DivineRPG.MODID, name);
    }

    public void lightPortal(World world, BlockPos pos) {
        if(this == BlockRegistry.blueFire && world.getBlockState(pos.below()).getBlock() == BlockRegistry.divineRock){
            BlockRegistry.edenPortal.makePortal(world, pos);
        }
        if(this == BlockRegistry.blueFire && world.getBlockState(pos.below()).getBlock() == BlockRegistry.edenBlock){
            BlockRegistry.wildwoodPortal.makePortal(world, pos);
        }
        if(this == BlockRegistry.blueFire && world.getBlockState(pos.below()).getBlock() == BlockRegistry.wildwoodBlock){
            BlockRegistry.apalachiaPortal.makePortal(world, pos);
        }
        if(this == BlockRegistry.blueFire && world.getBlockState(pos.below()).getBlock() == BlockRegistry.apalachiaBlock){
            BlockRegistry.skythernPortal.makePortal(world, pos);
        }
        if(this == BlockRegistry.blueFire && world.getBlockState(pos.below()).getBlock() == BlockRegistry.skythernBlock){
            BlockRegistry.mortumPortal.makePortal(world, pos);
        }
        if(this == BlockRegistry.iceikaFire && world.getBlockState(pos.below()).getBlock() == Blocks.SNOW_BLOCK){
            BlockRegistry.iceikaPortal.makePortal(world, pos);
        }
    }



    @Override
    public void onPlace(BlockState state, World world, BlockPos pos, BlockState state1, boolean b) {
        lightPortal(world, pos);
        }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
    super.tick(state, worldIn, pos, rand);
        lightPortal(worldIn, pos);
    }

}