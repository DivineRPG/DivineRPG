package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.EntityKaros;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockKarosAltar extends BlockVetheaAltar {
    public BlockKarosAltar() {
        super();
    }

    protected Item acceptedItem() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_flint"));
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack heldItemStack = player.getItemInHand(hand);

        if(!world.isClientSide && heldItemStack != null && heldItemStack.getItem() == acceptedItem()) {
            if (!player.isCreative()) {
                heldItemStack.shrink(1);
            }
            spawnBoss(world, pos.above());
        }
        else {
            onFailure();
        }

        return InteractionResult.PASS;
    }
    protected LivingEntity getBoss(Level world) {
        return new EntityKaros(EntityRegistry.KAROS.get(), world);
    }

    protected void onFailure() {
    }
}
