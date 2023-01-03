package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.tiles.chests.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import javax.annotation.*;

public class BlockEdenChest extends BlockModChest {

    public BlockEdenChest() {
        super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(15, 10000000), () -> BlockEntityRegistry.EDEN_CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new TileEntityEdenChest(p_153215_, p_153216_);
    }
}