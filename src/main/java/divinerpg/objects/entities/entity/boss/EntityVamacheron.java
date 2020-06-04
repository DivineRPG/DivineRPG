package divinerpg.objects.entities.entity.boss;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class EntityVamacheron extends EntityDivineBoss {

    public EntityVamacheron(World worldIn) {
        super(worldIn);
        this.setSize(1.45F, 2.2F);
    }

    @Override
    public float getEyeHeight() {
        return 2.0F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27 * 1.5);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_VAMACHERON;
    }
    
    @Override
    public Color getBarColor() {
        return Color.RED;
    }
}
