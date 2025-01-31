package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;

public class EntityEnthralledDramcryx extends EntityDivineMonster {
    public EntityEnthralledDramcryx(EntityType<? extends EntityEnthralledDramcryx> type, Level worldIn) {super(type, worldIn);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DRAMCRYX.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DRAMCRYX_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DRAMCRYX_HURT.get();}
    public static boolean enthralledDramcryxSpawnRule(ServerLevelAccessor worldIn, BlockPos pos) {
        return pos.getY() < 0 || worldIn.getBiome(pos).is(Biomes.DRIPSTONE_CAVES);
    }
    @Override public boolean isSteppingCarefully() {return true;}
}