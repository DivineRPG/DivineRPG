package divinerpg.entities.vethea;

import com.google.common.collect.*;
import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

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
    protected ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<>();
        messages.addAll(ImmutableList.of("message.temple_guardian.1", "message.temple_guardian.2", "message.temple_guardian.3", "message.temple_guardian.4", "message.temple_guardian.5"));
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.temple_guardian";
    }
}