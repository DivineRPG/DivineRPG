package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModUnbreakable;
import divinerpg.util.DamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockKarosHeatTile extends BlockModUnbreakable {
    private static final AABB KAROS_HEAT_TILE_AABB = new AABB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D,
            0.9375D);

    public BlockKarosHeatTile(MaterialColor color) {
        super(BlockBehaviour.Properties.of(Material.STONE, color).randomTicks().strength(-1F, 3600000F));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_220071_4_) {
        return Shapes.create(KAROS_HEAT_TILE_AABB);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return Shapes.create(KAROS_HEAT_TILE_AABB);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karos_heat_tile_red"))) {
            world.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karos_heat_tile_green")).defaultBlockState(), 0);
        }
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entityIn) {
        if (this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karos_heat_tile_red")) && entityIn instanceof ServerPlayer) {
            entityIn.hurt(DamageSources.source(world, DamageSources.TRAP), 6);
            entityIn.setSecondsOnFire(5);
        }
    }
}