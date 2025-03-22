package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.SimplePortalBlock;
import divinerpg.registries.*;
import divinerpg.world.placement.Surface;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class SkythernPortal extends SimplePortalBlock {
    public SkythernPortal() {
        super(LevelRegistry.SKYTHERN, LevelRegistry.APALACHIA, BlockRegistry.skythernBlock.get(), ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "skythern_portal"));
    }
    @Override
    public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
        return level.dimension() == LevelRegistry.APALACHIA
                ? new BlockPos(pos.getX(), Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, 127, 250, 1, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ())
                : super.applyPlacementLocationPreference(level, entity, pos);
    }
}