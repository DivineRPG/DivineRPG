package divinerpg.objects.entities.entity.vethea;


import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDuo extends VetheaMob {


    public static int ability;
    private final int SLOW = 0, FAST = 1;

    private int abilityCoolDown;

    float moveSpeed = 0.25F;

    public EntityDuo(World par1) {
        super(par1);
        addAttackingAI();
        ability = SLOW;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public int getSpawnLayer() {
    	return 1;
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
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DUO_HURT;
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_DUO;
    }
}
