package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.DivineRPG;
import divinerpg.enums.EnumBlockType;
import divinerpg.enums.EnumToolType;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockMod extends Block implements IHasModel {

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
        this.setRegistryName(name);
        this.setHardness(hardness);
        this.setCreativeTab(tab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
