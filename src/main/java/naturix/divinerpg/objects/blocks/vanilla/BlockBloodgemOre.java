package naturix.divinerpg.objects.blocks.vanilla;

import java.util.Random;

import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.material.EnumBlockType;
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