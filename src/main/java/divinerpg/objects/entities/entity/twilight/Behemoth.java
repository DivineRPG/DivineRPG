package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behemoth extends EntityDivineRPGMob {

    private BlockPos woodBlockToEat;
    private boolean shouldEat = false;
    private int ability;
    float moveSpeed = 1;

    public Behemoth(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1.2F);
    }

    @Override
    public float getEyeHeight() {
        return 0.7F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(180);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected void updateAITasks() {

        double minDistance = Double.MAX_VALUE;
        BlockPos minDistanceWoodPos = null;
        BlockPos currentPosition = this.getPosition();

        if (this.getHealth() < this.getMaxHealth() * 0.5 && !this.shouldEat) {
            for (int i = (int) this.posX - 16; i < (int) this.posX + 16; i++) {
                for (int j = (int) this.posZ - 16; j < (int) this.posZ + 16; j++) {
                    for (int n = (int) this.posY - 2; n < (int) this.posY + 2; n++) {
                        boolean isWood = this.world.getBlockState(new BlockPos(i, (int) this.posY, j))
                                .getMaterial() == Material.WOOD;
                        if (isWood) {
                            double distance = currentPosition.getDistance(i, n, j);
                            //System.out.println("Distance to target block: " + distance + " " + i + " " + n + " " + j);
                            if(distance < minDistance) {
                                minDistance = distance;
                                minDistanceWoodPos = new BlockPos(i, n, j);
                            }
                        }
                    }
                }
            }

            if(minDistanceWoodPos != null) {
                this.woodBlockToEat = minDistanceWoodPos;
                //System.out.println("Selected block pos: " + this.woodBlockToEat.toString());
                this.shouldEat = true;
            }
            else {
                this.shouldEat = false;
            }
        }

        if (this.shouldEat && this.getHealth() >= this.getMaxHealth() * 0.5)
            this.shouldEat = false;
        super.updateAITasks();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.shouldEat && this.world.getBlockState(this.woodBlockToEat)
                .getMaterial() != Material.WOOD)
            this.shouldEat = false;

        if (this.shouldEat && this.ability == 0) {
            double eatX = this.woodBlockToEat.getX();
            double eatY = this.woodBlockToEat.getY();
            double eatZ = this.woodBlockToEat.getZ();
            if (this.getDistance(eatX, eatY, eatZ) < 2) {
                this.heal(8.75F);
                this.world.destroyBlock(this.woodBlockToEat, false);
                this.world.playSound(null, this.woodBlockToEat, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.HOSTILE, 1.0F, 1.0F);
                this.shouldEat = false;
                this.ability = 5;
            } else {
                //System.out.println(eatX + " " + eatY + " " + eatZ + " " + this.getDistance(eatX, eatY, eatZ));
                this.getNavigator().tryMoveToXYZ(eatX, eatY, eatZ, moveSpeed);
                this.getLookHelper().setLookPosition(eatX, eatY, eatZ, 15F, 15F);
                this.setMoveForward(moveSpeed / 4);
            }
        } else if (this.shouldEat && this.ability > 0) {
            this.ability--;
            //System.out.println("Ability cooldown " + this.ability);
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENDIKU;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENDIKU_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENDIKU_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_BEHEMOTH;
    }
}