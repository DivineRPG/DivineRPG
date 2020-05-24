package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivineVillager extends RenderLiving<EntityDivineRPGVillager> {

    private ResourceLocation texture;

    public RenderDivineVillager(RenderManager renderManager, ModelBase model, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
    }

    protected ResourceLocation getEntityTexture(EntityDivineRPGVillager entity) {
        return texture;
    }

}
