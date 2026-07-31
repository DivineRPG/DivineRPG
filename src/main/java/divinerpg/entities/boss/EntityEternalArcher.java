package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.arrows.FuryArrow;
import divinerpg.registries.ItemRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityEternalArcher extends EntityDivineBoss {
    private int armSelected;
    private int abilityTick;

    public EntityEternalArcher(EntityType<? extends EntityEternalArcher> type, Level worldIn) {super(type, worldIn);}
    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 80));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getTarget() != null) {
            this.getLookControl().setLookAt(this.getTarget().getX(),
                    this.getTarget().getY() + (double) this.getTarget().getEyeHeight(),
                    this.getTarget().getZ(), 10, 5);
        }

        if (this.getTarget() == null || this.random.nextInt(200) == 0) {
            this.setTarget(this.level().getNearestPlayer(this, 48D));
        }
        if (this.getTarget() != null && ((this.getTarget() instanceof Player
                && ((Player) this.getTarget()).isCreative())
                || !this.getTarget().isAlive())) {
            this.setTarget(null);
        }
        if (this.abilityTick > 0)
            this.abilityTick--;
        if (this.abilityTick == 0) {
            if (this.armSelected < 5)
                this.armSelected++;
            else if (this.armSelected == 5)
                this.armSelected = 0;
            this.abilityTick = 400;
        }

        if (this.abilityTick % 20 == 0 && this.getTarget() != null && !this.level().isClientSide() && getTarget() != null) {
            LivingEntity target = getTarget();
            if(isAlive() && target != null) {
                FuryArrow abstractarrow = new FuryArrow(level(), this, new ItemStack(ItemRegistry.fury_arrow.get()), new ItemStack(ItemRegistry.apalachia_bow.get()));
                abstractarrow.powerMultiplier = 2F;
                abstractarrow.igniteForTicks(Integer.MAX_VALUE >> 1);
                double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
                abstractarrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
                playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
                level().addFreshEntity(abstractarrow);
            }
        }
    }

    public int getSelectedArm() {
        return this.armSelected;
    }

}