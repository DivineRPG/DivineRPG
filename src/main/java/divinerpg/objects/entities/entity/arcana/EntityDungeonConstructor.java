package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDungeonConstructor extends EntityDivineRPGMob {

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
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(19.0D);
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
        return ModSounds.CONSTRUCTOR_HURT;
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        par1Entity.playSound(ModSounds.CONSTRUCTOR_PUNCH, 1, 1);
        return super.attackEntityAsMob(par1Entity);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_DUNGEON_CONSTRUCTOR;
    }
}