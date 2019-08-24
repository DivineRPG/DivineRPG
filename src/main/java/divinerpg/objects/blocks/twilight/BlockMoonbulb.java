package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModDoubleCrop;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockMoonbulb extends BlockModDoubleCrop {
    public BlockMoonbulb() {
        super("moonbulb_plant");
    }

    public Item getSeedDrop() {
        return ModSeeds.moonbulbSeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.moonbulb;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
}