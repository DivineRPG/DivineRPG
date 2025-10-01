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
    //TODO: crashes the game in debug world (cannot set property IntegerProperty{name=level, clazz=class java.lang.Integer, values=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]} to -2147483648 on Block{divinerpg:eden_rift}, it is not an allowed value)
    public IslandRiftBlock(ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        super(rootDimension, chainDimension, resonanceTag, empowerTag, variant);
    }
    @Override public BlockPos applyLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
        return level.dimension() == rootDimension
                ? new BlockPos(pos.getX(), Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, 127, 250, 0, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ())
                : super.applyLocationPreference(level, entity, pos);
    }
}