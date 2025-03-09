package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockModRift;
import divinerpg.world.placement.Surface;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class IslandRiftBlock extends BlockModRift {
    public IslandRiftBlock(ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        super(rootDimension, chainDimension, resonanceTag, empowerTag, variant);
    }
    @Override
    public BlockPos applyLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
        return level.dimension() == rootDimension
                ? new BlockPos(pos.getX(), Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, 127, 250, 0, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ())
                : super.applyLocationPreference(level, entity, pos);
    }
}
