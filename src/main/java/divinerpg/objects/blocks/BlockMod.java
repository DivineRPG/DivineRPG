package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.BlockSoundTypeMap;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMod extends Block  {

    public BlockMod(String name, float hardness) {
        this(name, hardness, Material.ROCK);
    }

    public BlockMod(String name, float hardness, Material material) {
        this(name, hardness, material, DivineRPGTabs.BlocksTab);
    }

    public BlockMod(String name, float hardness, Material material, CreativeTabs tab) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(DivineRPG.MODID, name);
        this.setHardness(hardness);
        this.setCreativeTab(tab);
        this.setSoundType(BlockSoundTypeMap.soundTypeForMaterial(material));
    }


}