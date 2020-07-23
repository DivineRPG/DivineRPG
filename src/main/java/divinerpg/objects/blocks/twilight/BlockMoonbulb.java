package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModDoubleCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockMoonbulb extends BlockModDoubleCrop {
    public BlockMoonbulb() {
        super("moonbulb_plant");
    }

    public Item getSeedDrop() {
        return ItemRegistry.moonbulbSeeds;
    }

    public Item getFlowerDrop() {
        return ItemRegistry.moonbulb;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
}