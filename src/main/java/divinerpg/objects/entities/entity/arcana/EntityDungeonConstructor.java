package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDungeonConstructor extends EntityDivineMob {

    private int angerLevel;

    public EntityDungeonConstructor(World world) {
        super(world);
        this.setSize(0.5F, 1.0F);
        this.angerLevel = 0;
        this.stepHeight = 1.0F;
    }

    @Override
    public float getEyeHeight() {
        return 0.9F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        if (this.getAttackTarget() != null) {
            this.faceEntity(this.getAttackTarget(), 100.0F, 100.0F);
        }

        if (!this.world.isRemote && this.isEntityAlive()) {
            if (this.getAttackTarget() != null) {
                if (this.getAttackTarget() instanceof EntityPlayer && this.angerLevel < 3) {
                    this.moveStrafing = this.moveForward = 0.0F;
                }
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CONSTRUCTOR_HURT;
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        par1Entity.playSound(SoundRegistry.CONSTRUCTOR_PUNCH, 1, 1);
        return super.attackEntityAsMob(par1Entity);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DUNGEON_CONSTRUCTOR;
    }
}