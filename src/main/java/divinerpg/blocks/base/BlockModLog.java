package divinerpg.blocks.base;

import divinerpg.*;
import divinerpg.entities.vethea.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockModLog extends RotatedPillarBlock {

    public BlockModLog(String name, MaterialColor color) {
        super(AbstractBlock.Properties.of(Material.WOOD, color).strength(2.0F).sound(SoundType.WOOD));
        setRegistryName(DivineRPG.MODID, name);
    }

    @Override
    public void playerDestroy(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity tileEntity, ItemStack stack) {
        if(this == BlockRegistry.dreamwoodLog || this == BlockRegistry.hyrewoodLog || this == BlockRegistry.hyrewoodLog || this == BlockRegistry.mintwoodLog) {
            if (world.isClientSide) {
                LivingEntity ent = new EntityEnt(EntityRegistry.ENT, world);
                ent.moveTo(pos, world.random.nextInt(360), 0);
                world.addFreshEntity(ent);
            }
        }
        super.playerDestroy(world, player, pos, state, tileEntity, stack);
    }
}