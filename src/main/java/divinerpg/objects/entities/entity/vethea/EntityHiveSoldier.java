package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityHiveSoldier extends VetheaMob {

    public EntityHiveSoldier(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.8f);
        this.addAttackingAI();
    }

    @Override
    public int getSpawnLayer() {
        return 0;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_HIVE_SOLDIER;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HOVER_STINGER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HOVER_STINGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HOVER_STINGER_HURT;
    }
}