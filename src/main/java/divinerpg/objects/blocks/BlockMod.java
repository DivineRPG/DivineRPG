package divinerpg.objects.blocks;

import divinerpg.api.Reference;
import divinerpg.enums.EnumBlockType;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMod extends Block  {

    public BlockMod(String name, float hardness) {
        this(EnumBlockType.ROCK, name, hardness);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness) {
        this(blockType, name, hardness, DivineRPGTabs.BlocksTab);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, int harvest) {
        this(blockType, name, hardness, DivineRPGTabs.BlocksTab);
        setHarvestLevel("pickaxe", harvest);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, CreativeTabs tab) {
        super(blockType.getMaterial());
        this.setSoundType(blockType.getSound());
        this.setUnlocalizedName(name);
        this.setRegistryName(Reference.MODID, name);
        this.setHardness(hardness);
        this.setCreativeTab(tab);
    }
}