package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.EntityKaros;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockKarosAltar extends BlockVetheaAltar {
    public BlockKarosAltar() {
        super();
    }

    protected Item acceptedItem() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_flint"));
    }

    protected BlockPos findSafeBossSpawnPos(Level worldIn, BlockPos pos, int radius) {
        RandomSource rand = worldIn.random;
        BlockPos spawnPos;

        // Try up to 10 times to find a safe spawn position
        for (int i = 0; i < 10; i++) {
            int x = pos.getX() + rand.nextInt(radius * 2) - radius;
            int y = pos.getY();
            int z = pos.getZ() + rand.nextInt(radius * 2) - radius;
            spawnPos = new BlockPos(x, y, z);

            // Get the hitbox of the boss entity
            AABB bossHitbox = getBoss(worldIn).getBoundingBox().move(x, y, z);

            // Check if the spawn position is safe by checking if the boss entity's hitbox intersects with any blocks
            if (worldIn.noCollision(getBoss(worldIn), bossHitbox)) {
                return spawnPos;
            }
        }

        return null; // no safe spawn position found
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack heldItemStack = player.getItemInHand(hand);

        BlockPos bossSpawnPos = findSafeBossSpawnPos(world, pos, 10);
        if(bossSpawnPos != null && heldItemStack != null && heldItemStack.getItem() == acceptedItem()) {
            if (!player.isCreative()) {
                heldItemStack.shrink(1);
            }
            spawnBoss(world, bossSpawnPos.above());
            return InteractionResult.SUCCESS;
        } else {
            onFailure();
            return InteractionResult.PASS;
        }
    }

    protected LivingEntity getBoss(Level world) {
        return new EntityKaros(EntityRegistry.KAROS.get(), world);
    }

    protected void onFailure() {
    }
}
