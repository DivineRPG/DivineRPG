package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
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
        if (this.getHealth() < this.getMaxHealth() * 0.5 && !this.shouldEat) {
            for (int i = (int) this.posX - 16; i < (int) this.posX + 16; i++) {
                for (int j = (int) this.posZ - 16; j < (int) this.posZ + 16; j++) {
                    for (int n = (int) this.posY - 2; n < (int) this.posY + 2; n++) {
                        boolean isWood = this.world.getBlockState(new BlockPos(i, (int) this.posY, j))
                                .getMaterial() == Material.WOOD;
                        if (isWood) {
                            this.shouldEat = true;
                            this.eatX = i;
                            this.eatY = (int) this.posY;
                            this.eatZ = j;
                        }
                    }
                }
            }
        }
        if (this.shouldEat && this.getHealth() >= this.getMaxHealth() * 0.5)
            this.shouldEat = false;
        super.updateAITasks();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.shouldEat && this.world.getBlockState(new BlockPos(this.eatX, this.eatY, this.eatZ))
                .getMaterial() != Material.WOOD)
            this.shouldEat = false;

        if (this.shouldEat && this.ability == 0) {
            if (this.getDistance(eatX, eatY, eatZ) < 2) {
                this.heal(70 / 8);
                this.world.setBlockState(new BlockPos(eatX, eatY, eatZ), Blocks.AIR.getDefaultState());
                this.shouldEat = false;
                this.ability = 5;
            } else {
                this.getNavigator().tryMoveToXYZ(eatX, eatY, eatZ, moveSpeed);
                this.getLookHelper().setLookPosition(eatX, eatY, eatZ, 15F, 15F);
                this.setMoveForward(moveSpeed / 4);
            }
        } else if (this.shouldEat && this.ability > 0) {
            this.ability--;
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