package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityGifterNPC;
import divinerpg.registries.ItemRegistry;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityTempleGuardian extends EntityGifterNPC {

    public EntityTempleGuardian(EntityType<? extends MobEntity> type, World worldIn) {
    	super(type, worldIn);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.cermileLump, 10);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.temple_guardian.1", "message.temple_guardian.2", "message.temple_guardian.3", "message.temple_guardian.4", "message.temple_guardian.5" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.temple_guardian.name";
    }
}