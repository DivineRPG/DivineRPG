package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behemoth extends EntityDivineRPGMob {
    
    public int eatX;
    public int eatY;
    public int eatZ;
    private boolean shouldEat = false;
    private int ability;
    float moveSpeed = 1;

    public Behemoth(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(1.2f, 1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.behemothHealth);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.behemothDamage);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.behemothSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.behemothFollowRange);
    }

    @Override
    protected void updateAITasks() {
        if (this.getHealth() < this.getMaxHealth() * 0.5 && !this.shouldEat) {
            for (int i = (int)this.posX - 16; i < (int)this.posX + 16; i++) {
                for (int j = (int)this.posZ - 16; j < (int)this.posZ + 16; j++) {
                    for(int n = (int)this.posY - 2; n < (int)this.posY + 2; n++) {
                        boolean var1 = this.world.getBlockState(new BlockPos(i, (int)this.posY, j)).getMaterial() == Material.WOOD;
                        if (var1) {
                            this.shouldEat = true;
                            this.eatX = i;
                            this.eatY = (int)this.posY;
                            this.eatZ = j;
                        }
                    }
                }
            }
        }
        if(this.shouldEat && this.getHealth() >= this.getMaxHealth() * 0.5) this.shouldEat = false;
        super.updateAITasks();
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        
        if(this.shouldEat && this.world.getBlockState(new BlockPos(this.eatX, this.eatY, this.eatZ)).getMaterial() != Material.WOOD) this.shouldEat = false;

        if(this.shouldEat && this.ability == 0) {
            if (this.getDistance(eatX, eatY, eatZ) < 2) {
                this.heal(70/8);
                this.world.setBlockState(new BlockPos(eatX, eatY, eatZ), Blocks.AIR.getDefaultState());
                this.shouldEat = false;
                this.ability = 5;
            } else {
                this.getNavigator().tryMoveToXYZ(eatX, eatY, eatZ, moveSpeed);
                this.getLookHelper().setLookPosition(eatX, eatY, eatZ, 15F, 15F);
                this.setMoveForward(moveSpeed / 4);
            }
        }
        else if (this.shouldEat && this.ability > 0) {
            this.ability--;
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.ENDIKU;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENDIKU_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENDIKU_HURT;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/behemoth");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }


    @Override
    public boolean isValidLightLevel() {
        return true;
    }

}