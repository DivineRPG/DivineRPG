package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCaveCrawler extends EntityDivineMob {

    public EntityCaveCrawler(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 1.5F);
    }

    @Override
    public float getEyeHeight() {
        return 1.15F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CRAWLER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CRAWLER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CRAWLER_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_CAVE_CRAWLER;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY < 35.0D && super.getCanSpawnHere();
    }
}
