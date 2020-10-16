package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityLheiva extends VetheaMob {

    public EntityLheiva(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1.4f);
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        Entity var1 = source.getTrueSource();
        if (var1 != null && var1 instanceof EntityPlayer) {
            if (((EntityPlayer)var1).inventory.hasItemStack(new ItemStack(ItemRegistry.bandOfHeivaHunting)))
                return super.attackEntityFrom(source, par2);
        } else if(source == DamageSource.OUT_OF_WORLD) return super.attackEntityFrom(source, par2);
        return false;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_LHEIVA;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LHEIVA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LHEIVA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LHEIVA_HURT;
    }
}