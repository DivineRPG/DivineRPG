package divinerpg.objects.blocks;

import divinerpg.api.Reference;
import divinerpg.enums.EnumBlockType;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockMod extends Block  {
    boolean beaconBase;
    public BlockMod(String name, float hardness) {
        this(EnumBlockType.ROCK, name, hardness);
    }
    public BlockMod(String name, float hardness, boolean beaconBase) {
        this(EnumBlockType.ROCK, name, hardness);
        this.beaconBase = beaconBase;
    }
    public BlockMod(EnumBlockType blockType, String name, float hardness) {
        this(blockType, name, hardness, DivineRPGTabs.BlocksTab);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, int harvest, boolean beaconBase) {
        this(blockType, name, hardness, DivineRPGTabs.BlocksTab);
        setHarvestLevel("pickaxe", harvest);
        this.beaconBase = beaconBase;
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, CreativeTabs tab) {
        super(blockType.getMaterial());
        this.setSoundType(blockType.getSound());
        this.setUnlocalizedName(name);
        this.setRegistryName(Reference.MODID, name);
        this.setHardness(hardness);
        this.setCreativeTab(tab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon){
        return beaconBase;
    }
}