package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityDensos extends EntityDivineBoss {

    public EntityDensos(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.5F);
    }

    @Override
    public float getEyeHeight() {
        return 2.0F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DENSOS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DENSOS_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DENSOS;
    }
}
