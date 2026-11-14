package divinerpg.blocks.arcana;

import divinerpg.registries.BlockRegistry;
import net.minecraft.world.level.block.*;

public class ArcaniteVinesBody extends WeepingVinesPlantBlock {
    public ArcaniteVinesBody(Properties p) {super(p);}
    @Override protected GrowingPlantHeadBlock getHeadBlock() {return (GrowingPlantHeadBlock) BlockRegistry.arcaniteVinesHead.get();}
}