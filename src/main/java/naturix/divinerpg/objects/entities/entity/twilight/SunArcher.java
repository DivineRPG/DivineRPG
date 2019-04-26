package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundSetupEvent;

public class SunArcher extends EntityDivineRPGMob implements IRangedAttackMob {
    
    private static final ItemStack defaultHeldItem = new ItemStack(ModItems.edenBow, 1);

    public SunArcher(World var1) {
        super(var1);
        //FIXME - TweakAI
//        this.tasks.addTask(4, new EntityAIArrowAttack(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 50, 10));
//        this.getNavigator().setAvoidsWater(true);
//        this.tasks.addTask(1, new EntityAISwimming(this));
//        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
//        this.tasks.addTask(9, new EntityAILookIdle(this));
//        this.tasks.addTask(6, new EntityAIWander(this, getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()*4));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.sunArcherHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.sunArcherDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.sunArcherSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.sunArcherFollowRange);
    }


    public Iterable<ItemStack> getHeldEquipment()
    {
        //FIXME - add default item
//        return new ItemStack(defaultHeldItem);
        return null;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/sun_archer");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
        EntityDivineArrow var2 = new EntityDivineArrow(this.world);
        var2.shoot(this.posX, this.posY, this.posZ, 1, 0.3f);
        //FIXME - Add sound
//        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(var2);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
        
    }


}