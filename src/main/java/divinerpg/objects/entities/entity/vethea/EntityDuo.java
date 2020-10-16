package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDuo extends VetheaMob {

    private static int ability;
    private final int SLOW = 0, FAST = 1;
    private int abilityCoolDown;
    float moveSpeed = 0.25F;

    public EntityDuo(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2f);
        this.addAttackingAI();
    }

    @Override
    protected void updateAITasks() {
        if (ability == SLOW && this.abilityCoolDown == 0) {
            ability = FAST;
            this.abilityCoolDown = 350;
            this.setAIMoveSpeed(moveSpeed * 3);
        }

        this.abilityCoolDown--;

        if (ability == FAST && this.abilityCoolDown == 0) {
            ability = SLOW;
            this.abilityCoolDown = 350;
            this.setAIMoveSpeed(moveSpeed);
        }

        super.updateAITasks();
    }


    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_DUO;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUO_HURT;
    }
}