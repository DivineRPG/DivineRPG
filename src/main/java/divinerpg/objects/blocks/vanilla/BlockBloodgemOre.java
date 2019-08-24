package divinerpg.objects.blocks.vanilla;

import java.util.Random;

import divinerpg.enums.EnumBlockType;
import divinerpg.registry.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockBloodgemOre extends VanillaBlock {

    public BlockBloodgemOre(String name) {
        super(EnumBlockType.ROCK, name, 3.0F, 3);
        setResistance(2000.0F);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.bloodgem;
    }
}