package divinerpg.objects.entities.assets.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

/**
 * Represents model that can render as item
 */
public abstract class ItemModel extends ModelBase {
    /**
     * Should render here without entity reference
     *
     * @param limbSwing
     * @param limbSwingAmount
     * @param ageInTicks
     * @param netHeadYaw
     * @param headPitch
     * @param scale
     */
    protected abstract void render(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale);

    public void render(float scale) {
        render(0, 0, 0, 0, 0, scale);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        render(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
}
