package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;

public class BlockModVine extends BlockVine {

    public BlockModVine(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.setCreativeTab(DivineRPGTabs.BLOCKS);
        this.setHardness(2);
        this.setSoundType(SoundType.PLANT);
        this.setDefaultState(this.blockState.getBaseState().withProperty(UP, Boolean.valueOf(false))
                .withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false))
                .withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
        this.setTickRandomly(true);
    }
}