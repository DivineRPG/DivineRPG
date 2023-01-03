package divinerpg.blocks.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.arcana.BlockArcaniteVinesHead;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockWinterberryVinesHead extends BlockArcaniteVinesHead {
	public BlockWinterberryVinesHead(Properties properties) {super(properties.lightLevel((state) -> 1).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));}
	@Override protected Block getBodyBlock() {return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_body"));}
}