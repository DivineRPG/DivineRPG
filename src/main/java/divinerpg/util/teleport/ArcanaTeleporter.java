package divinerpg.util.teleport;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.BlockUtil;
import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class ArcanaTeleporter extends DivineTeleporter {
	public final StructureTemplate repairedPortal;
	public ArcanaTeleporter(ServerLevel level, StructureTemplate repairedPortal) {
		super(level, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_portal_frame")), true, PointOfInterestRegistry.ARCANA_PORTAL.getKey());
		this.repairedPortal = repairedPortal;
	}
	@Override public boolean isVanilla() {return false;}
	@Override @Nullable
	public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
		entity.setPortalCooldown();
		BlockPos position = destWorld.dimension() == Level.OVERWORLD ? null : destWorld.findNearestMapStructure(StructureTags.RUINED_PORTAL, new BlockPos(entity.getBlockX() / 16, entity.getBlockY(), entity.getBlockZ() / 16), 28, false);
		if(position == null) return super.getPortalInfo(entity, destWorld, defaultPortalInfo);
		return repairRuinedPortal(destWorld, new BlockPos(position.getX(), getHeight(destWorld, position.getX(), position.getZ()), position.getZ()), entity);
	}
	protected PortalInfo repairRuinedPortal(ServerLevel level, BlockPos position, Entity entity) {
		BlockPos pos = position.above();
		if(checkForRuinedPortalBlocks(level, pos)) {
			position = getCorner(level, pos);
			repairedPortal.placeInWorld(level, position, position, new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setKeepLiquids(true), level.random, 2);
		} else while(!isNatural(level.getBlockState(position))) position = position.offset(-1, 0, -1);
		return new PortalInfo(new Vec3(position.getX() + 4, position.getY(), position.getZ() + 4), entity.getDeltaMovement(), entity.yRot, entity.xRot);
	}
	protected BlockPos getCorner(ServerLevel level, BlockPos pos) {
		loop: for(int x = -2; x < 3; x++) for(int z = -2; z < 3; z++) if(level.getBlockState(pos.offset(x, 0, z)).is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_brick_slab")))) {
			pos = pos.offset(x, 0, z);
			break loop;
		}
		return pos.offset(isNatural(level.getBlockState(pos.offset(-1, 0, 0))) ? 0 : -6, 0, isNatural(level.getBlockState(pos.offset(0, 0, -1))) ? 0 : -6).below();
	}
	protected boolean checkForRuinedPortalBlocks(ServerLevel level, BlockPos pos) {
		BlockState block = level.getBlockState(pos);
		Block indicator = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "light_degraded_brick"));
		if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_brick_slab")))) return true;
		if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_brick_stairs")))) return level.getBlockState(pos.offset(2, 0, 0)).is(indicator) || level.getBlockState(pos.offset(0, 0, 2)).is(indicator) || level.getBlockState(pos.offset(-2, 0, 0)).is(indicator) || level.getBlockState(pos.offset(0, 0, -2)).is(indicator);
		if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_metal")))) return level.getBlockState(pos.offset(1, 0, 0)).is(indicator) || level.getBlockState(pos.offset(0, 0, 1)).is(indicator) || level.getBlockState(pos.offset(-1, 0, 0)).is(indicator) || level.getBlockState(pos.offset(0, 0, -1)).is(indicator);
		if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_tile")))) return level.getBlockState(pos.offset(1, 0, 1)).is(indicator) || level.getBlockState(pos.offset(-1, 0, 1)).is(indicator) || level.getBlockState(pos.offset(-1, 0, -1)).is(indicator) || level.getBlockState(pos.offset(1, 0, -1)).is(indicator);
		return block.isAir() || block.is(indicator);
	}
	public boolean isNatural(BlockState state) {
		return state.isAir() || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_sand"))) || state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_stone")));
	}
	@Override
	public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
		currentWorld.getProfiler().popPush("reloading");
        Entity createdEntity = entity.getType().create(destWorld);
        if (createdEntity != null) {
        	createdEntity.restoreFrom(entity);
        	PortalInfo portalinfo = getPortalInfo(entity, destWorld, null);
        	createdEntity.setPortalCooldown();
        	createdEntity.moveTo(portalinfo.pos.x - 2, portalinfo.pos.y + 2, portalinfo.pos.z - 2, portalinfo.yRot, entity.getXRot());
        	createdEntity.setDeltaMovement(portalinfo.speed);
           destWorld.addDuringTeleport(createdEntity);
           return createdEntity;
        } else {
        	createdEntity = super.placeEntity(entity, currentWorld, destWorld, yaw, repositionEntity);
        	createdEntity.moveTo(createdEntity.getX() - 2, createdEntity.getY() + 2, createdEntity.getZ() - 2);
        	return createdEntity;
        }
	}
	@Override
	public Optional<FoundRectangle> makePortal(BlockPos pos, Axis axis) {
		pos = new BlockPos(pos.getX(), getHeight(world, pos.getX(), pos.getZ()), pos.getZ());
		for(int x = -2; x < 3; x++) for(int z = -2; z < 3; z++) {
			if(Math.abs(x) < 2 && Math.abs(z) < 2) world.setBlock(pos.offset(x, 0, z), portal.defaultBlockState(), 3);
			else if(Math.abs(z) < 2) {
				if(x == -2) world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.EAST), 3);
				else if(x == 2) world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.WEST), 3);
			} else if(Math.abs(x) < 2) {
				if(z == -2) world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.SOUTH), 3);
				else world.setBlock(pos.offset(x, 0, z), frame.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH), 3);
			}
		}
		return Optional.of(new BlockUtil.FoundRectangle(pos, 3, 3));
	}
	protected int getHeight(ServerLevel level, int posX, int posZ) {
		for(int y = level.getHeight(); y > 32; y--) {
			BlockState block = level.getBlockState(new BlockPos(posX, y, posZ));
			if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_sand")))) return y;
			if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_stone")))) return ++y;
		}
		return level.getHeight(Types.MOTION_BLOCKING, posX, posZ);
	}
}