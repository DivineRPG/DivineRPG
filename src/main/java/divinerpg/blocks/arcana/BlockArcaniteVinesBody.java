package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcaniteVinesBody extends WeepingVinesPlantBlock {
	public BlockArcaniteVinesBody(Properties properties) {super(properties);}
	@Override protected GrowingPlantHeadBlock getHeadBlock() {return (GrowingPlantHeadBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_head"));}
}
