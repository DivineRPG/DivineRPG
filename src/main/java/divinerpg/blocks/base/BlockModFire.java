package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockModFire extends FireBlock {
    public BlockModFire() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).randomTicks().noCollission().instabreak().lightLevel((state) -> {
            return 15;
        }).sound(SoundType.WOOL));
    }
    public void lightPortal(Level world, BlockPos pos) {
        BlockModPortal portalBlock;
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fire")) && world.getBlockState(pos.below()).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_rock"))){
            portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_portal"));
            portalBlock.makePortal(world, pos);
        }
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fire")) && world.getBlockState(pos.below()).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_block"))){
            portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_portal"));
            portalBlock.makePortal(world, pos);
        }
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fire")) && world.getBlockState(pos.below()).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_block"))){
            portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_portal"));
            portalBlock.makePortal(world, pos);
        }
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fire")) && world.getBlockState(pos.below()).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_block"))){
            portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_portal"));
            portalBlock.makePortal(world, pos);
        }
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fire")) && world.getBlockState(pos.below()).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_block"))){
            portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_portal"));
            portalBlock.makePortal(world, pos);
        }
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_fire")) && world.getBlockState(pos.below()).getBlock() == Blocks.SNOW_BLOCK){
            portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_portal"));
            portalBlock.makePortal(world, pos);
        }
    }
    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
    super.tick(state, worldIn, pos, rand);
        lightPortal(worldIn, pos);
    }
}