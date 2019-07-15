package naturix.divinerpg.objects.entities.entity.arcana;


import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Dramix extends EntityDivineRPGBoss {


    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/dramix");

    private ResourceLocation deathLootTable = LOOT;

    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}
        private int firetick;

        public Dramix(World var1) {
            super(var1);
            setSize(0.85f, 3);
            addAttackingAI();
            this.isImmuneToFire = true;
        }

        @Override
        protected void applyEntityAttributes() {
            super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.dramixHealth);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.dramixDamage);
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.dramixSpeed);
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.dramixFollowRange);
            this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1);
        }
        

        @Override
        public void onLivingUpdate() {

            if(this.ticksExisted%600 < 300) this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 5, 0, true, false));

            super.onLivingUpdate();
        }

        @Override
        protected SoundEvent getAmbientSound() {
            return ModSounds.DRAMIX;
        }

        @Override
        protected SoundEvent getHurtSound(DamageSource s) {
            return ModSounds.DRAMIX_HURT;
        }

        @Override
        protected SoundEvent getDeathSound() {
            return ModSounds.DRAMIX_HURT;
        }

        @Override
        public void dropFewItems(boolean par1, int par2) {
            this.dropItem(ModItems.dungeonTokens, 5);
        }

    }
