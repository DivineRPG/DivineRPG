package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.assets.model.vethea.ModelQuadro;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.objects.entities.entity.twilight.cories.EntityAdvancedCori;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivineMob extends RenderLiving<EntityDivineRPGMob> {

    private ResourceLocation texture;

    public RenderDivineMob(RenderManager renderManager, ModelBase model, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
    }

    protected ResourceLocation getEntityTexture(EntityDivineRPGMob entity) {
        return texture;
    }

}
