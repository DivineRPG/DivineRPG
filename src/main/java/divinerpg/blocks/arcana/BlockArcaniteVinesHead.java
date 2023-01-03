package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcaniteVinesHead extends WeepingVinesBlock {
	protected static final VoxelShape SHAPE = Block.box(1., 5., 1., 15., 16., 15.);
	public BlockArcaniteVinesHead(Properties properties) {super(properties);}
	@Override protected Block getBodyBlock() {return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_body"));}
	@Override protected boolean canGrowInto(BlockState state) {return state.isAir();}
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
}