package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivineMerchant extends RenderLiving<EntityDivineMerchant> {

    private ResourceLocation texture;

    public RenderDivineMerchant(RenderManager renderManager, ModelBase model, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
    }

    protected ResourceLocation getEntityTexture(EntityDivineMerchant entity) {
        return texture;
    }

}
